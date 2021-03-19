package TodoList;

import java.io.*;
import java.util.ArrayList;

public class FileReader {

    //method which writes the object to a file
    public void writeAsObject(ArrayList<Task> tasks) {
        try {
            File file = new File("objectFile.txt");
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fileStream);

            writer.writeObject(tasks);
            writer.close();
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //This method will read the object from the file
    public ArrayList<Task> readAsObject() {
        ArrayList<Task> list = new ArrayList<>();

        File file1 = new File("objectFile.txt");

        if (!file1.exists())
            return list;

        try {
            File file = new File("objectFile.txt");

            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileStream);

            for (Task task : list = (ArrayList<Task>) reader.readObject()) {

            }

            reader.close();
            fileStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
