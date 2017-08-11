import models.Event;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.*;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        //show a new event form
        get("/events/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        //process a new event form
        post("/events/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String description = req.queryParams("description");
            String[] attendeeNames = req.queryParamsValues("attendee");
            List<String> attendees = Arrays.asList(attendeeNames);
            Event event = new Event(name, description, attendees);
            model.put("event", event);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //show all events
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Event> allEvents = Event.getAllEvents();
            model.put("allEvents", allEvents);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //show an individual event
        get("/event/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEvent = Integer.parseInt(req.params("id"));
            Event findEvent = Event.findById(idOfEvent);
            model.put("event", findEvent);
            return new ModelAndView(model, "event-detail.hbs");
        }, new HandlebarsTemplateEngine());
//
//        //show a form to update an event
//        //process a form to update an event
//        //delete an event
//        }
    }
}
