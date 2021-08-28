package com.aaronnatividad;

public class Main {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.add(new Player(1, "aceu", 100));
        queue.add(new Player(2, "Sinatraa", 100));
        queue.add(new Player(3, "Subroza", 95));
        queue.add(new Player(4, "ploo", 90));

        queue.printQueue();
        //queue.add(new Player(5, "tenZ", 95));
        queue.remove();

        System.out.println("After popping element");
        queue.printQueue();
    }
}
