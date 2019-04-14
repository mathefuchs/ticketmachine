package com.mathefuchs;

/**
 * Klasse zur Modellierung eines Geldkassetter eines Fahrkartenautomaten Münzen
 * sind gültig, wenn sie einen Wert von 5,10,20,50,100 oder 200 Cent haben
 *
 * @author R.Punkenburg
 * @version 2.2.2006
 */
public class Geldkassette {
    // Anzahl der jeweiligen Münze in der Geldkassetter
    private int n5;
    private int n10;
    private int n20;
    private int n50;
    private int n100;
    private int n200;

    /**
     * Konstruktor für die Klasse Geldkassette
     */
    public Geldkassette() {
        // keine Münzen in der Geldkassette
        this.n5 = 0;
        this.n10 = 0;
        this.n20 = 0;
        this.n50 = 0;
        this.n100 = 0;
        this.n200 = 0;
    }

    /**
     * Returns the n5.
     *
     * @return the n5
     */
    public int getN5() {
        return this.n5;
    }

    /**
     * Returns the n10.
     *
     * @return the n10
     */
    public int getN10() {
        return this.n10;
    }

    /**
     * Returns the n20.
     *
     * @return the n20
     */
    public int getN20() {
        return this.n20;
    }

    /**
     * Returns the n50.
     *
     * @return the n50
     */
    public int getN50() {
        return this.n50;
    }

    /**
     * Returns the n100.
     *
     * @return the n100
     */
    public int getN100() {
        return this.n100;
    }

    /**
     * Returns the n200.
     *
     * @return the n200
     */
    public int getN200() {
        return this.n200;
    }

    /**
     * Methode erhöht die Anzahl der Münzen in der Geldkassette um Eins, welche
     * Eingeworfen wurde
     *
     * @param wert Wert von 5,10,20,50,100 oder 200 Cent für eine Münze
     */
    protected void fuellen(int wert) {
        if (wert == 5) {
            this.n5++;
        } else if (wert == 10) {
            this.n10++;
        } else if (wert == 20) {
            this.n20++;
        } else if (wert == 50) {
            this.n50++;
        } else if (wert == 100) {
            this.n100++;
        } else {
            this.n200++;
        }
    }
}