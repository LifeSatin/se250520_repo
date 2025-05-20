package student;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {
	
	StudentManager studentManager;

	@BeforeEach
	void setUp() throws Exception {
		studentManager = new StudentManager();
	}

	@Test
	void testAddStudent() {
		studentManager.addStudent("testAddStudent");
		assertTrue(studentManager.hasStudent("testAddStudent"));
	}

	@Test
	void testRemoveStudent() {
		studentManager.addStudent("testRemoveStudent");
		studentManager.removeStudent("testRemoveStudent");
		assertFalse(studentManager.hasStudent("testRemoveStudent"));
	}

	@Test
	void testDuplicateException() {
		studentManager.addStudent("testDuplicateException");
		assertThrows(IllegalArgumentException.class, () -> {
			studentManager.addStudent("testDuplicateException");
		});

	}
	
	@Test
	void testNullRemoveException() {
		assertThrows(IllegalArgumentException.class, () -> {
			studentManager.removeStudent("testNullRemoveException");
		});
	}
}
