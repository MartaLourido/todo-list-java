package Main;

import TodoList.TodoList;

import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);
    private static TodoList todo = new TodoList();

    //Defining colours for menus
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_GREEN = "\u001B[32m";

    public static void seeMenu(){
        //String TEXT_BLUE = "\u001B[34m";
        System.out.println(TEXT_CYAN + "******** Welcome to ToDoLy ********" + TEXT_RESET );
        System.out.println(TEXT_RED + "You have: " + todo.incompleteTasksCounter() +  ' ' + "tasks to do and" + ' ' + todo.completedTasksCounter() + ' ' + "done" + TEXT_RESET);
        System.out.println(TEXT_CYAN + "         ****************          " + TEXT_RESET );
        System.out.println(TEXT_CYAN + "Pick an option:" + TEXT_RESET );
        System.out.println(TEXT_GREEN  + "1." + TEXT_RESET + "Show Task List (by date or project) ");
        System.out.println(TEXT_GREEN  + "2." + TEXT_RESET + "Add a new Task");
        System.out.println(TEXT_GREEN  + "3." + TEXT_RESET + "Edit Task (update, mark as done, remove)");
        System.out.println(TEXT_GREEN  + "4." + TEXT_RESET + "Save and Quit");
        System.out.println(TEXT_PURPLE + "|  *Type a number to make a selection*  |" + TEXT_RESET);
        System.out.print(TEXT_CYAN + "Selection: " + TEXT_RESET);
    }

    public void showTasksMenu(){
        {
            System.out.println("What do you want to edit in this task?");
            System.out.println("Pick an option:");
            System.out.println("(1) 1. Show Task List");
            System.out.println("(2) 2. Show Task by date");
            System.out.println("(3) 3. Show Task by project");
            System.out.println("(4) Go back to the main menu");
            System.out.print("Selection: ");

            //Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int editChoices = Integer.parseInt(input);

            switch(editChoices) {

                case 1 -> {
                    todo.showTasks();
                }

                case 2 -> {
                   /**showTaskByDate will print the tasks in descending order,
                    * starting from the one with the nearest due date */
                    System.out.println("Here you can see your tasks sorted by due date:");
                    todo.showTasksByDate() ;
                }

                case 3 -> {
                    //ShowTaskByProject will print the tasks by project
                    System.out.println("Here you can see your tasks sorted by projects:");
                    todo.showTasksByProject();
                }

                case 4 -> {
                   break; //Go back to the main menu
                }

                default -> throw new IllegalStateException("Unexpected value: " + editChoices);
            }

            todo.save();
            todo.showTasks();
        }

    }


    public void run()
    {

        int choice = 0;
        while (choice != 4)
        {
            //see the menu
            seeMenu();
            String input = scanner.nextLine();
            choice = Integer.parseInt(input);

            System.out.println("Please, choose the task which you want to edit, update or remove");

            //switch with some cases which call the add, remove, and another methods from the TodoList/TaskList


            switch (choice) {
                case 1 -> {
                    System.out.println("Show Task List");
                    showTasksMenu();
                }
                case 2 -> {
                    System.out.println("Add new Task");
                    todo.addTask();
                }
                case 3 -> {
                    todo.editOneTask();
                }
                case 4 -> {
                    System.out.println("Thank you for using ToDoLY today! Goodbye!");
                    todo.save();
                    System.exit(0);
                }
                default -> System.out.println("please write a correct number between 1 and 4");
            }

        }


        //todo have validate integer here:
        //validateInteger();
    }

}


//validating the choice from the user and checking its a number

   /** public int validateInteger() {
    Scanner scanner = new Scanner(System.in);
    int number = 5;
        while (i <= 0) {
            try {
                number = scanner.nextLine();
                System.out.println("Please, enter a number between 1 and 5");
            } catch (Exception e) {
                System.out.println("Please, choose a valid option");
            }
        }


    //validate integer
/**
    public void validateInteger() {
        scanner = new Scanner(System.in);
        String myInteger = "";

        try {
            myInteger = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Please, choose a valid option");
        }
    }
*/


/**public void editTaskOptions()
{
    String editChoices = scanner.nextLine();
    MenuEditTaskOptions();

    int index = Integer.parseInt(scanner.nextLine()); //todo change this to make a call to validate int method

    switch(editChoices) {

        case "1" -> {
            todo.editOneTask(index);
            todo.editTaskOptions();
            System.out.println("(1) Edit title of the task");
        }

        case "2" -> {
            todo.markAsDone(index);
            System.out.println("(2) Edit the due date of the task");

        }

        case "3" -> {
            todo.removeTask(task);
            System.out.println("Task deleted successfully!");

        }


        default -> throw new IllegalStateException("Unexpected value: " + editChoices);
    }
} */




    //todo have validate integer here:



































