public class HelloName {

    private String name;

    public HelloName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name was changed to: " + name);
    }

    @Override
    public String toString() {
        return "Hello, " + this.name;
    }

    public static void main(String[] args) {
        HelloName person1 = new HelloName("Iva");
        System.out.println(person1);

        person1.setName("Olia");
        System.out.println(person1);
    }
    
}
