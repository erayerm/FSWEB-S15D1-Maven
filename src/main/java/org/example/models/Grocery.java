package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isWork = true;
        while (isWork) {
            System.out.println("0 - 1 - 2");
            int pick = scanner.nextInt();
            scanner.nextLine(); // Boş satırı temizle
            switch (pick) {
                case 0:
                    isWork = false;
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String[] addElements = scanner.nextLine().split(",");
                    for(String element : addElements) addItems(element);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String[] removeElements = scanner.nextLine().split(",");
                    for (String element : removeElements) removeItems(element);
                    break;
                default:
                    System.out.println("Yanlış değer girdin tekrar dene");
            }
            sort();
            printSorted();
        }
    }

    public static void addItems(String input) {
        String[] addElements = input.split(",");
        for(String element : addElements){
            if(!groceryList.contains(element)) {
                groceryList.add(element);
            }
        }
        sort();
    }

    public static void removeItems(String input) {
        String[] addElements = input.split(",");
        for(String element : addElements){
            groceryList.remove(element);
        }
        sort();
    }

    public static boolean checkItemIsInList(String input) {
        return groceryList.contains(input);
    }

    public static void printSorted() {
        sort();
        System.out.println(groceryList);
    }
    public static void sort(){
        Collections.sort(groceryList);
    }
}

