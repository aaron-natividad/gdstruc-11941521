package com.aaronnatividad;

public class Tree {
    private Node root;

    public void insert(int value){
        if(root == null){
            root = new Node(value);
        }
        else {
            root.insert(value);
        }
    }

    public void traverseInOrder(){
        if(root != null){
            root.traverseInOrder();
        }
    }

    public Node get(int value){
        if(root != null){
            return root.get(value);
        }
        return null;
    }
}
