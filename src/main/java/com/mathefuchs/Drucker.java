package com.mathefuchs;

import javax.swing.JOptionPane;

/**
 * Klasse zur Modellierung eines Fahrscheindruckers eines Fahrkartenautomaten
 *
 * @author R.Punkenburg
 * @version 2.2.2006
 */
public class Drucker {
    private int leerFormulare;

    /**
     * Konstruktor für Objekte der Klasse Drucker
     */
    protected Drucker() {
        this.leerFormulare = 5;
    }

    /**
     * Methode zum Drucken eines Fahrscheines
     *
     * @param preis       der Preis des Fahrscheines
     * @param rueckBetrag das Rückgeld
     */
    protected void druckeFahrschein(int preis, int rueckBetrag) {
        JOptionPane.showMessageDialog(null,
                "Ihr Fahrschein, Preis: " + preis + " Cent\nIhr Rückgeld: " + rueckBetrag + " Cent", "Fahrschein",
                JOptionPane.INFORMATION_MESSAGE);
        this.leerFormulare--;
    }

    /**
     * Methode zum Prüfen, ob keine Fahrscheinformulare mehr vorhanden sind
     *
     * @return true, falls keine Fahrscheinformulare mher vorhanden sind, sonst
     * false
     */
    protected boolean leer() {
        return (this.leerFormulare == 0);
    }
}