package TodoListTest;

/**This class is used to be able to set the function to filter
 * by expiration date in TodoList showTasksByDate.*/

import java.util.Comparator;

public class CompareTasks implements Comparator<Task> {

    public int compare(Task task1, Task task2) {
        return task1.getDueDate().compareTo(task2.getDueDate());
    }
}
