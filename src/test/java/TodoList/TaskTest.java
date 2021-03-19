package TodoListTest;

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
    @DisplayName("set project name should work")
    void setProject() {
        //setup
        String newProject = "Setting a new project";
        //run the test
        taskUnderTest.setProject(newProject);
        // Verify the results
        assertEquals(newProject, taskUnderTest.getProject());
    }

    @Test
    @DisplayName("get project name should work")
    void getProject() {
        //setup
        String newProject = "Setting a new project";
        //run the test
        taskUnderTest.setProject(newProject);
        // Verify the results
        assertEquals(newProject, taskUnderTest.getProject());
    }

    @Test
    @DisplayName("set title should work")
    void setTitle() {
        //setup
        String newTitle = "Setting a new title";
        //run the test
        taskUnderTest.setTitle(newTitle);
        // Verify the results
        assertEquals(newTitle, taskUnderTest.getTitle());
    }

    @Test
    @DisplayName("set due date should work")
    void testSetDueDate() {
        //setup
        taskUnderTest.setDate(LocalDate.parse("2021-01-10"));
        //run the test
        LocalDate expected = LocalDate.parse("2021-01-10");
        // Verify the results
        assertEquals(expected, taskUnderTest.getDueDate());
    }

    @Test
    @DisplayName("get due date should work")
    void testGetDueDate() {
        //setup
        taskUnderTest.setDate(LocalDate.parse("2021-01-10"));
        //run the test
        LocalDate expected = LocalDate.parse("2021-01-10");
        // Verify the results
        assertEquals(expected, taskUnderTest.getDueDate());
    }

    @Test
    @DisplayName("get if the task is done should work")
    void testGetIsDone() {
        //setup
        taskUnderTest.setIsDone(true);
        // Verify the results
        assertEquals(true, taskUnderTest.getIsDone());
    }

    @Test
    @DisplayName("set the user should work")
    void testSetUser() {
        //setup
        String user = "Setting a new project";
        //run the test
        taskUnderTest.setUser(user);
        // Verify the results
        assertEquals(user, taskUnderTest.getUser());
    }

}
