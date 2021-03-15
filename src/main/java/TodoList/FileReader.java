package TodoList;

import java.io.*;
import java.util.ArrayList;

public class FileReader {

    public void writeAsObject(ArrayList<Task> tasks)
    {
        try
        {
            File file = new File("objectFile.txt");
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fileStream);

            writer.writeObject(tasks);
            writer.close();
            fileStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public ArrayList<Task> readAsObject()
    {
        ArrayList<Task> list = new ArrayList<>();
        try
        {
            File file = new File("objectFile.txt");
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileStream);

            for (Task task : list = (ArrayList<Task>) reader.readObject()) {

            }
            ;

            reader.close();
            fileStream.close();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        return list;

    }
}