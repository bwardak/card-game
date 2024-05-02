package org.example.Utility;

import java.util.Scanner;

public class UserCreation {
    private String name;
    InputScanner scanner = new InputScanner();

    public void createUser(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void nameCreation(){
        System.out.println("Enter Your Name");
        Scanner scanner = InputScanner.useScanner();
        String name = scanner.nextLine();
        System.out.println("Welcome " + name);
    }

}
