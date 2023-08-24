package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/tickets.json"));
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        InputObject inputObject = objectMapper.readValue(br, InputObject.class);


        System.out.println("xui");
    }
}
