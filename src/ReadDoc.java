import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import javax.swing.*;

public class ReadDoc {
    String id;
    String rev;

    public void ReadDoc() {
        CouchDbClient dbClient;
        CouchDbProperties properties;

        properties = new CouchDbProperties()
                .setDbName("listofcars")
                .setCreateDbIfNotExist(true)
                .setProtocol("http")
                .setHost("127.0.0.1")
                .setPort(5984);

        dbClient = new CouchDbClient(properties);

        id = JOptionPane.showInputDialog(null, "Input id");
        System.out.println("" + id);

        try {
            //resp = dbClient.remove(id, rev);
            boolean found = dbClient.contains(id);
            JsonObject json = dbClient.find(JsonObject.class, id);
            JOptionPane.showMessageDialog(null, "Inside Json: " + json);

        } catch (org.lightcouch.DocumentConflictException e) {

            JOptionPane.showMessageDialog(null, "In catch");

        }
        dbClient.shutdown();
    }
}
