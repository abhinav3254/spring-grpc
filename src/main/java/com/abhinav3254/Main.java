package com.abhinav3254;

// This will throw error, since we are using intelliJ idea it's IDE issue because if you will run
// maven clean compile it will not throw error, so to resolve this issue go to
// target/generated-sources/protobuf/java and right click on java then at the bottom you can find
// mark directory as "Generated Sources Root", this will remove the red warning and we cam happily use this class
// importing protobuf class
import com.abhinav3254.models.PersonOuterClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}