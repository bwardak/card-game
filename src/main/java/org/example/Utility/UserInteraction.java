package org.example.Utility;

public abstract class UserInteraction {

    public void errorHandling(){
        System.out.println("\nINVALID INPUT\n");
    }

    public void chooseGamePrompt(){
        System.out.println("Choose a Game:");
    }

    public void chooseActionPrompt(){
        System.out.print("Enter number: ");
    }


}
