import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import javax.swing.*;

public class UpdateDoc {
    String id;

    public void UpdateDoc() {
        //Response resp;
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

            JsonObject jsonUpdate = dbClient.find(JsonObject.class, id);
            jsonUpdate.addProperty("make", JOptionPane.showInputDialog(null, "Enter the make"));
            jsonUpdate.addProperty("model", JOptionPane.showInputDialog(null, "Enter the Model"));
            jsonUpdate.addProperty("rented", JOptionPane.showInputDialog(null, "Enter the rented status y = rented n = not rented"));
            jsonUpdate.addProperty("colour", JOptionPane.showInputDialog(null, "Enter the colour"));
            jsonUpdate.addProperty("cost", JOptionPane.showInputDialog(null, "Enter the cost"));
            dbClient.update(jsonUpdate);


        } catch (org.lightcouch.DocumentConflictException e) {

            JOptionPane.showMessageDialog(null, "In catch");

        }
        dbClient.shutdown();
    }
}
