package ro.ase.ppoo.models;

import ro.ase.ppoo.abstracts.MusicEvent;
import ro.ase.ppoo.interfaces.Bookable;


//Se defineste clasa Concert care extinde MusicEvent si implementeaza Bookable.
//Atribute: totalSeats, bookedSeats.
//Se implementeaza constructor, constructor de copiere, toString si metodele abstracte.

public class Concert extends MusicEvent implements Bookable {
    private int totalSeats;
    private int bookedSeats;

    public Concert(String name, String location, double ticketPrice, String artist, int durationHours, boolean indoor, int totalSeats, int bookedSeats) {
        super(name, location, ticketPrice, artist, durationHours, indoor);
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
    }

    public Concert(Concert c){
        this(c.getName(), c.getLocation(), c.getTicketPrice(), c.getArtist(), c.getDurationHours(), c.isIndoor(), c.totalSeats, c.bookedSeats);
    }

    @Override
    public double calculateRevenue() {
        return getTicketPrice() * bookedSeats;
    }

    @Override
    public synchronized void bookTickets(int numberOfTickets) {
        if(bookedSeats + numberOfTickets<= totalSeats){
            bookedSeats += numberOfTickets;
        }
        else {
            System.out.println("Not enough available seats!");
        }
    }

    @Override
    public String toString() {
        return "Concert {" + " totalSeats=" + totalSeats + ", bookedSeats=" + bookedSeats + "} " + super.toString();
    }
}
