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
            case 1:
                System.out.println("Show Task List");
                todo.showTasks();
                break;

            case 2:
                System.out.println("Add new Task");
                todo.addTask();
                break;

            case 3:
                System.out.println("Remove a task");
                todo.removeTask();
                break;
        }


    }
}



























