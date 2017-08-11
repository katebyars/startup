package models;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String description;
    private static ArrayList<Event> instances = new ArrayList<>();
    private List<String> attendees;
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

    public List<String> getAttendees() {

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

    public List<String> addAttendees(List<String> attendeeNames) {
        List <String> attendees = getAttendees();
        this.attendees = attendeeNames;
        return this.attendees;
    }
    public void updateName(String name) {
        this.name = name;
    }
}

