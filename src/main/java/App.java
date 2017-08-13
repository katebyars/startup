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
            Event event = new Event(name, description);
            model.put("event", event);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

//        //show a form to add attendees
        get("/events/:id/attendees", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEvent = Integer.parseInt(req.params("id"));
            Event editEvent = Event.findById(idOfEvent);
            model.put("editEvent", editEvent);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());
//
//        //process a form to add attendees
        post("/events/:id/attendees", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String attendeeName = req.queryParams("attendee");
            System.out.println(attendeeName);
            int idOfEvent = Integer.parseInt(req.params("id"));
            Event editEvent = Event.findById(idOfEvent);
            editEvent.addAttendees(attendeeName);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //show all events
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Event> allEvents = Event.getAllEvents();
            model.put("allEvents", allEvents);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //show an individual event
        get("/events/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEvent = Integer.parseInt(req.params("id"));
            Event findEvent = Event.findById(idOfEvent);
            model.put("event", findEvent);
            return new ModelAndView(model, "event-detail.hbs");
        }, new HandlebarsTemplateEngine());

//        //show a form to update an event name
        get("/events/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEvent = Integer.parseInt(req.params("id"));
            Event editEvent = Event.findById(idOfEvent);
            model.put("editEvent", editEvent);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

//        //process a form to update an event name
        post("/events/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            int idOfEvent = Integer.parseInt(req.params("id"));
            Event editEvent = Event.findById(idOfEvent);
            editEvent.updateName(newName);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //show a page with About
        get("/about", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
