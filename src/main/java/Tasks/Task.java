package Tasks;

import java.util.Date;

public class Task {

    //defining variables

    private String name;
    private Date dueDate;
    private String user;
    private String project;
    private boolean isDone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    //create get and set methods for the due date

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    //create get and set methods for the project

    public String getProject() {
        return project;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
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

    public Task() {
        super();
    }

}
