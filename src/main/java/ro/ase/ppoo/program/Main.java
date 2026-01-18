package ro.ase.ppoo.program;

import ro.ase.ppoo.models.Concert;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;

public class Main {

    public static List<Concert> concerts = new ArrayList<Concert>();
    public static void main(String[] args) {

        //Se creeaza minim 5 obiecte salvate intr-un HashMap.
        //Se implementeaza o metoda care opereaza asupra HashMap-ului:
        //afisare, calcul venit, modificare locuri.

        Concert concert1 = new Concert("Rock Fest", "Stadium A", 50.0, "Band A", 3, true, 1000, 200);
        Concert concert2 = new Concert("Jazz Night", "Club B", 30.0, "Artist B", 2, false, 300, 150);
        Concert concert3 = new Concert("Pop Gala", "Arena C", 70.0, "Singer C", 4, true, 2000, 500);
        Concert concert4 = new Concert("Classical Evening", "Hall D", 40.0, "Orchestra D", 2, true, 500, 100);
        Concert concert5 = new Concert("Indie Vibes", "Venue E", 25.0, "Band E", 3, false, 400, 250);
        Concert concert6; // folosim constructorul de copiere
        concert6 = new Concert(concert3);

        HashMap<Integer, Concert> concertMap = new HashMap<>();

        concertMap.put(1, concert1);
        concertMap.put(2, concert2);
        concertMap.put(3, concert3);
        concertMap.put(4, concert4);
        concertMap.put(5, concert5);
        concertMap.put(6, concert6);

        printDetails(concertMap);
        System.out.println("\nTotal Revenue from all concerts: " + calculateRevenue(concertMap));

        System.out.println("\nModifying booked seats for concert with key 2 (booking 100 tickets):");
        modifySeats(concertMap, 2, 100);
        printDetails(concertMap);

        //Se creeaza o lista de obiecte Concert, se sorteaza si se afiseaza.
        //Se apeleaza metodele din interfata si clasele abstracte.

        List<Concert> concertList = new ArrayList<>(concertMap.values());
        concertList.sort(Concert::compareTo);
        System.out.println("\nSorted Concerts:");
        for (Concert concert : concertList) {
            System.out.println(concert.toString());
        }

        for(Concert concert : concertList){
            System.out.println("\nRevenue for " + concert.getName() + ": " + concert.calculateRevenue());
            concert.bookTickets(50);
            System.out.println("After booking 50 tickets, booked seats: " + concert.toString());
        }

        //Datele se salveaza intr-un fisier text, un obiect pe linie.
        try{
            PrintStream fileOut = new PrintStream(new File("concerts.txt"));
            for(Concert concert : concertList){
                fileOut.println(concert.toString());
            }
        }
        catch (Exception e){
            System.out.println("Error creating file: " + e.getMessage());
        }


        //Threaduri
        concerts.addAll(concertList);
        Thread thread1 = new RandomThread();
        Thread thread2 = new RandomThread();
         thread1.start();
        System.out.println("Thread 1 started.");
        thread2.start();
        System.out.println("Thread 2 started.");

    }

    public static void printDetails(HashMap<Integer, Concert> concertMap) {
        for (Integer key : concertMap.keySet()) {
            System.out.println("Key: " + key + " => " + concertMap.get(key).toString());
        }
    }

    public static double calculateRevenue(HashMap<Integer, Concert> concertMap) {
        double totalRevenue = 0.0;
        for (Concert concert : concertMap.values()) {
            totalRevenue += concert.calculateRevenue();
        }
        return totalRevenue;
    }

    public static void modifySeats(HashMap<Integer, Concert> concertMap, int key, int book) {
        {
            if (concertMap.containsKey(key)) {
                concertMap.get(key).bookTickets(book);
            } else {
                System.out.println("Concert with key " + key + " not found.");
            }
        }
    }
}



