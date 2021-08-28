package com.aaronnatividad;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayerQueue {
    private LinkedList<Player> queue;

    public PlayerQueue(){
        queue = new LinkedList<Player>();
    }

    public int size(){
        return queue.size();
    }

    public void enqueue(Player player){
        queue.addLast(player);
    }

    public Player dequeue(){
        return queue.removeFirst();
    }

    public Player peek(){
        return queue.peekFirst();
    }

    public void printQueue(){
        ListIterator<Player> iterator = queue.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
