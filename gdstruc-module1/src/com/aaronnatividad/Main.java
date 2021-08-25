package com.aaronnatividad;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(500);
        }

        System.out.println("Before selection sort");
        printArrayElements(numbers);

        selectionSort(numbers);

        System.out.println("\n\nAfter selection sort");
        printArrayElements(numbers);
    }

    private static void bubbleSort(int[] arr){
        for(int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--){
            for(int i = 0; i < lastSortedIndex; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr){
        for(int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--){
            int largestIndex = 0;

            for(int i = 0; i <= lastSortedIndex; i++){
                if(arr[i] > arr[largestIndex]){
                    largestIndex = i;
                }
            }

            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[largestIndex];
            arr[largestIndex] = temp;
        }
    }

    private static void printArrayElements(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
