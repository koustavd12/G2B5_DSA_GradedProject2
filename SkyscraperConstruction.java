package com.greatlearning.iitr.gorupassignment2;

import java.util.*;

public class SkyscraperConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of floors in the building:");
        int n = sc.nextInt();
        int[] floors = new int[n];
        System.out.println("Enter the floor size given on each day:");
        for (int i = 0; i < n; i++) {
            floors[i] = sc.nextInt();
        }
        Stack<Integer> assemblyStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currentFloor = floors[i];
            while (!assemblyStack.isEmpty() && currentFloor > assemblyStack.peek()) {
                System.out.print(assemblyStack.pop() + " ");
            }
            assemblyStack.push(currentFloor);
            System.out.println();
        }
        while (!assemblyStack.isEmpty()) {
            System.out.print(assemblyStack.pop() + " ");
        }
    }
}