package com.aaronnatividad;

import java.util.LinkedList;
import java.util.ListIterator;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack(){
        stack = new LinkedList<Card>();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }

    public void push(Card card){
        stack.push(card);
    }

    public Card pop(){
        return stack.pop();
    }

    public Card peek(){
        return stack.peek();
    }

    public void printStack(int lineLimit){
        int lineCount = 0;
        ListIterator<Card> iterator = stack.listIterator();
        while(iterator.hasNext()){
            if (lineCount == lineLimit){
                System.out.print("\n");
                lineCount = 0;
            }
            System.out.print(iterator.next().getName() + ", ");
            lineCount++;
        }
        System.out.print("\n");
    }
}
