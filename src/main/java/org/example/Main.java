package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> listWorld = new ArrayList<>();
        listWorld.add("Сектор");
        listWorld.add("Сумма ");
        listWorld.add("Поле");
        listWorld.add("Сектор");
        listWorld.add("Поле");
        listWorld.add("Поле");
        listWorld.add("Интернет");
        listWorld.add("Солнце");
        listWorld.add("Поле");

        String  prevalentWord = listWorld.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println(prevalentWord);
        streamSimpleTask();
    }


    public static void streamSimpleTask() {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob1", 35, 25000),
                new Person("Aob2", 44, 15001),
                new Person("Bob3", 39, 25000),
                new Person("Abb4", 48, 15900),
                new Person("Bob6", 29, 70000)
        ));
        int N = 2;
        OptionalDouble srMoney = persons.stream()
                .map(s -> {
                    return s.getMoney();
                }).mapToInt(e -> e).average();
        System.out.println(srMoney.getAsDouble() + " средняя зарплата");

        String oldest = persons.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).limit(N)
                .map(person -> person.getName()).sorted().collect(Collectors.joining
                        (",", N + " Самых старших сотрудников зовут [", "]"));
        System.out.println(oldest);
    }


}