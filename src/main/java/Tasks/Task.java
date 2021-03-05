package Tasks;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable
{

    //defining variables
    private static final long serialVersionUID = 6076677258728022863L;
    private String title;
    private Date date; //todo make it as Date or LocalDate
    private String user;
    private String project;
    private boolean isDone;


    //todo ask Nour about how to use Date


    public Task(String title, Date date, String user, String project, boolean isDone)
    {
        this.title = title;
        this.date = date;
        this.user = user;
        this.project = project;
        this.isDone = isDone;
    }


    public Task() { } //todo remove this

    //public Task(String t1, String s, String u1, String p2, boolean b) {
   // }


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

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", date=" + date +
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


    public void setDate(Date date)
    {
        this.date = date;
    }
}
