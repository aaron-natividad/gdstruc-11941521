package com.aaronnatividad;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int turn = 0;
        int gameCounter = 0;
        PlayerQueue playerQueue = new PlayerQueue();

        while(gameCounter < 10){
            System.out.println("Games found: " + gameCounter);
            populateQueue(random.nextInt(7)+1, playerQueue);
            while(playerQueue.size() >= 5){
                createMatch(playerQueue);
                gameCounter++;
            }
            pause();
            System.out.println("============");
        }

        return;
    }

    public static void populateQueue(int amount, PlayerQueue playerQueue){
        Player player;
        System.out.println(amount + " players have joined the queue:");
        for(int i = 0; i < amount; i++){
            player = new Player();
            System.out.println(player.getUserName());
            playerQueue.enqueue(player);
        }
    }

    public static void createMatch(PlayerQueue playerQueue){
        System.out.println("Match found for the following players: ");
        for(int i = 0; i < 4; i++){
            System.out.print(playerQueue.peek().getUserName() + ", ");
            playerQueue.dequeue();
        }
        System.out.print(playerQueue.peek().getUserName() + "\n");
        playerQueue.dequeue();
    }

    public static void pause(){
        System.out.print("Press Enter to continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
