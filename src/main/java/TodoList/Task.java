package TodoList;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {

    //defining variables
    private static final long serialVersionUID = 6076677258728022863L;
    private String title;
    private LocalDate dueDate;
    private String user;
    private String project;
    private boolean isDone;

    //Constructor
    public Task(String title, LocalDate dueDate, String user, String project, boolean isDone) {
        this.title = title;
        this.dueDate = dueDate;
        this.user = user;
        this.project = project;
        this.isDone = false;
    }

    public Task() {

    }

    //setters
    public void setDate(LocalDate date) {
        this.dueDate = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    //getters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    //method to check if the task is done
    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean done) {
        this.isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", user='" + user + '\'' +
                ", project='" + project + '\'' +
                ", isDone=" + (isDone ? "Done" : "Not done") +
                '}';
    }

}
