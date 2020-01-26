# Einheit 3
Klasse: 5AHME  
Datum: 16.12.2019  
Gruppe: 1  
Lehrer: Der  

---  
## Themen  

* Testen der Hardware (Alle Eingänge und Ausgänge) mittels der an der SPS angeschlossenen Taster  
* Zur Überprüfung des Programms sollte dieses Einheit für Einheit mittels des monitoring Modes Getestet werden  
* Monitoring Mode: Ist eine Art debugger in welchem alle Variablen und Ein/Ausgänge mit dem jeweiligem Zustand aufgelistet sind. Diese werden Live mit der SPS synchronisiert.  
* Beschreibung des Programms (Rechnungen, Funktionsblöcke): Fördert die Lesbarkeit und Verständlichkeit eines Programms enorm.  

## Aufgaben  

In den Nächsten Einheiten soll ein Rührwerk mittels einer SPS, einem Motor, zweier Taster, einer Lampe und einem Induktiven Näherungsschalter realisiert werden. Der mechanische Aufbau der Anlage steht bereits zur verfügung es muss lediglich ein Programm, mittels der Sprache KOP, dazu entwickelt werden.  

 Die Anlage soll nach Beendigung des Programms folgende Funktionen aufweisen: 
* Ein / Ausschalten des Werkes mit Signalisierung durch eine Lampe  
* Motor soll immer an der selben Stelle stehen bleiben  
* Bei Fehlern soll die Lampe blinken (z.B.: Kein Sensorsignal) und der Motor stoppen  
* Drehzahlüberwachung  

Programm:  
* OB1 --> Baustein den das System aufruft (Zyklischer Ablauf)  
* Erstellung eines Test Programms --> Motor dreht sich wenn Taster gedrückt  
* Anlegen der Variablen mit passender Bezeichnung und Vorgeschriebener Adresse  
* Überspielen des Programms in die SPS  

## Ergebnis  

Es wurde ein Programm erstellt welches den Motor mittels der Schließung des Tasters "Ein" zum laufen bringt und ihn beim los lassen des Schalters stehen lässt.  
Des weiteren wurde das Programm so erweitert, dass im Falle eines Fehlers die Status lampe zu blinken beginnt.
Dies wurde mittels eines TON Bausteins realisiert welcher den Motor nach einer bestimmten Zeit, in welcher der Induktiven Näherungsschalter kein Signal empfangen darf, stoppt und die Lampe zum blinken bringt.  
Soloch ein Fehler kann durch die Betätigung des Stop Tasters quitiert werden.

## Materialien  
* SPS  
* PC  
* Rührwerkminiatur  
## Werkzeuge Geräte und Software  
* Steuerung   
Tia Portal  

## Unterlagen  
