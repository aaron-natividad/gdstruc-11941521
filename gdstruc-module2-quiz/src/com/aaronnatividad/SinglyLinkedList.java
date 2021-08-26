package com.aaronnatividad;

public class SinglyLinkedList {
    private PlayerNode head;
    private int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public void add(Player player){
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        size++;
    }

    public void removeCurrentHead(){
        PlayerNode currentNode = head;
        if(currentNode != null){
            head = currentNode.getNextPlayer();
            currentNode.setNextPlayer(null);
            size--;
        }
    }

    public boolean contains(Player player){
        PlayerNode currentNode = head;
        for(int i = 0; i < size; i++){
            if(player.equals(currentNode.getPlayer())){
                return true;
            }
            else {
                currentNode = currentNode.getNextPlayer();
            }
        }
        return false;
    }

    public int indexOf(Player player){
        PlayerNode currentNode = head;
        for(int i = 0; i < size; i++){
            if(player.equals(currentNode.getPlayer())){
                return i;
            }
            else {
                currentNode = currentNode.getNextPlayer();
            }
        }
        return -1;
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current.getPlayer());
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}
