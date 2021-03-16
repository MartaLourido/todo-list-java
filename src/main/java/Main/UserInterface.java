package Main;

import TodoList.TodoList;

import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);
    private TodoList todo = new TodoList();

    public void seeMenu(){
        System.out.println("Welcome to ToDoLy");

        //System.out.println("You have X tasks todo and Y task are done");
        System.out.println("Pick an option:");
        System.out.println("1. Show Task List (by date or project) ");
        System.out.println("2. Add New Task");
        System.out.println("3. Edit Task (update, mark as done, remove)");
        System.out.println("4. Save and Quit");
        System.out.println("|  *Type a number to make a selection*  |");
        System.out.print("Selection: ");
    }

    //System.out.println("3. Edit Task (update, mark as done, remove)"); Working on edit and update
    public void MenuEditTask() {
        System.out.println("Start editing a task in ToDoLY");
        todo.showTasks();
        System.out.println("Pick an option:");
        System.out.println("(1) Edit task"); //what task do you want to edit? index
        System.out.println("(2) Mark as done"); //what task do you want to mark as done? index
        System.out.println("(3) Delete task");//what task do you want to delete? index
        //System.out.println("(4) Return to main menu");
        System.out.print("Selection: ");;
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
                    MenuEditTask();
                    editTaskOptions();
                }
                case 4 -> {
                    System.out.println("Thank you for using ToDoLY today! Goodbye!");
                    todo.save();
                    System.exit(0);
                }
                default -> System.out.println("please write a correct number between 1 and 4");
            }

        }
    }



    public void editTaskOptions()
    {
        String editChoices = scanner.nextLine();
        todo.showTasks();

        System.out.println("Please write the number/index of the task you want to edit");
        int index = Integer.parseInt(scanner.nextLine()); //todo change this to make a call to validate int method

        switch(editChoices) {

            case "1" -> {
               //todo.editTask(index);
                System.out.println("Task edited!");
            }

            case "2" -> {
                todo.markAsDone(index);
                System.out.println("Yup! This task is done!");

            }

            case "3" -> {
                todo.removeTask(index);
                //System.out.println("Task deleted successfully!");

            }


            default -> throw new IllegalStateException("Unexpected value: " + editChoices);
        }
    }





    //todo have validate integer here:




}






























