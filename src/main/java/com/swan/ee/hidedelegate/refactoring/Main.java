package com.swan.ee.hidedelegate.refactoring;

import java.io.IOException;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        try {
            AddressFile file = new AddressFile("address.txt");
            file.set("eeswan","eeeswan@naver.com");
            file.set("themoring","themorning84@gmail.com");
            file.set("g00dyearth","g00dyearth@naver.com");
            file.update();

            Enumeration names = file.names();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                String email = file.get(name);
                System.out.println("name=" +  name + ", mail= " +  email);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
