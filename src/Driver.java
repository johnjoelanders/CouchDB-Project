import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver {
    public static void main(String[] args) {
        JPanel panel;
        JFrame frame;
        panel = new JPanel();

        JButton createButton = new JButton("Create");
        panel.add(createButton);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateDoc createDoc = new CreateDoc();
                createDoc.CreateDoc();
            }
        });
        JButton deleteButton = new JButton("Delete");
        panel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDoc deleteDoc = new DeleteDoc();
                deleteDoc.DeleteDoc();
            }
        });

        JButton readButton = new JButton("Read");
        panel.add(readButton);
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadDoc readDoc = new ReadDoc();
                readDoc.ReadDoc();
            }
        });
        JButton updateButton = new JButton("Update");
        panel.add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateDoc updateDoc = new UpdateDoc();
                updateDoc.UpdateDoc();
            }
        });
        JButton mapreduceButton = new JButton("Display map reduce");
        panel.add(mapreduceButton);
        mapreduceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CallMapReduce callMapReduceDoc = new CallMapReduce();
                callMapReduceDoc.MapReduce();
            }
        });

        frame = new JFrame("GUI");
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
    }
}
