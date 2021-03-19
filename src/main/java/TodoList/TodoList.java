package TodoListTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class TodoList {
    private final Scanner scanner = new Scanner(System.in);
    DateTimeFormatter SimpleDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ArrayList<Task> tasks;
    private FileReader writerAndReader;
    //colors for printing with style
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_GREEN = "\u001B[32m";

    public TodoList() {
        writerAndReader = new FileReader();
        tasks = writerAndReader.readAsObject(); //todo

    }

    public TodoList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void showTasks() {
        System.out.println(TEXT_GREEN + "To-Do List Tasks" + TEXT_RESET);
        System.out.println(TEXT_GREEN + "-----------------" + TEXT_RESET);
        int number = 0;
        for (Task task : tasks) {
            System.out.println(++number + " " + task);
        }
        System.out.println(TEXT_GREEN + "-----------------" + TEXT_RESET);

    }


    //method for mark a task as done in the Edit Task

    public void markAsDone(Task task) {

        if ( task.getIsDone() ) {
            System.out.println("No such task!");
        } else {
            task.setIsDone(true);
            System.out.println("Marking " + task + " as completed");
        }
    }


    //method for remove one task

    public void removeTask(Task task) {
        System.out.println("Remove Task");

        tasks.remove(task);

        System.out.println("The task has been successfully deleted");

    }

    /**
     * method for sort the tasks by project
     */
    public void showTasksByProject() {
        List<Task> list = this.tasks.stream()
                .sorted(Comparator.comparing(task -> task.getProject()))
                .collect(Collectors.toList());
        this.tasks = new ArrayList<>(list);
    }

    /**
     * method for sort the tasks by date using the CompareTask class
     */
    public void showTasksByDate() {
        Collections.sort(this.tasks, new CompareTasks());
    }


    /**
     * method editOneTask allow us to edit/update one task
     */

    public void editOneTask() {
        showTasks();
        System.out.println(TEXT_RED + "What task do you want to edit?" + TEXT_RESET);
        String indexString = scanner.nextLine();

        int index = Integer.parseInt(indexString);

        if ( (index - 1) < 0 || index > tasks.size() ) {
            System.out.println(TEXT_RED + "Wrong index number! Please enter in range of 1 to " + tasks.size() + TEXT_RESET);
        } else {
            Task task = tasks.get(index - 1);
            editTaskOptions(task);
            System.out.println("The task " + task.toString() + " successfully edited");
            showTasks();
        }
    }


    public void editTaskOptions(Task task) {

        System.out.println(TEXT_RED + "What do you want to edit in this task?" + TEXT_RESET);
        System.out.println("Pick an option:");
        System.out.println("(1)"+ TEXT_CYAN + "Edit title of the task" + TEXT_RESET);
        System.out.println("(2)"+ TEXT_CYAN + "Edit due date of the task" + TEXT_RESET);
        System.out.println("(3)"+ TEXT_CYAN + "Edit project of the task" + TEXT_RESET);
        System.out.println("(4)"+ TEXT_CYAN + "Mark task as done" + TEXT_RESET);
        System.out.println("(5)"+ TEXT_CYAN + "Delete task" + TEXT_RESET);
        System.out.println("(6)" + TEXT_GREEN+ "Go back to the main menu" + TEXT_RESET);
        System.out.print(TEXT_RED + "Selection: " + TEXT_RESET);

        String input = scanner.nextLine();
        int editChoices = Integer.parseInt(input);

        switch (editChoices) {

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
                markAsDone(task);
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
                break;//using break for go back to the main menu
            }

            default -> throw new IllegalStateException("Unexpected value: " + editChoices);
        }

        //validateInteger();
        save();
        //tasks =  writerAndReader.readAsObject();
        showTasks();
    }


    //counter for the completed task

    public int completedTasksCounter() {
        int counter = 0;
        for (Task task : tasks) {
            if ( task.getIsDone() )
                counter++;
        }
        return counter;
    }

    //counter fot the incomplete task

    public int incompleteTasksCounter() {
        int counter = 0;
        for (Task task : tasks) {
            if ( !task.getIsDone() ) {
                counter++;
            }
        }
        return counter;
    }

    //method for add a Task
    public void addTask() {
        Task task;
        task = new Task();
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


    //method for validate de date
    public LocalDate validateDate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            LocalDate date = convertToDate(scanner.nextLine());
            if ( date != null )
                return date;
            else
                System.out.println("please enter the date correctly");
        }

    }

    //method for convert the date
    public LocalDate convertToDate(String dateString) {
        try {
            return LocalDate.parse(dateString, SimpleDateFormat);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}




