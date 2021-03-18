package TodoList;

import Main.UserInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList
{
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Task> tasks ;
    private FileReader writerAndReader;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TodoList()
    {
        writerAndReader = new FileReader();
        tasks =  writerAndReader.readAsObject(); //todo

    }

    //getting the size of the task so when we show the task list we can give this information

    public int getSize() {
        return this.tasks.size();
    }

    public void showTasks() {
        System.out.println("To-Do List Tasks");
        System.out.println("-----------------");
        int number = 0;
        for (Task task : tasks) {
            System.out.println(++number + " " + task);
        }
        System.out.println("-----------------");

    }


    //mark as done

    public void markAsDone2(Task task) {

        if (task.getIsDone()) {
            System.out.println("No such task!");
        } else {
            task.setIsDone(true);
            System.out.println("Marking " + task + " as completed");
        }
    }
    

    //method for remove one task

    public  void removeTask(Task task)
    {
        System.out.println("Remove Task");

        tasks.remove(task);

        System.out.println("The task has been successfully deleted");

    }

    /** editOneTask edit the task
     */

    public  void editOneTask()
    {
        showTasks();
        System.out.println("What task do you want to edit?");
        String indexString = scanner.nextLine();

       int index = Integer.parseInt(indexString);

        if((index-1)<0 || index>tasks.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to "+ tasks.size());
        }else {
            Task task = tasks.get(index-1);
            editTaskOptions(task);
            System.out.println("The task " + task.toString() + " successfully edited");
            showTasks();
        }
    }

    //I need to fix the index first, the user has to choose first what task he/She wants to edit and then get what want to edit about that task.
    //markasdone is not really working as well.

    public void editTaskOptions(Task task)
    {
        System.out.println("What do you want to edit in this task?");
        System.out.println("Pick an option:");
        System.out.println("(1) Edit title of the task");
        System.out.println("(2) Edit the due date of the task");
        System.out.println("(3) Edit the project of the task");
        System.out.println("(4) Mark as done");
        System.out.println("(5) Delete task");
        System.out.println("(6) Go back to the main menu");    
        System.out.print("Selection: ");

        //Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int editChoices = Integer.parseInt(input);

        switch(editChoices) {

            case 1 -> {
                System.out.println("Write a new title for this task:");
                String title = scanner.nextLine();
                task.setTitle(title);
                System.out.println("Task title has been edited!");
            }

            case 2 -> {
                System.out.print("Write a new due date (dd/mm/yyyy) for this task: ");
                LocalDate date = validateDate();
                task.setDate(date);
                System.out.println("The due date has been changed!");
            }

            case 3 -> {
                System.out.println("Write a new project name for this task:");
                String project = scanner.nextLine();
                task.setProject(project);
                System.out.println("Task project has been edited!");
            }

            case 4 -> {
                markAsDone2(task);
                System.out.println("Yup!Task done!");
                break;
            }

            case 5 -> {
                System.out.println("The task will be removed!");
                removeTask(task);
                System.out.println("Task removed successfully!");
            }

            case 6 -> {
                System.out.println("Back to the main menu");
                UserInterface.seeMenu();
             }
             
            default -> throw new IllegalStateException("Unexpected value: " + editChoices);
        }

        //validateInteger();
        save();
        //tasks =  writerAndReader.readAsObject();
        showTasks();
    }

    //validate integer

    public void validateInteger() {
        scanner = new Scanner(System.in);
        String myInteger = "";

        try {
            myInteger = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Please, choose a valid option");
        }
    }



    /** markAsDone marks the task status as true
     */

   /** public  void markDone(Task task)
    {
          System.out.println("Mark task as done");

          tasks.get(task).isDone();
                                                                               
          System.out.println("Yup! Task done!");

    }    */




    //counter for the completed task

    public int completedTasksCounter() {
        int counter = 0;
        for (Task task : tasks) {
            if (task.getIsDone())
                counter ++;
        }
        return counter;
    }

    //counter fot the incompleted task

       public int incompletedTasksCounter() {
           int counter = 0;
           for (Task task : tasks)  {
               if (!task.getIsDone()) {
                   counter ++;
               }
           }
           return counter;
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


        task.setUser(name);
        task.setTitle(title);
        task.setProject(project);
        task.setDate(date);
        tasks.add(task);
        save();
        showTasks(); //for see the task when we add it
    }





    //method for save the tasks in the FileReader
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
            System.out.println(e.getMessage());
            return null;
        }
    }



}




