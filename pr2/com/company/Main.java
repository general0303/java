package com.company;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    Human h1 = new Human(40, "Ivan", "Ivanov", "06.10.1980", 70);
	    Human h2 = new Human(25, "Semen", "Smirnov", "01.01.1976", 73);
	    Human h3 = new Human(20, "Sergey", "Ivanov", "23.08.2000", 68);
	    Human h4 = new Human(35, "Ivan", "Smirnov", "02.02.1976", 66);
	    Human h5 = new Human(60, "Semen", "Ivanov", "26.11.1960", 60);
        Stream<Human> humans = Stream.of(h1, h2, h3, h4, h5);
        System.out.println("sorted");
        humans.sorted(Comparator.comparing(Human::sorted)).forEach(Human::print);
        System.out.println("filter");
        humans = Stream.of(h1, h2, h3, h4, h5);
        humans.filter((a) -> a.getWeight() % 5 == 0).forEach(Human::print);
        System.out.println("first 4 elements");
		humans = Stream.of(h1, h2, h3, h4, h5);
		humans.limit(4).forEach(Human::print);
		System.out.println("concatenation");
		humans = Stream.of(h1, h2, h3, h4, h5);
		Optional<Human> s = humans.reduce((a, b) -> new Human(a.age, a.firstName+ " " +b.firstName, a.lastName, a.birthDay, a.weight));
		s.ifPresent(Human::print_name);
    }
}
