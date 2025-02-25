package com.abhinav3254.sec01;

import com.abhinav3254.models.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {

    // creating logger instance
    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {

        // we can't create object of this class because it's constructor is private...
        var person =  PersonOuterClass.Person.newBuilder()
                .setName("Abhinav")
                .setAge(25)
                .build();

        log.info("{}",person);

    }

}
