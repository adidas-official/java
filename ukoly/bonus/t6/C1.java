public class C1 {
    private int a;

    public C1() {
        a = 5;
    }

    public C1(int a) {
        this.a = a;
    }

    public int get_a() {
        return a;
    }
}

class C2 extends C1 {

}


class Main {
    public static void main(String[] args) {
        
        C2 c2 = new C2();
        System.out.println(c2.get_a());
    }

}
