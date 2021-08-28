package com.aaronnatividad;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int transferAmount;
        int round = 0;

        CardStack playerDeck = new CardStack();
        CardStack playerHand = new CardStack();
        CardStack discardPile = new CardStack();

        // generate 30 cards with random 3 digit IDs
        for(int i = 0; i < 30; i++)
            playerDeck.push(new Card());

        // main game loop
        while(!playerDeck.isEmpty()){
            round++;
            roundUI(round, playerDeck, playerHand, discardPile);
            switch(randomCommand(playerDeck, playerHand, discardPile)){
                case 0:
                    transferAmount = clampedAmount(playerDeck);
                    System.out.println("You drew " + transferAmount + " cards from the deck.");
                    transferCards(playerDeck, playerHand, transferAmount);
                    break;
                case 1:
                    transferAmount = clampedAmount(playerHand);
                    System.out.println("You discarded " + transferAmount + " cards.");
                    transferCards(playerHand, discardPile, transferAmount);
                    break;
                case 2:
                    transferAmount = clampedAmount(discardPile);
                    System.out.println("You drew " + transferAmount + " cards from the discard pile.");
                    transferCards(discardPile, playerHand, transferAmount);
                    break;
                default:
                    break;
            }
            pause();
        }

        // end
        roundUI(-1, playerDeck, playerHand, discardPile);
        return;
    }

    public static void roundUI(int round, CardStack playerDeck, CardStack playerHand, CardStack discardPile){
        System.out.println("==========");
        if(round == -1)
            System.out.println("Round END");
        else
            System.out.println("Round " + round);
        System.out.println("==========");
        System.out.println("Current Player Hand: ");
        playerHand.printStack(5);
        System.out.println("Deck Size: " + playerDeck.size());
        System.out.println("Discard Pile Size: " + discardPile.size());
        System.out.println("==========");
        pause();
    }

    public static void transferCards(CardStack stack1, CardStack stack2, int amount){
        for(int i = 0; i < amount; i++){
            stack2.push(stack1.peek());
            stack1.pop();
        }
    }

    public static void pause(){
        System.out.print("Press Enter to continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int clampedAmount(CardStack stack){
        Random random = new Random();
        int amount = random.nextInt(5) + 1;

        if(amount > stack.size())
            amount = stack.size();

        return amount;
    }

    public static int randomCommand(CardStack playerDeck, CardStack playerHand, CardStack discardPile){
        Random random = new Random();
        int choice;

        boolean[] stacks = new boolean[3];
        stacks[0] = playerDeck.isEmpty();
        stacks[1] = playerHand.isEmpty();
        stacks[2] = discardPile.isEmpty();

        while(true){
            choice = random.nextInt(3);
            if(!stacks[choice])
                break;
        }

        return choice;
    }
}
