# Protokoll 6 (09.04.2019)

Name: Breitenthaler Lorenz  
Klasse: 4ahme  
KNR: 1  
Gruppe: 1

---
## Inhalte
1. Temperatursensor Specifikationen
2. Konfiguration der Register
3. Kalibrierung
---


## 1. Temperatursensor Specifikationen   


|Temperatur|-45°   |25°    | 85°  |
|----------|-------|-------|------|
| Spannung |242 mV | 314 mV|380 mV|
|  ADCH    | 56,79 | 73,08 |88,4  |


## 2. Konfiguration der Register  

Um passende Ergebnisse zu bekommen muss der Microcontroler richtig konfiguriert
werden (Register passend beschreiben). Alle Registerbeschreibungen können im Datenblatt
unter dem Karpitel "ADC" nachgelesen werden.  

```C
void app_init (void) {  
  memset((void * )&app, 0, sizeof(app));  
  ADMUX = 8; //Um den Multiplexer im ADC auf den Temperatursensor zu legen    
  ADMUX |= (1 << REFS1) | (1 << REFS0); // Die Referenzspannung für die Abtastung wird auf die Interne 1.1 Volt Referenz gelegt
  ADMUX |= (1 << ADLAR); //Um den 10Bit Wert im 16 Bit Register Linksbündig abzulegen  

  ADCSRA |= (1 << ADEN) | 7; //Stellt die Abtastfrequenz im ADC auf 125 kHz (Prescaler)   
  ADCSRB = 0; //Zur sicherheit  
}  
```


## 3. Kalibrierung

Um die Daten aus dem ADCH Register in eine Temperatur um zu rechen, wird eine Formel benötigt.
Da diese einen linearen Zusammenhand besitzen, kann dessen Grundform "y = k*x + d" verwendet werden.  
--> T = ADCH * k + d

Aus den folgenden Messwerten ergibt sich für k der Wert 1024 und für d 96000;

|gemessen| Temperatur|
|--------|-----------|
|68      |	-11520	 |
|87      |	6400	   |
|102     |	21760	   |

Umsetzung in C:
```C
void app_main (void) {
   ADCSRA |= (1 << ADSC);
   _delay_ms(1);

   int16_t mbInputRegister;
   int32_t k = 1024;
   int32_t d = -96000;

   int32_t x = k * ADCH + d;

   if(x > 32768){
      mbInputRegister = 32768;
   } else if(x < -32768) {
      mbInputRegister = -32768;
   } else {
      mbInputRegister = (int16_t)x;
   }

   printf("ADCH --> %u    Reg 1: %d\r",ADCH, mbInputRegister);
}

```
