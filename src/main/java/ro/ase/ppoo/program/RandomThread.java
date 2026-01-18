package ro.ase.ppoo.program;

import ro.ase.ppoo.exceptions.MyException;
import ro.ase.ppoo.models.Concert;


//Se defineste un Thread care incearca de maxim 10 ori rezervari random.
public class RandomThread extends Thread{
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println(Thread.currentThread().getName() + " is trying to book tickets...");
                Thread.sleep((int)(Math.random()*1000));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Concert concert : Main.concerts) {
                int ticketsToBook = (int) (Math.random() * 10) + 1;
                concert.bookTickets(ticketsToBook);
                System.out.println(Thread.currentThread().getName() + " booked " + ticketsToBook + " tickets for " + concert.getName());
            }
        }

    }


}
