package com.aaronnatividad;

public class DoublyLinkedList {
    private PlayerNode head;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }

    public void add(Player player){
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        if(head != null)
            head.setPreviousPlayer(playerNode);
        head = playerNode;
        size++;
    }

    public void add(Player player, int index){
        PlayerNode previousNode = head;
        PlayerNode playerNode = new PlayerNode(player);

        if(index == 0 || head == null){
            // make playerNode new head
            playerNode.setNextPlayer(head);
            if(head != null)
                head.setPreviousPlayer(playerNode);
            head = playerNode;
        }
        else {
            // find previous node
            for(int i = 1; i < index; i++){
                if(previousNode.getNextPlayer() != null)
                    previousNode = previousNode.getNextPlayer();
            }

            // connect 3 nodes prev <-> current <-> next
            playerNode.setPreviousPlayer(previousNode);
            playerNode.setNextPlayer(previousNode.getNextPlayer());
            previousNode.setNextPlayer(playerNode);
            if(playerNode.getNextPlayer() != null)
                playerNode.getNextPlayer().setPreviousPlayer(playerNode);
        }
        size++;
    }

    public void removeCurrentHead(){
        PlayerNode currentNode = head;
        if(currentNode != null){
            head = currentNode.getNextPlayer();
            head.setPreviousPlayer(null);
            currentNode.setNextPlayer(null);
            size--;
        }
    }

    public void remove(int index){
        PlayerNode currentNode = head;

        // look for node from index
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.getNextPlayer();
        }

        if(currentNode != null){
            if(index == 0){
                // remove current head
                head = currentNode.getNextPlayer();
                head.setPreviousPlayer(null);
                currentNode.setNextPlayer(null);
            }
            else {
                // connect nodes prev -><- next
                currentNode.getPreviousPlayer().setNextPlayer(currentNode.getNextPlayer());
                if(currentNode.getNextPlayer() != null)
                    currentNode.getNextPlayer().setPreviousPlayer(currentNode.getPreviousPlayer());
                currentNode.setNextPlayer(null);
                currentNode.setPreviousPlayer(null);
            }
            size--;
        }
    }

    public void remove(Player player){
        PlayerNode currentNode = head;

        while(currentNode != null){
            if(player.equals(currentNode.getPlayer()))
                break;
            currentNode = currentNode.getNextPlayer();
        }

        if(currentNode != null) {
            if (currentNode == head) {
                // remove current head
                head = currentNode.getNextPlayer();
                head.setPreviousPlayer(null);
                currentNode.setNextPlayer(null);
            } else {
                // connect nodes prev -><- next
                currentNode.getPreviousPlayer().setNextPlayer(currentNode.getNextPlayer());
                if (currentNode.getNextPlayer() != null)
                    currentNode.getNextPlayer().setPreviousPlayer(currentNode.getPreviousPlayer());
                currentNode.setNextPlayer(null);
                currentNode.setPreviousPlayer(null);
            }
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
        System.out.println("HEAD: ");
        while(current != null) {
            System.out.print(current.getPlayer());
            System.out.println(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }

    // just to check previous nodes are connected properly
    public void printListDescending() {
        PlayerNode current = head;

        for(int i = 1; i < size; i++) {
            current = current.getNextPlayer();
        }

        System.out.println("END: ");
        while(current != null) {
            System.out.print(current.getPlayer());
            System.out.println(" -> ");
            current = current.getPreviousPlayer();
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}
