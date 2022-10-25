package org.example;

public class Person {
     private String name;
     private int age;
     private int money;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMoney() {
        return money;
    }

    public Person(String name, int age, int money){
         this.name=name;
         this.age=age;
         this.money=money;
     }
}
