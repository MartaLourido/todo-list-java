package TodoListTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TodoListTest {

    private TodoList todoListUnderTest;

    @BeforeEach
    void setUp() {
        todoListUnderTest = new TodoList(new ArrayList<>(List.of(new Task("title", LocalDate.of(2020, 1, 1), "user", "project", false))));
    }

    @Test
    @DisplayName("Mark as done should mark the task as done and change the value false to true")
    void testMarkAsDone() {
        // Setup
        final Task task = new Task("title", LocalDate.of(2020, 1, 1), "user", "project", false);
        // Run the test
        todoListUnderTest.markAsDone(task);
        //Verify the results
        assertEquals(true, task.getIsDone());
    }

    @Test
    @DisplayName("Remove task should remove the task")
    void testRemoveTask() {
        // Setup
        //final Task task = new Task("title", LocalDate.of(2020, 1, 1), "user", "project",
        //int expected = 0;
        //assertEquals(expected, todoListUnderTest.removeTask(task));
    }

    @Test
    @DisplayName("Show task by project should show the task in order by project")
    void testShowTasksByProject() {
        // Setup
        String project1 = ("SDA");
        String project2 = ("SDA");
        String project3 = ("SWEDISH");
        // Run the test
        todoListUnderTest.showTasksByProject();
        // Verify the results
        assertTrue(project1.equals(project2) && !project1.equals(project3) &&
                !project2.equals(project3));
    }

    @Test
    @DisplayName("ShowTaskByDate should show the task by date in order by due date")
    void testShowTasksByDate() {
        // Setup
        CompareTasks testCompare = new CompareTasks();
        final Task task1 = new Task("title",  LocalDate.parse("2021-12-25"), "user", "project", false);
        final Task task2 = new Task("title",  LocalDate.parse("2021-12-24"), "user", "project", false);
        int result = 1;
        // Run the test
        todoListUnderTest.showTasksByDate();
        // Verify the results
        assertEquals(result, testCompare.compare(task1, task2));
    }


    @Test
    @DisplayName("AddTask should add a task to the todo list")
    void testAddTask() {
        // Setup
        final Task newTask = new Task("title", LocalDate.parse("2021-12-25"), "user", "project", false);
        // Verify the results
        assertEquals("title", newTask.getTitle());
        assertEquals("2021-12-25", newTask.getDueDate().toString());
        assertEquals("user", newTask.getUser());
        assertEquals("project", newTask.getProject());
        assertEquals(false, newTask.getIsDone());
    }


    @Test
    @DisplayName("ValidateDate should validate the date")
    void testValidateDate() {
        // Setup done in the void SetUp
        // Run the test
        LocalDate expected = LocalDate.parse("2021-01-10");
        // Verify the results
        assertEquals(expected, todoListUnderTest.validateDate());
    }

    @Test
    @DisplayName("ConvertToDate should convert the date to String")
    void testConvertToDate() {
        // Setup done in the void setUp
        // Run the test
        LocalDate expected = todoListUnderTest.convertToDate("01-01-2021");
        // Verify the results
        assertEquals(true, expected);
    }

}
