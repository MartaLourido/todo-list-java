package TodoList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class TodoList
{

    private ArrayList<Task> tasks ;
    private FileReader writerAndReader;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");

    public TodoList()
    {
        writerAndReader = new FileReader();
        tasks =  writerAndReader.readAsObject(); //todo

    }

    //getting the size of the task so when we show the task list we can give this information

    /**public int getSize() {
        return this.Task.size();
    }

    //compare tasks by date

    public void compareByDate() {
        Task.sort(this.Task, new CompareTasks());
        //I was trying to use collection  sort but it doesnt work
    } */

    //trying to get the task  sorted


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

    public  void removeTask(int index)
    {
        System.out.println("Remove Task");

        if((index-1)<0 || index>tasks.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to "+tasks.size());
        }else {
            tasks.remove(index-1);
        }
        System.out.println("The task has been successfully deleted");
        showTasks();

    }


    /** markAsDone marks the task status as true
     */

    public void markAsDone(int index)
    {
        if((index-1) < 0 || index > tasks.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to "+ tasks.size());
        }else {
            Task task = tasks.get(index);
            System.out.println("Marking " + task.toString() + " as done");
            task.markAsDone();
        }
    }


    public void addTask()
    {

        Task task;
        task = new Task();
        //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your name");
        String name = scanner.nextLine();
        System.out.println("Please, enter the name of the project you want to add the task to");
        String project = scanner.nextLine();
        System.out.println("Please, enter a title for the task");
        String title = scanner.nextLine();
        System.out.print("Enter the task due date (dd/mm/yyyy): ");
        LocalDate date = validateDate();

        task.setTitle(name);
        task.setProject(project);
        task.setUser(title);
        task.setDate(date);
        tasks.add(task);
        save();
        showTasks(); //for see the task when we add it
    }


    public void save() {
    writerAndReader.writeAsObject(tasks);
    }

    /**Writing and reading



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


     */



    public LocalDate validateDate()
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            LocalDate date = convertToDate(scanner.nextLine());
            if( date  != null)
                return date;
            else
                System.out.println("please enter the date correctly");
        }

    }

    public LocalDate convertToDate(String dateString)
    {
        try {
            return LocalDate.parse(dateString, formatter);
        }
        catch (DateTimeParseException e)
        {
            return null;
        }
    }



}




