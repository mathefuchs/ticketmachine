package com.mathefuchs;

/**
 * Anzeige für den Automaten.
 *
 * @author Tobias Fuchs
 * @version 09/14/16
 */
public class Anzeige {
    private static final String resetString = "Bitte Fahrschein wählen.";
    private String botschaft;

    /**
     * Initialisiert eine neue Anzeige.
     */
    public Anzeige() {
        this.reset();
    }

    /**
     * Resetet die Anzeige.
     */
    public void reset() {
        this.botschaft = resetString;
    }

    /**
     * Gibt die Botschaft zurück.
     *
     * @return die Botschaft
     */
    public String getBotschaft() {
        return this.botschaft;
    }

    /**
     * Setzt die Botschaft.
     *
     * @param botschaft die Botschaft zum setzen
     */
    public void setBotschaft(String botschaft) {
        this.botschaft = botschaft;
    }
}