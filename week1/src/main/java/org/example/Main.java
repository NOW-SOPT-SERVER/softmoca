package org.example;

import org.example.classes.Person;
import org.example.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        //Person 클래스의 객체 생성
        Person person = new Person("도소현", 24, "female");
        //Person 클래스 내부 메소드 호출
        person.walk();

        System.out.println(person.getName()); //결과 : 도소현

        person.setName("기요미");

        System.out.println(person.getName()); //결과 : 기요미

        Person.run();


        Person personWithBuilder = new
                PersonBuilder()
                .name("도소현11")
                .age(24)
                .sex("female")
                .build();



        Person personWithFactoryMethod = Person.create("도소현", 24, "female");


    }


}