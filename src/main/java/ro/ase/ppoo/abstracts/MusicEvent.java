package ro.ase.ppoo.abstracts;

//Se defineste clasa abstracta MusicEvent care extinde Event.
//Atribute: artist, durationHours, indoor.
public abstract class MusicEvent extends Event{
    private String artist;
    private int durationHours;
    private boolean indoor;

    public MusicEvent(String name, String location, double ticketPrice, String artist, int durationHours, boolean indoor) {
        super(name, location, ticketPrice);
        this.artist = artist;
        this.durationHours = durationHours;
        this.indoor = indoor;
    }

    @Override
    public String toString() {
        return "MusicEvent { " +  "artist='" + artist + '\'' + ", durationHours=" + durationHours + ", indoor=" + indoor + "} in:  " + super.toString();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }
}
