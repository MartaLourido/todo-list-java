package Main;

import TodoList.TodoList;

import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);
    private static TodoList todo = new TodoList();

    public static void seeMenu(){
        //String TEXT_BLUE = "\u001B[34m";
        System.out.println(/**TEXT_BLUE*/  "Welcome to ToDoLy");
        System.out.println("You have:" + todo.incompletedTasksCounter() +  ' ' + "tasks todo and" + ' ' + todo.completedTasksCounter() + ' ' + "done");
        System.out.println("Pick an option:");
        System.out.println("1. Show Task List (by date or project) ");
        System.out.println("2. Add New Task");
        System.out.println("3. Edit Task (update, mark as done, remove)");
        System.out.println("4. Save and Quit");
        System.out.println("|  *Type a number to make a selection*  |");
        System.out.print("Selection: ");
    }

    //System.out.println("3. Edit Task (update, mark as done, remove)"); Working on edit and update
   /** public void MenuEditTask() {
        System.out.println("Start editing a task in ToDoLY");
        todo.showTasks();
        System.out.println("Pick an option:");
        System.out.println("(1) Edit task"); //what task do you want to edit? index
        System.out.println("(2) Mark as done"); //what task do you want to mark as done? index
        System.out.println("(3) Delete task");//what task do you want to delete? index
        //System.out.println("(4) Return to main menu");
        System.out.print("Selection: ");;
    }*/

    //Menu for choose what task do you want to edit and what do you want to edit
    public void MenuEditTaskOptions() {

        todo.editOneTask();
        System.out.println("What do you want to edit in this task?");
        System.out.println("Pick an option:");
        System.out.println("(1) Edit title of the task");
        System.out.println("(2) Edit the due date of the task");
        System.out.println("(3) Edit the project of the task");
        System.out.println("(4) Mark as done");
        System.out.println("(5) Delete task");
        System.out.print("Selection: ");

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
                    todo.showTasks();
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
/**
    public int validateInteger() {
    Scanner scanner = new Scanner(System.in);
    int i = 5;
        while (i <= 0) {
            try {
                System.out.println("Please, enter a number between 1 and 5");
            } catch (InputMismatchException exception) {
                System.out.println("Please enter a number between 1 - 5");

            }
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



































