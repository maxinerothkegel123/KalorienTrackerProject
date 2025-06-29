package projekt_maxine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class KalorienTracker {
    private JPanel panel1;
    private JComboBox coBo_menü;
    private JLabel label_menü;
    private JLabel label_uhrzeit;
    private JTextField textField_uhrzeit;
    private JButton button_hinzufügen;
    private JLabel label_essenskategorie;
    private JComboBox CoBo_essenskategorie;
    private JLabel jlabel_menüzusammenfassung;
    private JTextArea textArea_ausgabe1;
    private JButton button_berechne;
    private JLabel label_Gesamtkalorien;
    private JTextArea textArea_Gesamtkalorien;
    private JButton button_löschen;

    //liste zur speicherung aller mahlzeiten
    private List<Mahlzeit> mahlzeitenListe = new ArrayList<>();

    public KalorienTracker() {
        //initiale objekte hinzufügen
        initObjekte();
        //anzeige der bestehenden Mahlzeiten
        anzeigenMahlzeiten();



        button_berechne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String ausgabe = "";
           int gesamtkalorien = 0;

            for (Mahlzeit m : mahlzeitenListe) {
             ausgabe += m.toString() + "\n\n";
             gesamtkalorien += m.getKalorien(); //alle kalorien zusammenzählen
                }

            if (gesamtkalorien > 500) {
                textArea_ausgabe1.setText(ausgabe);
                textArea_Gesamtkalorien.setText(gesamtkalorien + "kcal");
            } else {
                JOptionPane.showMessageDialog(null, "Selbst der Code braucht mehr Energie als das, iss mehr:)");
                textArea_ausgabe1.setText("");
                textArea_Gesamtkalorien.setText("");
            }
            }
        });
        button_hinzufügen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             hinzufügen();
             anzeigenMahlzeiten();

            }
        });
        button_löschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mahlzeitenListe.clear();
                textArea_ausgabe1.setText("");
                textArea_Gesamtkalorien.setText("0kcal");
               JOptionPane.showMessageDialog(null,"Alle Einträge wurden gelöscht");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("KalorienTracker");
        KalorienTracker tracker = new KalorienTracker();
        frame.setContentPane(tracker.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void initObjekte() {
        mahlzeitenListe.add(new Mahlzeit("Proteinshake", 203, LocalDateTime.now(), "Snack"));
        mahlzeitenListe.add(new Mahlzeit("Hähnchen und Reis", 415, LocalDateTime.now(), "Mittagessen"));
        mahlzeitenListe.add(new Mahlzeit("Ceasar Salat", 545, LocalDateTime.now(), "Abendessen"));
    }
//anzeigen aller mahlzeiten in der textarea
    private void anzeigenMahlzeiten() {
        String ausgabe = "";
        for (Mahlzeit m : mahlzeitenListe) {
            ausgabe += m.toString() + "\n\n";  // Doppelter Zeilenumbruch für Abstand
        }
        textArea_ausgabe1.setText(ausgabe);
    }

    //gesamtkalorien aller mahlzeiten berechnen und anzeigen
//bei Anzeigen der Uhrzeit wurde ChatGpt zur hilfe verwendet


private void hinzufügen() {
        String name = (String)coBo_menü.getSelectedItem();
        String kategorie = (String)CoBo_essenskategorie.getSelectedItem();
        String uhrzeitStr = textField_uhrzeit.getText();


        if (uhrzeitStr.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Bitte eine Uhrzeit eingeben!");
            return;
        }

        try {
            int kalorien = berechneKalorien(name);
            LocalDateTime uhrzeit = LocalDateTime.parse("2025-04-29T" + uhrzeitStr);

            Mahlzeit mahlzeit = new Mahlzeit(name, kalorien, uhrzeit, kategorie);
            mahlzeitenListe.add(mahlzeit);

            JOptionPane.showMessageDialog(null, "Mahlzeit gespeichert!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte Uhrzeit im Format HH:mm angeben");

        }
}
//Kalorienberechnung abhängig vom Menü
    public static int berechneKalorien(String name) {
        switch (name) {
            case "Proteinshake":
                return 203;
            case "Hähnchen und Reis":
                return 415;
            case "Ceasar Salat":
                return 545;
            case "Pizza":
                return 875;
            case "Cola":
                return 192;
            case "Fanta":
                return 187;
                default: return 0; //falls unbekannt
        }
    }
}
