package app;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class CalculatorTest {
	@Test(groups = { "constructor" })
	public void testConstructorWithNameOK() {
		// Arrange
		String name = "Tejo"; // length = 4

		// Act
		Calculator calculator = new Calculator(name);

		// Assert
		assertNotNull(calculator);
		assertEquals(calculator.getName(), name);
	}

	@Test(
		groups = { "constructor" },
		expectedExceptions = { IllegalArgumentException.class })
	public void testConstructorWithNullName() {
		// Arrange
		IllegalArgumentException exception;
		Calculator calculator = null;
		String name = null;

		// Act
		exception = expectThrows(IllegalArgumentException.class, () -> { new Calculator(name); });

		// Assert
		assertTrue(exception.getMessage().contains("no name"));
	}

	@Test(
		groups = { "constructor" },
		expectedExceptions = { IllegalArgumentException.class })
	public void testConstructorWithNameLengthSmallerThan2() {
		// Arrange
		IllegalArgumentException exception;
		Calculator calculator = null;
		String name = "P"; // length = 1

		// Act
		exception = expectThrows(IllegalArgumentException.class, () -> { new Calculator(name); });

		// Assert
		assertTrue(exception.getMessage().contains("no name"));
	}

	@Test(groups = { "constructor" })
	public void testConstructorWithNameWithLength2() {
		// Arrange
		String name = "Oi"; // length = 2

		// Act
		Calculator calculator = new Calculator(name);

		// Assert
		assertNotNull(calculator);
		assertEquals(calculator.getName(), name);
	}

	@Test(
		groups = { "constructor" },
		expectedExceptions = { IllegalArgumentException.class })
	public void testConstructorWithNameLengthBiggerThan5 () {
		// Arrange
		IllegalArgumentException exception;
		Calculator calculator = null;
		String name = "Lisboa"; // length = 6

		// Act
		exception = expectThrows(IllegalArgumentException.class, () -> { new Calculator(name); });

		// Assert
		assertTrue(exception.getMessage().contains("no name"));
	}

	@Test(groups = { "constructor" })
	public void testConstructorWithNameWithLength5() {
		// Arrange
		String name = "Troia"; // length = 5

		// Act
		Calculator calculator = new Calculator(name);

		// Assert
		assertNotNull(calculator);
		assertEquals(calculator.getName(), name);
	}
}