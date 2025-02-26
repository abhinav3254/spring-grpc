package com.abhinav3254.sec03;

import com.abhinav3254.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {

    private static final Logger log = LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("person.txt");

    public static void main(String[] args) throws IOException {
        Person person = Person
                .newBuilder()
                .setLastName("Jha")
                .setAge(25)
                .setEmail("abhinav@mail.com")
                .setEmployed(true)
                .setSalary(1000000.74)
                .setBankAccountNumber(1234567891)
                .setBalance(120000)
                .build();

        serialize(person);
        log.info("{}",deserialize());
        log.info("bytes length {}",person.toByteArray().length);

    }

    private static void serialize(Person person) throws IOException {
        try(var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
//        person.writeTo(Files.newOutputStream(PATH));
    }

    private static Person deserialize() throws IOException {
        try (var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        }
//        return Person.parseFrom(Files.newInputStream(PATH));
    }

}
