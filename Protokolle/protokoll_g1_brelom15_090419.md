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


|Temperatur|-45°C  |25°C   | 85°C |
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
  ADMUX = 8;     
  ADMUX |= (1 << REFS1) | (1 << REFS0);
  ADMUX |= (1 << ADLAR); //Um den 10Bit Wert im 16 Bit Register Linksbündig abzulegen  

  ADCSRA |= (1 << ADEN) | 7; //Stellt die Abtastfrequenz im ADC auf 125 kHz (Prescaler)   
  ADCSRB = 0; //Zur sicherheit  
}  
```

**Beschreibung:**  
ADMUX wird auf 8 gesetzt um den Multiplexer im ADC auf den Temperatursensor zu legen.  
Um anschließend die Referenzspannung auf die internen Referenz zu stellen wuss das REFS1 und das REFS0 bit gesetzt werden.  
Da der 10 Bit Wert im 16 Bit Register linksbündig abgespeichert werden soll, muss das ADLAR Bit gesetzt werden.  
Abschließnd muss das ADCSRA Register noch verändert werden, um die Abtastfrequenz auf dir gewünschten 125 kHz zu stellen.  


## 3. Kalibrierung

Um die Daten aus dem ADCH Register in eine Temperatur um zu rechen, wird eine Formel benötigt.
Da diese einen linearen Zusammenhand besitzen, kann dessen Grundform "y = k*x + d" verwendet werden.  
--> T = ADCH * k + d

Aus den folgenden Messwerten ergibt sich für k der Wert 1024 und für d -82688;

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
   int32_t d = -82688;

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

**Beschreibung:**  
Als Erstes muss das ADSC Bit im ADCSRA Register gesetzt werden um die Konversation mit dem ADC zu starten.
Anschließend wird mit Hilfe der obig berechneten Formel der Wert berechnet der letztlich über Modbus übertragen wird.
Falls die Werte die maxialen Werte des 32 Bit Integers überschreiten, werden diese auf die maximal zulässigen überschrieben.
