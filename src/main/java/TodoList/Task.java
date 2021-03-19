package TodoList;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable
{

    //defining variables
    private static final long serialVersionUID = 6076677258728022863L;

    private String title;
    private LocalDate dueDate;
    private String user;
    private String project;
    private boolean isDone;


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


    public void setProject(String project) {
        this.project = project;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date)
    {
        this.dueDate = date;
    }


    //getters

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getUser() {
        return user;
    }

    public String getProject() {
        return project;
    }

    public void setIsDone(boolean done) {
        this.isDone = done;
    }


    //method to check if the task is done
    public boolean getIsDone(){
        return isDone;
    }


    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", user='" + user + '\'' +
                ", project='" + project + '\'' +
                ", isDone=" + (isDone?"Done":"Not done")+
                '}';
    }


}
