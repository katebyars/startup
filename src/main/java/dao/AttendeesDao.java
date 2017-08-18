package dao;
import java.util.List;
import models.Event;
import models.Attendees;


public interface AttendeesDao {


    //create an attendee
    void add (Attendees attendees);

    //read
    List<Attendees> getAll();

    //find an attendee by id
    Attendees findById(int id);

    //update attendee details
    void update(int id, String name);

    //delete a single attendee by id
    void deleteById(int id);

    //delete all attendees from system
    void clearAllAttendees();

    //delete all attendees from an event
    void deleteAllAttendeesFromSingleEvent();
}
