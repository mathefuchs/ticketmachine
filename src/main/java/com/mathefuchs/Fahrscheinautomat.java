package com.mathefuchs;

import javax.swing.JOptionPane;

/**
 * Klasse Fahrscheinautomat.
 *
 * @author R. Punkenburg
 * @version 2.2.2006
 */
public class Fahrscheinautomat {
    private int fahrscheinWert;
    private boolean fahrscheinGewaehlt;
    private int summe;

    private Anzeige anzeige;
    private Muenzpruefer muenzpruefer;
    private Drucker drucker;
    private Muenzschacht muenzen5;
    private Muenzschacht muenzen10;
    private Muenzschacht muenzen20;
    private Muenzschacht muenzen50;
    private Muenzschacht muenzen100;
    private Muenzschacht muenzen200;
    private Geldkassette geldkassette;

    /**
     * Konstruktor für Objekte der Klasse Fahrscheinautomat; Es ist kein
     * Fahrschein gewählt; Es ist keine Münze eingeworfen worden.
     */
    public Fahrscheinautomat() {
        this.fahrscheinWert = 0;
        this.fahrscheinGewaehlt = false;
        this.summe = 0;

        this.anzeige = new Anzeige();
        this.muenzpruefer = new Muenzpruefer();
        this.drucker = new Drucker();
        this.muenzen5 = new Muenzschacht("5");
        this.muenzen10 = new Muenzschacht("10");
        this.muenzen20 = new Muenzschacht("20");
        this.muenzen50 = new Muenzschacht("50");
        this.muenzen100 = new Muenzschacht("100");
        this.muenzen200 = new Muenzschacht("200");
        this.geldkassette = new Geldkassette();
    }

    /**
     * Gibt die Anzeige zurück.
     *
     * @return die Anzeige
     */
    public Anzeige getAnzeige() {
        return this.anzeige;
    }

    /**
     * Methode zum Verarbeiten der eingeworfenen Münzen; nur wenn ein Fahrschein
     * gewählt worden ist, werden Münzeinwürfe akzeptiert; wenn ausreichend
     * Münzen eingeworfen worden sind, wird der Vorgang abgearbeitet.
     *
     * @param wert Wert der eingeworfenen Münze
     */
    public void muenzEinwurf(int wert) {
        // prüfen, ob Fahrschein gewählt wurde
        if (!this.fahrscheinGewaehlt) {
            this.anzeige.setBotschaft("Bitte zunächst einen Fahrschein wählen!");
            return; // keine weitere Verarbeitung
        }

        // Münze prüfen, falls ungültig Methode abbrechen
        if (this.muenzpruefer.pruefe(wert) == 0) {
            this.anzeige.setBotschaft(
                    "Eingeworfene Münze ist ungültig! Sie haben bisher insgesamt " + this.summe + " Cent eingeworfen.");
            return;
        }

        // Münze verbuche
        this.verbucheMuenze(wert);

        // nächste Münze annehmen
        this.summe += wert;

        // summe nicht ausreichend
        if (this.summe < this.fahrscheinWert) {
            this.anzeige.setBotschaft("Noch zu zahlen: " + (this.fahrscheinWert - this.summe) + " Cent");
        }
        // summe ausreichend
        else {
            this.drucker.druckeFahrschein(this.fahrscheinWert, this.summe - this.fahrscheinWert);
            this.ausgebenWechselgeld(this.summe - this.fahrscheinWert);
            // Attribute zurücksetzen
            this.fahrscheinGewaehlt = false;
            this.fahrscheinWert = 0;
            this.summe = 0;
            this.anzeige.reset();
        }
    }

    /**
     * Methode zum Auswählen des Fahrscheins; Typ = 1 : Fahrschein für 145 Cent;
     * Typ = 2 : Fahrschein für 185 Cent; Typ = 3 : Fahrschein für 220 Cent;
     * alle anderen Eingaben sind ungültig
     *
     * @param typ Typ des Fahrscheins
     */
    public void waehleFahrschein(int typ) {
        if (this.drucker.leer()) {
            this.anzeige.setBotschaft("Der Automat ist außer Betrieb!");
            return; // Methode abbrechen
        }

        if (this.fahrscheinGewaehlt) {
            this.abbrechen();
        }

        if (typ == 1) {
            this.fahrscheinGewaehlt = true;
            this.fahrscheinWert = 145;
            this.anzeige.setBotschaft("Sie möchten einen Fahrschein für 1,45 Euro.");
        } else if (typ == 2) {
            this.fahrscheinGewaehlt = true;
            this.fahrscheinWert = 185;
            this.anzeige.setBotschaft("Sie möchten einen Fahrschein für 1,85 Euro.");
        } else if (typ == 3) {
            this.fahrscheinGewaehlt = true;
            this.fahrscheinWert = 220;
            this.anzeige.setBotschaft("Sie möchten einen Fahrschein für 2,20 Euro.");
        } else {
            this.fahrscheinGewaehlt = false;
            this.fahrscheinWert = 0;
            this.anzeige.setBotschaft("Ungültige Fahrscheinwahl!");
        }
    }

    /**
     * Methode zum Abbrechen eines laufenden Vorgangs; evtl. bereits
     * eingeworfene Geld wird zurückgegeben; kein Fahrschein ist gewählt
     */
    public void abbrechen() {
        if (!this.fahrscheinGewaehlt) {
            return; // nichts tun, weil nichts rückgängig zu machen ist
        }

        if (this.summe > 0) {
            JOptionPane.showMessageDialog(null, " Sie erhalten " + this.summe + " Cent zurück.", "Abbruch",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        this.fahrscheinGewaehlt = false;
        this.fahrscheinWert = 0;
        this.summe = 0;
        this.anzeige.reset();
    }

    /**
     * Methode zum Verbuchen der Münzen; 5, 10, 20, 50, 100 und 200 Cent Münzen
     * werder verbuch falsche Münzen müssen vorher erkann worden sein
     */
    private void verbucheMuenze(int wert) {
        if (wert == 5) {
            if (this.muenzen5.getAnzahl() < 10) {
                this.muenzen5.aufstocken();
            } else {
                this.geldkassette.fuellen(5);
            }
        } else if (wert == 10) {
            if (this.muenzen10.getAnzahl() < 10) {
                this.muenzen10.aufstocken();
            } else {
                this.geldkassette.fuellen(10);
            }
        } else if (wert == 20) {
            if (this.muenzen20.getAnzahl() < 10) {
                this.muenzen20.aufstocken();
            } else {
                this.geldkassette.fuellen(20);
            }
        } else if (wert == 50) {
            if (this.muenzen50.getAnzahl() < 10) {
                this.muenzen50.aufstocken();
            } else {
                this.geldkassette.fuellen(50);
            }
        } else if (wert == 100) {
            if (this.muenzen100.getAnzahl() < 10) {
                this.muenzen100.aufstocken();
            } else {
                this.geldkassette.fuellen(100);
            }
        } else if (this.muenzen200.getAnzahl() < 10) {
            this.muenzen200.aufstocken();
        } else {
            this.geldkassette.fuellen(200);
        }
    }

    /**
     * Methode zur Ausgabe des Wechselgelds; Wechselgeld wird in 5, 10, 20, 50,
     * 100 oder 200 Cent Münzen ausgegeben
     */
    private void ausgebenWechselgeld(int wechselgeld) {
        while (wechselgeld > 0) {
            if (wechselgeld >= 200) {
                this.muenzen200.auswerfen();
                wechselgeld -= 200;
            } else if (wechselgeld >= 100) {
                this.muenzen100.auswerfen();
                wechselgeld -= 100;
            } else if (wechselgeld >= 50) {
                this.muenzen50.auswerfen();
                wechselgeld -= 50;
            } else if (wechselgeld >= 20) {
                this.muenzen20.auswerfen();
                wechselgeld -= 20;
            } else if (wechselgeld >= 10) {
                this.muenzen10.auswerfen();
                wechselgeld -= 10;
            } else {
                this.muenzen5.auswerfen();
                wechselgeld -= 5;
            }
        }
    }
}
