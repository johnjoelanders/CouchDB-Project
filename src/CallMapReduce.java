import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import javax.swing.*;
import java.util.Iterator;
import java.util.List;

public class CallMapReduce {
    public void MapReduce() {
        CouchDbClient dbClient;
        CouchDbProperties properties;

        properties = new CouchDbProperties()
                .setDbName("listofcars")
                .setCreateDbIfNotExist(true)
                .setProtocol("http")
                .setHost("127.0.0.1")
                .setPort(5984);

        dbClient = new CouchDbClient(properties);

        try {
            List<JsonObject> jList;
            jList= dbClient.view("car/most_popular").group(true).query(JsonObject.class);
            StringBuilder builder = new StringBuilder();
            Iterator<JsonObject> iterator = jList.iterator();
            while(iterator.hasNext()){
                builder.append(iterator.next()+"\n");
            }
            JOptionPane.showMessageDialog(null, "Inside view: \n" + builder.toString());

        } catch (org.lightcouch.DocumentConflictException e) {

            JOptionPane.showMessageDialog(null, "In catch");

        }
    }
}
