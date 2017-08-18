package dao;

import models.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import java.util.List;
import static org.junit.Assert.*;

public class Sql2oEventDaoTest {

    private Sql2oEventDao eventDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        eventDao = new Sql2oEventDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
            con.close();
    }

    //helper
    public Event testEvent () {
        return new Event ("testEvent", "panel forum");
    }


    @Test
    public void returnEventById_Event() throws  Exception {
        Event testEvent = testEvent();
        eventDao.add(testEvent);
        Event findEvent = eventDao.findById(1);
        assertEquals("testEvent", findEvent);
    }
}