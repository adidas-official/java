public class Fish implements Prey, Predator {
    @Override
    public void hunt() {
        System.out.println("This fish is hunting smaller fist");
    }

    @Override
    public void flee() {
        System.out.println("This fish is fleeing from a bigger fish");
    }

    public Fish() {
        // hunt();
        // flee();
    }
}