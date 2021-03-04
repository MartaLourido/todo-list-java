package TodoList;

import Tasks.Task;
import java.util.ArrayList;
import java.util.Scanner;


public class TodoList {

    private ArrayList<Task> tasks;

    public TodoList() {
   //here would be the constructor but not for now, working on other things;
        tasks = new ArrayList<Task>();
    }

    //method for show the tasks
    public void showTasks() {
        System.out.println("To-Do List Tasks");
        int number = 0;
        for (Task task : tasks) {
            System.out.println(++number + " " + task);
        }
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
        System.out.println("----------------------");
        showTasks();


    }

    //method for add a task

    public void addTask() {
        Task task = new Task();
        System.out.println("Please, enter your name");
        System.out.println("Please, enter the name of the project you want to add the task to");
        System.out.println("Please, enter a title for the task");
        System.out.println("Please enter due date");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String project = scanner.nextLine();
        task.setName(name);
        task.setProject(project);

        tasks.add(task);
        showTasks();
    }
}


