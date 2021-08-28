package com.aaronnatividad;

public class SimpleHashTable {
    private StoredPlayer[] hashtable;

    public SimpleHashTable(){
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key){
        return key.length() % hashtable.length;
    }

    private boolean isOccupied(int index){
        return hashtable[index] != null;
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        int stoppingIndex = hashedKey;

        // found correct key first try
        if(isOccupied(hashedKey) && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        }

        // linear probing
        do{
            hashedKey = (hashedKey + 1) % hashtable.length;
        }while(isOccupied(hashedKey) && hashedKey != stoppingIndex && !hashtable[hashedKey].key.equals(key));

        // found correct key
        if(isOccupied(hashedKey) && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        }
        return -1;
    }

    public void put(String key, Player value){
        int hashedKey = hashKey(key);

        // linear probing
        if(isOccupied(hashedKey)){
            int stoppingIndex = hashedKey;
            do{
                hashedKey = (hashedKey + 1) % hashtable.length;
            }while(isOccupied(hashedKey) && hashedKey != stoppingIndex);
        }

        if(isOccupied(hashedKey)){
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        }
        else{
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public Player get(String key){
        int hashedKey = findKey(key);

        if(hashedKey == -1){
            return null;
        }
        return hashtable[hashedKey].value;
    }

    public Player remove(String key){
        Player removedPlayer;

        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }

        removedPlayer = hashtable[hashedKey].value;
        hashtable[hashedKey] = null;
        return removedPlayer;
    }

    public void printHashtable(){
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] != null){
                System.out.println("Element " + i + " " + hashtable[i].value);
            }
            else {
                System.out.println("Element " + i + " null");
            }
        }
    }
}
