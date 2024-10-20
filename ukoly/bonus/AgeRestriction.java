import java.util.Scanner;

public class AgeRestriction {

    private int age;
    private static Scanner in = new Scanner(System.in);

    public AgeRestriction() {
        this.setAge();
    }

    public void setAge() {
        System.out.println("How old are you?");
        this.age = in.nextInt();
    }

    private boolean adult() {
        return this.age >= 18;
    }

    @Override
    public String toString() {
        if (this.adult()) {
            return "You are adult, have a beer with us!";
        } else {
            return "You are too young, go home.";
        }
    } 

    public static void main(String[] args) {
        AgeRestriction person1 = new AgeRestriction();
        System.out.println(person1);

        AgeRestriction person2 = new AgeRestriction();
        System.out.println(person2);
    }

}
