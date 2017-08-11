package models;
import java.util.ArrayList;

public class Event {
    private String name;
    private String description;
    private static ArrayList<Event> instances = new ArrayList<>();
    private ArrayList<String> attendees;
    private int id;


    public  Event (String name, String description) {
        this.name = name;
        this.description = description;
        this.attendees = attendees;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public static ArrayList<Event> getInstances() {

        return instances;
    }

    public ArrayList<String> getAttendees() {

        return attendees;
    }

    public static ArrayList<Event> getAllEvents(){

        return instances;
    }

    public static void clearAllEvents () {

        instances.clear();
    }

    public int getId() {

        return id;
    }
    public static Event findById(int id) {

        return instances.get(id-1);
    }
}

