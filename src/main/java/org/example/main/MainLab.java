package org.example.main;

// Import here manually
import org.example.packageone.ClassOne;
import org.example.packagetwo.ClassTwo;
import org.example.packagethree.ClassThree;
import static java.lang.System.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainLab {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        ClassTwo classTwo = new ClassTwo();
        ClassThree classThree  = new ClassThree();

        out.println(classOne.greet());
        out.println(classTwo.greet());
        out.println(classThree.greet());
    }
}