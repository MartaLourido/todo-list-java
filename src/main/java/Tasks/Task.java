package Tasks;

import java.io.Serializable;

public class Task implements Serializable
{

    //defining variables
    private String title;
    private String dueDate; //todo make it as Date or LocalDate
    private String user;
    private String project;
    private boolean isDone;

    //todo ask Nour about how to use Date


    // Constructor (change it to my strings types, learning how to do it, pending to review with a TA)

    public Task(String title, String dueDate, String user, String project, boolean isDone) {
        this.title = title;
        this.dueDate = dueDate;
        this.user = user;
        this.project = project;
        this.isDone = isDone;
    }

    public Task() { } //todo remove this

    //function for get the date
    public void setProject(String project) {
        this.project = project;
    }

    //create get and set methods for the user

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //create get and set methods for the project

    public String getProject() {
        return project;
    }

    //create the get and set for the title

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", user='" + user + '\'' +
                ", project='" + project + '\'' +
                ", isDone=" + isDone +
                '}';
    }


    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }


}
