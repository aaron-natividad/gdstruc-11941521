package com.aaronnatividad;

public class Main {

    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();

        stack.push(new Player(1, 100, "aceu"));
        stack.push(new Player(2, 100, "Sinatraa"));
        stack.push(new Player(3, 95, "Subroza"));
        stack.push(new Player(4, 90, "ploo"));

        stack.printStack();

        System.out.println("Popping: " + stack.pop());

        stack.printStack();
    }
}
