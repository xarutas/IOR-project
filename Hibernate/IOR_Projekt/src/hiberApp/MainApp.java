/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import util.HiberUtil;
import org.hibernate.SessionFactory;

/* 
 @author LabHiber
 */
public final class MainApp {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);

    public static void main(String[] args) {
        
        final DataLoad dataLoad = new DataLoad();
        dataLoad.createData(SESSION_FACTORY);
//       final DataQueries dataQueries = new DataQueries();
//        dataQueries.showAll(SESSION_FACTORY);
       
    }
}
