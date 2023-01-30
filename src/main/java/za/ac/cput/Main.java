package za.ac.cput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Persons> people = getPeople();

        // Imperative approach

    /*

    List<za.ac.cput.Persons> females = new ArrayList<>();

    for (za.ac.cput.Persons person : people) {

      if (persons.getGender().equals(za.ac.cput.Gender.FEMALE)) {
        females.add(persons);
      }
    }

    females.forEach(System.out::println);

    */

        // Declarative approach

        // Filter by za.ac.cput.Gender
        List<Persons> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        System.out.println("----------------------------------------------------------------");
        System.out.println("Display Only za.ac.cput.Gender Female ");
        System.out.println("----------------------------------------------------------------");
        females.forEach(System.out::println);

        // Sort
        List<Persons> sorted = people.stream()
                .sorted(Comparator.comparing(Persons::getAge).thenComparing(Persons::getGender).reversed())
                .collect(Collectors.toList());

//    sorted.forEach(System.out::println);

        // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);

//    System.out.println(allMatch);
        // Any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);

//    System.out.println(anyMatch);
        // None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

//    System.out.println(noneMatch);

        // Max
        people.stream()
                .max(Comparator.comparing(Persons::getAge));
//        .ifPresent(System.out::println);

        // Min
        people.stream()
                .min(Comparator.comparing(Persons::getAge));
//        .ifPresent(System.out::println);

        // Group
        Map<Gender, List<Persons>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Persons::getGender));

     //  groupByGender.forEach((gender, people1) -> {
     //  System.out.println(gender);
     //  people1.forEach(System.out::println);
     //  System.out.println();
      // });

        Optional<String> oldestFemaleAge = people.stream()
                .filter(persons -> persons.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Persons::getAge))
                .map(Persons::getName);

      //  oldestFemaleAge.ifPresent(System.out::println);
    }

    private static List<Persons> getPeople() {
        return List.of(
                new Persons("Dray Bulambo", 20, Gender.MALE),
                new Persons("Frank Ir", 33, Gender.FEMALE),
                new Persons("Jenny Rose", 57, Gender.FEMALE),
                new Persons("Jemmy Carter ", 14, Gender.MALE),
                new Persons("Taylor Lokombe", 99, Gender.MALE),
                new Persons("Martinez Safari", 7, Gender.FEMALE),
                new Persons("Hillary Cassidy", 120, Gender.FEMALE)
        );
    }

}
