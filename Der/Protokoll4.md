# Einheit 4
Klasse: 5AHME  
Datum: 13.01.2019  
Gruppe: 1  
Lehrer: Der  

---  
## Themen  

* Beendigung des Rührwerkprogramms  

## Aufgabenstellung  

In den Nächsten Einheiten soll ein Rührwerk mittels einer SPS, einem Motor, zweier Taster, einer Lampe und einem Induktiven Näherungsschalter realisiert werden. Der mechanische Aufbau der Anlage steht bereits zur verfügung es muss lediglich ein Programm, mittels der Sprache KOP, dazu entwickelt werden.  

 Die Anlage soll nach Beendigung des Programms folgende Funktionen aufweisen: 
* Ein / Ausschalten des Werkes mit Signalisierung durch eine Lampe  
* Motor soll immer an der selben Stelle stehen bleiben  
* Bei Fehlern soll die Lampe blinken (z.B.: Kein Sensorsignal) und der Motor stoppen  
* Drehzahlüberwachung  

## Ergebnis  

In dieser Einheit wurde das zu erstellende Programm mittels der noch fehlenden Komponente, der Drezahlüberwachung, beendigt.
Dies wurde mittels der Information des Induktiven Näherungsschalters und der benötigten Zeit realisiert. 
Dabei gilt : `n = 1/t.`  
Hierfür wird jedes mal wenn der Induktiven Näherungsschalter ein Signal empfängt ein TON Baustein aktiviert. 
Anschließend wird jene Zeit in einer Variable gespeichert, die der Baustein gespeichert hat bevor er wieder auf Nul gesetzt wird.
Danach wird dieser Wert in die oben angegebene Formel eingetragen und mittels der Mathematik Bausteine berechnet.  

## Materialien  
* SPS  
* PC  
* Rührwerkminiatur  
## Werkzeuge Geräte und Software  
* Steuerung   
Tia Portal  

## Unterlagen  
