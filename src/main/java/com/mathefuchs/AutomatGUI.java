package com.mathefuchs;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class provides the UI of an automat.
 *
 * @author Tobias Fuchs
 * @version 09/14/16
 */
public class AutomatGUI implements ActionListener {
    private Fahrscheinautomat fahrscheinAutomat;

    private JFrame fenster;
    private JPanel automatPanel;
    private JPanel ausgabePanel;
    private JLabel ausgabe;
    private JButton typ1;
    private JButton typ2;
    private JButton typ3;
    private JButton cent5;
    private JButton cent10;
    private JButton cent20;
    private JButton cent50;
    private JButton cent100;
    private JButton cent200;
    private JButton abbrechen;

    /**
     * Initializes a new AutomatGUI.
     */
    public AutomatGUI() {
        this.fahrscheinAutomat = new Fahrscheinautomat();

        this.fenster = new JFrame("Fahrscheinautomat");
        this.fenster.setSize(575, 925);
        this.fenster.setLocation(10, 10);
        this.fenster.setLayout(null);
        this.fenster.setResizable(true);
        this.fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenster.setVisible(true);

        this.automatPanel = new JPanel();
        this.fenster.add(this.automatPanel);
        this.automatPanel.setLayout(null);
        this.automatPanel.setBounds(25, 25, 500, 800);
        this.automatPanel.setBackground(Color.gray);

        this.ausgabePanel = new JPanel();
        this.automatPanel.add(this.ausgabePanel);
        this.ausgabePanel.setLayout(null);
        this.ausgabePanel.setBounds(25, 25, 450, 150);
        this.ausgabePanel.setBackground(Color.white);

        this.ausgabe = new JLabel(this.fahrscheinAutomat.getAnzeige().getBotschaft(), SwingConstants.CENTER);
        this.ausgabePanel.add(this.ausgabe);
        this.ausgabe.setBounds(0, 0, 450, 150);

        this.typ1 = new JButton("Fahrkarte 1 - 145 Cent");
        this.automatPanel.add(this.typ1);
        this.typ1.setActionCommand("f 1");
        this.typ1.setBounds(25, 225, 200, 100);
        this.typ1.setBackground(Color.LIGHT_GRAY);
        this.typ1.addActionListener(this);

        this.typ2 = new JButton("Fahrkarte 2 - 185 Cent");
        this.automatPanel.add(this.typ2);
        this.typ2.setActionCommand("f 2");
        this.typ2.setBounds(25, 375, 200, 100);
        this.typ2.setBackground(Color.LIGHT_GRAY);
        this.typ2.addActionListener(this);

        this.typ3 = new JButton("Fahrkarte 3 - 220 Cent");
        this.automatPanel.add(this.typ3);
        this.typ3.setActionCommand("f 3");
        this.typ3.setBounds(25, 525, 200, 100);
        this.typ3.setBackground(Color.LIGHT_GRAY);
        this.typ3.addActionListener(this);

        this.cent5 = new JButton("5 Cent");
        this.automatPanel.add(this.cent5);
        this.cent5.setActionCommand("c 5");
        this.cent5.setBounds(275, 375, 100, 100);
        this.cent5.setBackground(Color.yellow);
        this.cent5.addActionListener(this);

        this.cent10 = new JButton("10 Cent");
        this.automatPanel.add(this.cent10);
        this.cent10.setActionCommand("c 10");
        this.cent10.setBounds(375, 375, 100, 100);
        this.cent10.setBackground(Color.yellow);
        this.cent10.addActionListener(this);

        this.cent20 = new JButton("20 Cent");
        this.automatPanel.add(this.cent20);
        this.cent20.setActionCommand("c 20");
        this.cent20.setBounds(275, 525, 100, 100);
        this.cent20.setBackground(Color.yellow);
        this.cent20.addActionListener(this);

        this.cent50 = new JButton("50 Cent");
        this.automatPanel.add(this.cent50);
        this.cent50.setActionCommand("c 50");
        this.cent50.setBounds(375, 525, 100, 100);
        this.cent50.setBackground(Color.yellow);
        this.cent50.addActionListener(this);

        this.cent100 = new JButton("1€");
        this.automatPanel.add(this.cent100);
        this.cent100.setActionCommand("c 100");
        this.cent100.setBounds(275, 675, 100, 100);
        this.cent100.setBackground(Color.yellow);
        this.cent100.addActionListener(this);

        this.cent200 = new JButton("2€");
        this.automatPanel.add(this.cent200);
        this.cent200.setActionCommand("c 200");
        this.cent200.setBounds(375, 675, 100, 100);
        this.cent200.setBackground(Color.yellow);
        this.cent200.addActionListener(this);

        this.abbrechen = new JButton("Abbrechen");
        this.automatPanel.add(this.abbrechen);
        this.abbrechen.setActionCommand("a 0");
        this.abbrechen.setBounds(25, 675, 200, 100);
        this.abbrechen.setBackground(Color.red);
        this.abbrechen.addActionListener(this);
    }

    /**
     * Handles the actionPerformed event.
     *
     * @param e the actionEvent arguments
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] command = e.getActionCommand().split(" ");

        if (command.length == 2) {
            if (command[0].equals("a")) {
                this.fahrscheinAutomat.abbrechen();
            } else if (command[0].equals("f")) {
                this.fahrscheinAutomat.waehleFahrschein(Integer.parseInt(command[1]));
            } else if (command[0].equals("c")) {
                this.fahrscheinAutomat.muenzEinwurf(Integer.parseInt(command[1]));
            }

            this.ausgabe.setText(this.fahrscheinAutomat.getAnzeige().getBotschaft());
        }
    }
}