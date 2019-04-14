package com.mathefuchs;

/**
 * Klasse zur Modellierung eines Münzschachtes.
 *
 * @author R.Punkenburg
 * @version 22.1.2006
 */
public class Muenzschacht {
    private int anzahl; // Anzahl der Münzen im Schacht
    private String typ; // Sorte der Münzen im Schacht

    /**
     * Konstruktor für Objekte der Klasse Muenzschacht; Bei der Instanzierung
     * ist er mit 5 Münzen gefüllt
     *
     * @param typ Sorte der Münzen im Schacht
     */
    public Muenzschacht(String typ) {
        this.anzahl = 5;
        this.typ = typ;
    }

    /**
     * Methode, die das Auswerfen von Münzen darstellt.
     */
    public void auswerfen() {
        this.anzahl = this.anzahl - 1;
    }

    /**
     * Gibt den Typ zurück.
     *
     * @return der Typ
     */
    public String getTyp() {
        return this.typ;
    }

    /**
     * Methode zum Abfragen der aktuellen Anzahl der vorhandenen Münzen
     *
     * @return Anzahl der Münzen im Schacht
     */
    protected int getAnzahl() {
        return this.anzahl;
    }

    /**
     * Methode zum Erhöhen aktuellen Anzahl der vorhandenen Münzen.
     */
    protected void aufstocken() {
        this.anzahl = this.anzahl + 1;
    }
}