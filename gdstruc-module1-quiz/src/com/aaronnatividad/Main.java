package com.aaronnatividad;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // 10 random numbers for testing
        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(500);
        }

        // print and sort
        System.out.println("Before sort: ");
        printArrayElements(numbers);

        bubbleSort(numbers, true);

        System.out.println("\n\nAfter sort:");
        printArrayElements(numbers);
    }

    private static void printArrayElements(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void swap(int index1, int index2, int[] arr){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void bubbleSort(int[] arr, boolean ascending){
        for(int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--){
            for(int i = 0; i < lastSortedIndex; i++){
                // ascending order
                if(ascending){
                    if(arr[i] > arr[i+1]){
                        swap(i, i+1, arr);
                    }
                }
                // descending order
                else {
                    if (arr[i] < arr[i+1]) {
                        swap(i, i+1, arr);
                    }
                }
            }
        }
    }

    // selection sort (smallest/largest -> end)
    private static void selectionSort(int[] arr, boolean ascending){
        for(int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--){
            int extremeIndex = 0;

            for(int i = 0; i <= lastSortedIndex; i++){
                // ascending order
                if(ascending){
                    if(arr[i] >= arr[extremeIndex]){
                        extremeIndex = i;
                    }
                }
                // descending order
                else{
                    if(arr[i] <= arr[extremeIndex]){
                        extremeIndex = i;
                    }
                }
            }
            swap(lastSortedIndex, extremeIndex, arr);
        }
    }

    // selection sort (smallest/largest -> beginning)
    private static void selectionSortSpecial(int[] arr, boolean ascending){
        for(int lastSortedIndex = 0; lastSortedIndex < arr.length; lastSortedIndex++){
            int extremeIndex = arr.length - 1;

            for(int i = arr.length-1; i >= lastSortedIndex; i--){
                // ascending order
                if(ascending){
                    if(arr[i] <= arr[extremeIndex]){
                        extremeIndex = i;
                    }
                }
                // descending order
                else{
                    if(arr[i] >= arr[extremeIndex]){
                        extremeIndex = i;
                    }
                }
            }
            swap(lastSortedIndex, extremeIndex, arr);
        }
    }
}
