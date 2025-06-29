package projekt_maxine;

import java.time.LocalDateTime;


public class Mahlzeit {
private String name;
private int kalorien;
private LocalDateTime uhrzeit;
private String Essenskategorie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKalorien() {
        return kalorien;
    }

    public void setKalorien(int kalorien) {
        this.kalorien = kalorien;
    }

    public LocalDateTime getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(LocalDateTime uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getEssenskategorie() {
        return Essenskategorie;
    }

    public void setEssenskategorie(String essenskategorie) {
        Essenskategorie = essenskategorie;
    }

    public Mahlzeit(String name, int kalorien, LocalDateTime uhrzeit, String essenskategorie) {
        this.name = name;
        this.kalorien = kalorien;
        this.uhrzeit = uhrzeit;
        this.Essenskategorie = essenskategorie;
    }
    public String toString(){
        return name + " | " + kalorien + " | " + uhrzeit + " | " + Essenskategorie;

    }
}
