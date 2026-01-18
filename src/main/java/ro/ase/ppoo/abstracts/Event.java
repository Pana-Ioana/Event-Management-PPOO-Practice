package ro.ase.ppoo.abstracts;

//Se defineste o clasa abstracta Event cu atribute private: name, location, ticketPrice.
//Clasa contine constructor cu parametri, getteri/setteri, toString si metoda abstracta calculateRevenue.
//Clasa implementeaza Comparable pentru comparare dupa pret si nume.
public abstract class Event implements Comparable<Event> {
    private String name;
    private String location;
    private double ticketPrice;

    public Event(String name, String location, double ticketPrice) {
        this.name = name;
        this.location = location;
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Event{" + " name='" + name + '\'' + ", location='" + location + '\'' + ", ticketPrice=" + ticketPrice + '}';
    }

    public abstract double calculateRevenue();

    @Override
    public int compareTo(Event e){
        int priceComparison = Double.compare(this.ticketPrice, e.ticketPrice);
        if(priceComparison != 0){
            return priceComparison;
        }
        else {
            return this.name.compareTo(e.name);
        }
    }
}
