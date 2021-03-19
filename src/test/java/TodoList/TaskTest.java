package TodoList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    private Task taskUnderTest;

    @BeforeEach
    void setUp() {
        taskUnderTest = new Task("title", LocalDate.of(2020, 1, 1), "user", "project", false);
    }

    @Test
    @DisplayName("Set project should help to set a new project")
    void setProject() {
        //setup
        String newProject = "Setting a new project";
        //run the test
        taskUnderTest.setProject(newProject);
        // Verify the results
        assertEquals(newProject, taskUnderTest.getProject());
    }

    @Test
    @DisplayName("Get project should get the new project")
    void getProject() {
        //setup
        String newProject = "Setting a new project";
        //run the test
        taskUnderTest.setProject(newProject);
        // Verify the results
        assertEquals(newProject, taskUnderTest.getProject());
    }

    @Test
    @DisplayName("Set title should help to set a new project")
    void setTitle() {
        //setup
        String newTitle = "Setting a new title";
        //run the test
        taskUnderTest.setTitle(newTitle);
        // Verify the results
        assertEquals(newTitle, taskUnderTest.getTitle());
    }

    @Test
    @DisplayName("Set due date should help to set a due date to our task")
    void testSetDueDate() {
        //setup
        taskUnderTest.setDate(LocalDate.parse("2021-01-10"));
        //run the test
        LocalDate expected = LocalDate.parse("2021-01-10");
        // Verify the results
        assertEquals(expected, taskUnderTest.getDueDate());
    }

    @Test
    @DisplayName("Get due date should help to get the due date of the task")
    void testGetDueDate() {
        //setup
        taskUnderTest.setDate(LocalDate.parse("2021-01-10"));
        //run the test
        LocalDate expected = LocalDate.parse("2021-01-10");
        // Verify the results
        assertEquals(expected, taskUnderTest.getDueDate());
    }

    @Test
    @DisplayName("GetIsDone should help the method markAsDone to mark a task as done")
    void testGetIsDone() {
        //setup
        taskUnderTest.setIsDone(true);
        // Verify the results
        assertEquals(true, taskUnderTest.getIsDone());
    }

    @Test
    @DisplayName("Set user should set the user who write the task")
    void testSetUser() {
        //setup
        String user = "Setting user";
        //run the test
        taskUnderTest.setUser(user);
        // Verify the results
        assertEquals(user, taskUnderTest.getUser());
    }

}
