import models.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EventTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Event.clearAllEvents();
    }

    @Test public void EventInstantiates_True () throws Exception{
        Event eventOne = new Event("StartUp Weekend One", "event");
        assertTrue(eventOne instanceof Event);
    }
    @Test public void eventHasAName_True () {
        Event eventTwo = new Event("StartUp Weekend", "event");
        assertEquals("StartUp Weekend", eventTwo.getName());
    }
    @Test public void allEventsAreCorrectlyReturned_True ()throws Exception {
        Event eventThree = new Event("StartUp Weekend", "An event");
        Event eventFour = new Event("StartUp Weekend", "An event");
        assertEquals(2, Event.getAllEvents().size());
    }
    @Test public void allEventsContainsAllEvents_True() {
        Event eventFour = new Event("StartUp Weekend", "An event");
        Event eventFive = new Event("StartUp Weekend", "An event");
        assertTrue(Event.getAllEvents().contains(eventFour));
        assertTrue(Event.getAllEvents().contains(eventFive));
    }
    @Test public void eventInstantiatesWithAnId_True() throws Exception {
        Event eventSix = new Event("StartUp Weekend", "An event");
        assertEquals(1, eventSix.getId());
    }
    @Test public void eventReturnedById() throws Exception {
        Event eventSeven = new Event("StartUp Weekend", "An event");
        assertEquals(1, Event.findById(eventSeven.getId()).getId());
    }
    @Test public void findEventWhenMoreThanOneEvent() throws Exception {
        Event eventEight = new Event("StartUp Weekend", "An event");
        Event eventNine = new Event("StartUp Weekend", "An event");
        Event eventTen = new Event("StartUp Weekend", "An event");
        assertEquals(3, Event.findById(eventTen.getId()).getId());
    }
}