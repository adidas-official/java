class Person {
    private String name;
    public Person(String name) { this.name = name;};

    @Override
    public String toString() {
        return "Person " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person othPerson = (Person) obj;
            return this.name.equals(othPerson.name);
        }
        return false;
    }

}


