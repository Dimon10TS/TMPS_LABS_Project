package com.example.laborator_1_Lab1.Alte;
import com.example.laborator_1_Lab1.interfaces.IUserInput;

import java.util.Scanner;

public class ConsoleUserInput implements IUserInput {
    private Scanner scanner;

    public ConsoleUserInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String nextString() {
        return scanner.next();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    @Override
    public double nextDouble() {
        return scanner.nextDouble();
    }
}