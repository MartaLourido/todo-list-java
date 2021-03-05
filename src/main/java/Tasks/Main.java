package Tasks;

import TodoList.TodoList;

import java.util.Scanner;

public class Main {


    public static void seeMenu(){
        System.out.println("Welcome to ToDoLy");
        System.out.println("You have X tasks todo and Y task are done");
        System.out.println("Pick and option:");
        System.out.println("1. Show Task List (by date or project) ");
        System.out.println("2. Add New Task");
        System.out.println("3. Edit Task (update, mark as done, remove)");
        System.out.println("4. Save and Quit");
        System.out.println("|  *Type a number to make a selection*  |");
        System.out.print("Selection: ");
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TodoList todo = new TodoList();


        //see the menu
        seeMenu();

        //switch with some cases which call the add, remove, and another methods from the TodoList/TaskList
        String input = scanner.nextLine();

        int choice = Integer.parseInt(input);

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
                System.out.println("Remove a task"); //This case will have to be able to edit, a task but for now is working with remove
                todo.removeTask();
            }
            case 4 -> {
                System.out.println("Thank you for using ToDoLY today! Goodbye!");
                todo.writeAsObject();
                System.exit(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }


    }
}




























