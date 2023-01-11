/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DB4OUtil;

import Business.SystemConfiguration;
import Business.ESystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.nio.file.Paths;

/**
 *
 * @author gandh
 */
public class DB4OUtil {

    //getting the absolute path to store the db
    // usually main folder + db4o
    private static final String FILENAMEDB = Paths.get("Databank.db4o").toAbsolutePath().toString();
    private static DB4OUtil dB4OUtil;

    public synchronized static DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer connection) {
        if (connection != null) {
            connection.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //checks the no of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //checks the depth of changes
            config.common().updateDepth(Integer.MAX_VALUE);

            //Registering Esystem
            config.common().objectClass(ESystem.class).cascadeOnUpdate(true);

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAMEDB);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }
//store data

    public synchronized void storeSystem(ESystem system) {
        ObjectContainer connection = createConnection();
        connection.store(system);
        connection.commit();
        connection.close();
    }

    // retrieve data on application run
    public ESystem retrieveSystem() {
        ObjectContainer conn = createConnection();
        ObjectSet<ESystem> systems = conn.query(ESystem.class);
        ESystem system;
        if (systems.size() == 0) {
            system = SystemConfiguration.configure();
        } else {
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;
    }

}
