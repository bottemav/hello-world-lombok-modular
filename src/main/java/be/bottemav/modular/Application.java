package be.bottemav.modular;

import be.bottemav.modular.model.Person;

public class Application {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John");
        System.out.println("Hello " + person.getName());
    }
}
