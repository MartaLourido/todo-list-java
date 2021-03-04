package TodoList;

import Tasks.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class TodoList
{

    private ArrayList<Task> tasks;

    public TodoList()
    {
        //here would be the constructor but not for now, working on other things;
        tasks = readAsData(); //todo
        //tasks = new ArrayList<>();
    }

    //trying to get the task  sorted

    public List< Task > getTasksSortedByDate ( )
    {
        // Make a copy of our `SortedSet`, to be separate from our own here.
        // This way the calling method can do what they want, as can this class,
        // while not stepping on each other's feet.
        Objects.requireNonNull( this.tasks ); // Paranoid check.
        return List.copyOf( this.tasks );
    }

    //method for show the tasks
    public void showTasks() {
        System.out.println("To-Do List Tasks");
        int number = 0;
        for (Task task : tasks) {
            System.out.println(++number + " " + task);
        }
        getTasksSortedByDate();
    }

    //method for remove a task

    public  void removeTask() {
        System.out.println("Remove Task");
        Scanner scanner = new Scanner(System.in);
        System.out.print("What task do you want to remove?");
        int index = scanner.nextInt();
        if((index-1)<0 || index>tasks.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to "+tasks.size());
        }else {
            tasks.remove(index-1);
        }
        System.out.println("The task has been successfully deleted");
        showTasks();

    }

    public void addTask() {
        // commenting the new task because i am learning how to create a constructor in the todolist and i got an error from the IDE when i did it
        Task task = new Task();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your name");
        String name = scanner.nextLine();
        System.out.println("Please, enter the name of the project you want to add the task to");
        String project = scanner.nextLine();
        System.out.println("Please, enter a title for the task");
        String title = scanner.nextLine();
        System.out.println("Please enter due date");
        String date = scanner.nextLine();

        task.setTitle(name);
        task.setProject(project);
        task.setUser(title);
        tasks.add(task);
        //showTasks();
    }

    //Writing and reading

    public void fillList()
    {
        // public Task(String title, String dueDate, String user, String project, boolean isDone)
        Task t1 = new Task("t1", "2020", "u1", "p2", true);
        Task t2 = new Task("t2", "2020", "u2", "p1", false);
        Task t3 = new Task("t3", "2020", "u2", "p2", false);
        Task t4 = new Task("t4", "2020", "u1", "p1", true);

        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        tasks.add(t4);

    }

    public void writeAsData()
    {
        try
        {
            File file = new File("dataFile.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Task task : tasks)
                writer.write(task.toString() + "\n");


            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> readAsData()
    {
        ArrayList<Task> list = new ArrayList<>();
        try
        {
            File file = new File("dataFile.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            String[] data ;
            while( (line = reader.readLine()) != null )
            {
                // Task{title='t1', dueDate=2020, user='u1', project='p2', isDone=true}
                data = line.split(", ");

                String title = data[0].substring("Task{title='".length() , data[0].length() -1);
                String date = data[1].substring("dueDate=".length());
                String user = data[2].substring("user='".length() , data[2].length() -1);
                String project = data[3].substring("project='".length() , data[3].length() -1);
                String statusString = data[4].substring("isDone=".length() , data[4].length() -1);

                Task t = new Task(title, date, user, project, Boolean.parseBoolean(statusString));
                list.add(t);
            }


            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }


    public void writeAsObject()
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

            list = (ArrayList<Task>) reader.readObject();

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




