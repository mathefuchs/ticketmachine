package com.mathefuchs;

/**
 * Klasse zur Modellierung eines Muenzprüfers eines Fahrkartenautomaten Münzen
 * sind gültig, wenn sie einen Wert von 5,10,20,50,100 oder 200 Cent haben
 *
 * @author R.Punkenburg
 * @version 2.2.2006
 */
public class Muenzpruefer {

    /**
     * Methode zum Prüfen eines Münzwertes
     *
     * @param wert der
     *             Wert der zu prüfenden Münze
     * @return Wert der Münze, falls der Münzwert gültig ist, sonst 0
     */
    protected int pruefe(int wert) {
        if (wert == 5 || wert == 10 || wert == 20 || wert == 50 || wert == 100 || wert == 200) {
            return wert;
        } else {
            return 0;
        }
    }
}