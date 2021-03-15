package TodoList;

//method for show task by date or project

import java.util.Comparator;

public class CompareTasks implements Comparator<Task> {

    //compare by duedate
    public int compare(Task t1, Task t2) {
        return t1.getDueDate().compareTo(t2.getDueDate());
    }
}
