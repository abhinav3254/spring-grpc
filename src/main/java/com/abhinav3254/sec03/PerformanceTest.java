package com.abhinav3254.sec03;

import com.abhinav3254.models.sec03.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PerformanceTest {

    private static final Logger log = LoggerFactory.getLogger(PerformanceTest.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        Person protoPerson = Person
                .newBuilder()
                .setLastName("Jha")
                .setAge(25)
                .setEmail("abhinav@mail.com")
                .setEmployed(true)
                .setSalary(1000000.74)
                .setBankAccountNumber(1234567891)
                .setBalance(120000)
                .build();

        JsonPerson jsonPerson = new JsonPerson(
                "Jha"
                ,25,
                "abhinav@mail.com",
                true,
                1000000.74,
                1234567891,
                120000
        );

        for (int i = 0; i < 5; i++) {
            runTest("json",()->json(jsonPerson));
            runTest("proto",()->proto(protoPerson));
        }

    }

    private static void proto(Person person) {
        try {
            var bytes = person.toByteArray();
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static void json(JsonPerson jsonPerson) {
        try {
            var bytes = mapper.writeValueAsBytes(jsonPerson);
            mapper.readValue(bytes,JsonPerson.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runTest(String testName,Runnable runnable) {
        var start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }
        var end = System.currentTimeMillis();
        log.info("Time taken for {} - {} ms",testName,(end - start));
    }

}
