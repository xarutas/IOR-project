/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import java.time.LocalDate;
import model.*;
import java.util.HashSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
 @author LabHiber
 */
public final class DataLoad {

    /**
     * Creates test data
     *
     * @param SESSION_FACTORY for connecting data source
     */
    
    static Logger log = LoggerFactory.getLogger(DataLoad.class);
    protected void createData(SessionFactory SESSION_FACTORY) {
 
        try (Session session = SESSION_FACTORY.openSession()) {

            Transaction tx = null;
            try {
                log.trace("insert person transaction begin");
                tx = session.beginTransaction();
                Mission mission1 = new Mission("Mars","First journey to Mars from Earth.");
                session.save(mission1);
                tx.commit();
                log.trace("insert mission transaction commit");
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                    log.trace(e.toString()); 
                }
            }    
                tx = session.beginTransaction();
                TransportFlight tf1 = new TransportFlight("Moscow","Transport flight from New York to Moscow.");
                HashSet<Cargo> cargos1 = new HashSet<>(2);
                createCargo("food","Noodle soup", cargos1);
                createCargo("food","Tomato soup", cargos1);
                tf1.setCargos(cargos1);
                session.save(tf1);

                ResearchMission rs1 = new ResearchMission("Moscow","Transport flight from New York to Moscow.");
                HashSet<Task> tasks1 = new HashSet<>(2);
                createTask("Bring weapons","Bring swords from armory.", tasks1);
                createTask("Make soup","Create a soup from ingredients.", tasks1);
                rs1.setTasks(tasks1);
                session.save(rs1);

                HashSet<Spacecraft> spacecraftSet1 = new HashSet<>(2);
                Spacecraft spacecraft1 = new Spacecraft("Kolo1", 1998, 2000, 10);
                Spacecraft spacecraft2 = new Spacecraft("Kolo2", 1999, 2500, 12);
                Mission mission3 = new Mission("Wenus","First journey to Wenus from Earth.");
                mission3.setSpacecrafts(spacecraft1);
                session.save(mission3);
                tx.commit();
            }

        }
        /**
         * tworzy obiekty klasy Child i dodaje je do listy children
         *
         * @param address
         * @param name
         * @param surname
         * @param birthDate
         * @param children
         */

    private void createCargo(String type, String description,
                             HashSet<Cargo> cargos) {
        Cargo c = new Cargo(type, description);
        cargos.add(c);
    }

    private void createTask(String name, String description,
                             HashSet<Task> tasks) {
        Task t = new Task(name, description);
        tasks.add(t);
    }

}
