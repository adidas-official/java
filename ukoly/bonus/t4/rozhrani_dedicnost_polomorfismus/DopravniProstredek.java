public class DopravniProstredek {

    protected String typProstredku;
    protected String ucel;

    public String getNazev() {
        return this.typProstredku;
    }

    public String getUcel() {
        return this.ucel;
    }

    public DopravniProstredek(String typ, String ucel) {
        this.typProstredku = typ;
        this.ucel = ucel;
    }

    @Override
    public String toString() {
        return this.typProstredku + " se pouziva k " + this.ucel;
    }

}

class Letadlo extends DopravniProstredek implements Pohyb {
    protected String pilot;
    protected int velikostPosadky;
    protected int pocetPasazeru;

    protected boolean letani;
    protected boolean jizda;
    protected boolean plavani;

    public boolean letet() { return true; }
    public boolean jezdit() { return false; }
    public boolean plavat() { return false; }

    public Letadlo() {
        super("Letadlo", "preprave osob a materialu vzduchem");
    }

}

class Lod extends DopravniProstredek implements Pohyb{
    protected String kapitan;
    protected int velikostPosadky;
    protected int pocetPasazeru;

    public boolean letet() { return false; }
    public boolean jezdit() { return false; }
    public boolean plavat() { return true; }

    public Lod() {
        super("Lod", "preprave osob a materialu po vode");
    }

}

class Automobil extends DopravniProstredek implements Pohyb{

    protected String ridic;
    protected int pocetDveri;
    protected String znacka;

    public boolean letet() { return false; }
    public boolean jezdit() { return true; }
    public boolean plavat() { return false; }

    public String getRidic() {
        return this.ridic;
    }

    public void setRidic(String jmeno) {
        this.ridic = jmeno;
    }

    protected Automobil(String ridic, int pocetDveri, String znacka) {
        super("Automobil", "preprave osob a materialu po pozemnich komunikacich");
        this.ridic = ridic;
        this.pocetDveri = pocetDveri;
        this.znacka = znacka;
    }

    @Override
    public String toString() {
        return "Tento " + this.pocetDveri +
        "dverovy " + this.typProstredku +
        " znacky " + this.znacka +
        " se pouziva k " + this.ucel +
        " a ridi jej " + this.ridic;
    }

}

class OsobniAutomobil extends Automobil {

    public OsobniAutomobil(String ridic, String znacka) {
        super(ridic, 4, znacka);
    }
    
}

class NakladniAutomobil extends Automobil {

    private double uzitecnaHmotnostVTunach;

    public double getUzitecnaHmotnost() { return this.uzitecnaHmotnostVTunach; }

    public void setUzitecnaHmothost(double uzitecnaHmotnost) { this.uzitecnaHmotnostVTunach = uzitecnaHmotnost; };

    public NakladniAutomobil(String ridic, double uzitecnaHmotnost, String znacka) {
        super(ridic, 2, znacka);
    }

}
