package mujprojekt;

import mujprojekt.model.Osoba;

public class Hlavni {
    public static void main(String[] args) {
        Osoba osoba = new Osoba("Jan", "Novák");
        System.out.println(osoba.getJmeno());
    }
}
