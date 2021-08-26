package com.aaronnatividad;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>();

        playerList.add(new Player(1, 100, "Asuna"));
        playerList.add(new Player(2, 205, "LethalBacon"));
        playerList.add(new Player(3, 34, "HPDeskjet"));

        // access an element
        System.out.println(playerList.get(1));

        // add and remove with index
        playerList.add(2, new Player(4, 55, "Arctis"));
        playerList.remove(2);

        // contains and index of
        System.out.println(playerList.contains(new Player(2, 205, "LethalBacon")));
        System.out.println(playerList.indexOf(new Player(3, 205, "LethalBacon")));

        // print all members
        playerList.forEach(player->System.out.println(player));

        for(Player p : playerList){
            System.out.println(p);
        }
    }
}
