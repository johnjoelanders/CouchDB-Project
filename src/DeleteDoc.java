import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.Response;

import javax.swing.*;

public class DeleteDoc {
    String id;
    String rev;

    public void DeleteDoc() {
        CouchDbClient dbClient;

        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("listofcars")
                .setCreateDbIfNotExist(true)
                .setProtocol("http")
                .setHost("127.0.0.1")
                .setPort(5984);

        dbClient = new CouchDbClient(properties);

        Response resp;

        id = JOptionPane.showInputDialog(null, "Input id");
        System.out.println("" + id);
        rev = JOptionPane.showInputDialog(null, "Input rev");
        System.out.println("" + rev);
        try {
            resp = dbClient.remove(id, rev);

        } catch (org.lightcouch.DocumentConflictException e) {

        }
        dbClient.shutdown();

    }
}
