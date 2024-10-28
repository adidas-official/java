package mujprojekt.model;

public class Osoba {
    private String jmeno;
    private String prijmeni;

    public Osoba(String jmeno, String prijmeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }

    public String getJmeno() {
        return jmeno + " " + prijmeni;
    }
}
