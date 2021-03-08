package Tasks;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable
{

    //defining variables
    private static final long serialVersionUID = 6076677258728022863L;
    private String title;
    private Date date;
    private String user;
    private String project;
    private boolean isDone;



    public Task(String title, Date date, String user, String project, boolean isDone)
    {
        this.title = title;
        this.date = date;
        this.user = user;
        this.project = project;
        this.isDone = isDone;
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

    public void setDate(Date date)
    {
        this.date = date;
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

}
