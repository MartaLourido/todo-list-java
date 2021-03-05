package TodoList;

import Tasks.Task;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class TodoList
{

    private ArrayList<Task> tasks ;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public TodoList()
    {

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
        System.out.println("-----------------");
        int number = 0;
        for (Task task : tasks) {
            System.out.println(++number + " " + task);
        }
        System.out.println("-----------------");

    }

    //method for remove one task

    public  void removeTask() {
        System.out.println("Remove Task");
        Scanner scanner = new Scanner(System.in);
        System.out.print("What task do you want to remove?:");
        int index = scanner.nextInt();
        if((index-1)<0 || index>tasks.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to "+tasks.size());
        }else {
            tasks.remove(index-1);
        }
        System.out.println("The task has been successfully deleted");
        showTasks();

    }

    //method for sort the tasks

    public void sortTasks() {
        System.out.println("Sorted tasks by date (earliest first): ");
        sort(tasks);
        this.showTasks();
    }

    private void sort(ArrayList<Task> tasks) {
    }


    public void addTask()
    {

        Task task = new Task();
        //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your name");
        String name = scanner.nextLine();
        System.out.println("Please, enter the name of the project you want to add the task to");
        String project = scanner.nextLine();
        System.out.println("Please, enter a title for the task");
        String title = scanner.nextLine();
        System.out.print("Enter the task due date (dd/mm/yyyy): ");
        Date date = validateDate();

        task.setTitle(name);
        task.setProject(project);
        task.setUser(title);
        task.setDate(date);
        tasks.add(task);
        showTasks(); //for see the task when we add it
    }

    //Writing and reading

    public void fillList()
    {
        // public Task(String title, String Date, String user, String project, boolean isDone)
        // public Task(String title, String date, String user, String project, boolean isDone)
        Task t1 = new Task("t1", new Date(), "u1", "p2", true);
        Task t2 = new Task("t2", new Date(), "u2", "p1", false);
        Task t3 = new Task("t3", new Date(), "u2", "p2", false);
        Task t4 = new Task("t4", new Date(), "u1", "p1", true);

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
                // Task{title='t1', date=2020, user='u1', project='p2', isDone=true}
                data = line.split(", ");

                String title = data[0].substring("Task{title='".length() , data[0].length() -1);
                String dateString = data[1].substring("Date=".length());
                String user = data[2].substring("user='".length() , data[2].length() -1);
                String project = data[3].substring("project='".length() , data[3].length() -1);
                String statusString = data[4].substring("isDone=".length() , data[4].length() -1);

                Task t = new Task(title, convertToDate(dateString), user, project, Boolean.parseBoolean(statusString));
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

    public Date validateDate()
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            Date date = convertToDate(scanner.nextLine());
            if( date  != null)
                return date;
            else
                System.out.println("please enter the date correctly");
        }

    }

    public Date convertToDate(String dateString)
    {
        try {
            return format.parse(dateString);
        }
        catch (ParseException e)
        {
            //e.printStackTrace();
            return null;
        }
    }
























}




