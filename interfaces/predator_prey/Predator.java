public interface Predator {

    void hunt();

    default void track() {
        System.out.println("The predator is tracking the prey");
    }

}