import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.Response;

import javax.swing.*;

public class CreateDoc {
    Response resp;
    CouchDbClient dbClient;
    CouchDbProperties properties;

    public void CreateDoc() {

        properties = new CouchDbProperties()
                .setDbName("listofcars")
                .setCreateDbIfNotExist(true)
                .setProtocol("http")
                .setHost("127.0.0.1")
                .setPort(5984);

        dbClient = new CouchDbClient(properties);


        int response = JOptionPane.YES_OPTION;
        while (response == JOptionPane.YES_OPTION) {
            JsonObject object = new JsonObject();
            object.addProperty("make", JOptionPane.showInputDialog(null, "Enter the make"));
            object.addProperty("model", JOptionPane.showInputDialog(null, "Enter the Model"));
            object.addProperty("rented", JOptionPane.showInputDialog(null, "Enter the rented status y = rented n = not rented"));
            object.addProperty("colour", JOptionPane.showInputDialog(null, "Enter the colour"));
            object.addProperty("cost", JOptionPane.showInputDialog(null, "Enter the cost"));

            try {
                resp = dbClient.save(object);
            } catch (org.lightcouch.DocumentConflictException e) {

            }

            response = JOptionPane.showConfirmDialog(null, "Do you want to enter another car", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        }
    }
}
