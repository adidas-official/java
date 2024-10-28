// Vytvořte třídu Osoba s atributy jméno, věk a pohlaví a s metodami pro nastavení těchto atributů a výpis jejich hodnot.
// Rozšiřte třídu Osoba tak, aby metody pro nastavení atributů kontrolovaly platnost vstupu (např. nezáporný věk).

public class Osoba {
    private String jmeno;
    private int vek;
    private String pohlavi;

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setVek(int vek) {
        if (vek > 0) {
            this.vek = vek;
        } else {
            System.out.println("Vek musi byt cislo vetsi nez 0");
        }
    }

    public void setPohlavi (String pohlavi) {
        if (pohlavi == "muz" || pohlavi == "zena") {
            this.pohlavi = pohlavi;
        } else {
            System.out.println("Zadejte pohlavi muz nebo zena");
        }
    }

    public String getJmeno() {
        return this.jmeno;
    }

    public int getVek() {
        return this.vek;
    }

    public String getPohlavi() {
        return this.pohlavi;
    }

    @Override
    public String toString() {
        return "Jmeno: " + this.jmeno + " | pohlavi: " + this.pohlavi + " | vek: " + this.vek;
    }

}