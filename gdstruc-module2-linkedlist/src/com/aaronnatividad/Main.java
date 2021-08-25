package com.aaronnatividad;

public class Main {

    public static void main(String[] args) {

        Player asuna = new Player(1, 100, "Asuna");
        Player lethalBacon = new Player(2, 205, "LethalBacon");
        Player hpDeskjet = new Player(3, 34, "HPDeskjet");

        PlayerSinglyLinkedList playerLinkedList = new PlayerSinglyLinkedList();

        playerLinkedList.addToFront(asuna);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(hpDeskjet);

        playerLinkedList.printList();
    }
}
