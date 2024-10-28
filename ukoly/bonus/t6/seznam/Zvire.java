
import java.util.List;
import java.util.ArrayList;

public class Zvire {
    public String rasa;
    public String jmeno;
    public int vek;

    public Zvire(String rasa, String jmeno, int vek) {
        this.jmeno = jmeno;
        this.rasa = rasa;
        this.vek = vek;
    }

    public static void main(String[] args) {
        Zvire pes = new Zvire("Pes", "Eli", 7);
        Zvire kocka = new Zvire("Kocak", "Viku", 14);

        SeznamZvirat naseZvirata = new SeznamZvirat();
        naseZvirata.addZvire(pes);
        naseZvirata.addZvire(kocka);

        naseZvirata.getZvirata();

    }
}

class SeznamZvirat {

    public List<Zvire> seznamZvirat = new ArrayList<>();

    public void addZvire(Zvire zvire) {
        this.seznamZvirat.add(zvire);
    }

    public void getZvirata() {
        for (Zvire z: this.seznamZvirat) {
            System.out.println(z.rasa + " " + z.jmeno + " " + z.vek) ;
        }
    }

}
