package com.abhinav3254.sec02;

import com.abhinav3254.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {

    // creating logger instance
    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {

//        Here we are not using that much long name to create object
        Person person = Person.newBuilder().setAge(22).setName("Abhinav").build();

        log.info("{}",person);

    }

}
