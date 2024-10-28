class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    };

    @Override
    public String toString() {
        return "Person " + name + " is " + this.age + " years old";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person othPerson = (Person) obj;
            return this.name.equals(othPerson.name);
        }
        return false;
    }

    public boolean isOlder(Object obj) {
        if (obj instanceof Person) {
            Person othPerson = (Person) obj;
            return this.age > othPerson.age;
        }
        return false;
    }

    public static void main(String[] args) {
        Person alice = new Person("Alice", 31);
        Person bob = new Person("bob", 35);

        System.out.println(alice);
        System.out.println(bob);

        if (alice.isOlder(bob)) {
            System.out.println("Alice is older that Bob.");
        } else {
            System.err.println("Bob is older that Alice.");
        }

    }

}


