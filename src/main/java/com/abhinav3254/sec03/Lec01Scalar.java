package com.abhinav3254.sec03;

import com.abhinav3254.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {

    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {

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

        log.info("{}",person);

    }
}
