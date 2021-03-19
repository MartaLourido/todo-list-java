package TodoList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareTasksTest {

    private CompareTasks compareTasksUnderTest;

    @BeforeEach
    void setUp() {
        compareTasksUnderTest = new CompareTasks();
    }

    @Test
    @DisplayName("Compare should work, method to compare tasks which is used for sort by date")
    void testCompare() {
        // Setup
        final Task task1 = new Task("title", LocalDate.of(2020, 1, 1), "user", "project", false);
        final Task task2 = new Task("title", LocalDate.of(2020, 1, 1), "user", "project", false);

        // Run the test
        final int result = compareTasksUnderTest.compare(task1, task2);

        // Verify the results
        assertEquals(0, result);
    }
}
