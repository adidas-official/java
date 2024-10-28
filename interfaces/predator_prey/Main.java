public class Main {

    public static void main(String[] args) {
        // Hawk hawk = new Hawk();
        // hawk.hunt();

        // Rabbit rabbit = new Rabbit();
        // rabbit.flee();

        Fish fish = new Fish();
        // fish.hunt();
        // fish.flee();
        Predator bob = new Hawk();
        Predator tom = new Fish();
        bob.hunt();
        tom.hunt();
    }   
}