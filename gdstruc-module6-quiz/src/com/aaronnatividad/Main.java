package com.aaronnatividad;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numbers[] = new int[100];
        int input;

        // populate numbers array
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(1000);
        }

        printArray(numbers, 10);
        System.out.println("Find what number: ");
        input = scanner.nextInt();
        System.out.println(spraySearch(numbers, input));
    }

    public static void printArray(int[] numbers, int lineLimit){
        int lineCounter = 0;
        for(int i = 0; i < numbers.length; i++){
            if(lineCounter < lineLimit - 1){
                System.out.print("%03d, ".formatted(numbers[i]));
                lineCounter++;
                continue;
            }
            System.out.print("%03d\n".formatted(numbers[i]));
            lineCounter = 0;
        }
    }

    public static int spraySearch(int[] numbers, int value){
        Random random = new Random();
        int indices[] = new int[numbers.length];
        int index = -1;
        int count = 0;
        boolean completed = false;

        for(int i = 0; i < indices.length; i++){
            indices[i] = 1;
        }

        // check value
        while(!completed){
            count++;
            index = random.nextInt(numbers.length);
            completed = true;
            // if found
            if(numbers[index] == value){
                break;
            }

            indices[index] = 0;
            index = -1;
            for(int i = 0; i < indices.length; i++){
                if(indices[i] == 1){
                    completed = false;
                    break;
                }
            }
        }
        System.out.println("Number of tries: " + count);
        return index;
    }
}
