package com.aaronnatividad;

public class Main {

    public static void main(String[] args) {

        Player asuna = new Player(1, 100, "Asuna");
        Player lethalBacon = new Player(2, 205, "LethalBacon");
        Player hpDeskjet = new Player(3, 34, "HPDeskjet");
        Player arctis = new Player(4, 100, "Arctis");
        Player heathcliff = new Player(5,55, "Heathcliff");

        DoublyLinkedList playerLinkedList = new DoublyLinkedList();

        // normal add test
        playerLinkedList.add(asuna);
        playerLinkedList.add(lethalBacon);
        playerLinkedList.add(hpDeskjet);
        // add w index test
        playerLinkedList.add(arctis, 20);
        playerLinkedList.add(heathcliff,2);
        playerLinkedList.printList();

        // remove head/player/index test
        playerLinkedList.removeCurrentHead();
        playerLinkedList.remove(asuna);
        playerLinkedList.remove(1);
        playerLinkedList.printList();

        // check if previous nodes are linked properly
        playerLinkedList.printListDescending();

        // indexOf and getSize test
        System.out.println("Index: " + playerLinkedList.indexOf(asuna));
        System.out.println("Size: " + playerLinkedList.getSize());
    }
}
