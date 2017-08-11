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

        //show all events
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Event> allEvents = Event.getAllEvents();
            model.put("allEvents", allEvents);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //show an individual event
//        get("/posts/:id", (req, res) -> {
////            Map<String, Object> model = new HashMap<>();
////            int idOfEvent = Integer.parseInt(req.params("id"));
////            Event findEvent = Event.findById(idOfPostToFind); //use it to find post
////            model.put("post", foundPost); //add it to model for template to display
////            return new ModelAndView(model, "post-detail.hbs"); //individual post page.
////        }, new HandlebarsTemplateEngine());
//
//        //show a form to update an event
//        //process a form to update an event
//        //delete an event
//        }
    }
}
