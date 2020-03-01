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

	@Test(groups = { "constructor" })
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

	@Test(groups = { "constructor" })
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

	@Test(groups = { "constructor" })
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

	@DataProvider
	private Object[][] getSumValues() {
		return new Object[][] {
			{ 1, 1, 2 },
			{ 0, 1, 1 },
			{ 0, 0, 0 },
			{ -1, -1, -2 },
			{ -1,  1,  0 },
			{  1, -1,  0 },
			{ -1,  0, -1 },
			{  0, -1, -1 },
			{ Integer.MAX_VALUE, Integer.MAX_VALUE, -2 },
			{ Integer.MIN_VALUE, Integer.MIN_VALUE,  0 },
			{ Integer.MAX_VALUE, 1, Integer.MIN_VALUE },
			{ 1, Integer.MAX_VALUE, Integer.MIN_VALUE },
			{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE - 1 },
			{ -1, Integer.MAX_VALUE, Integer.MAX_VALUE - 1 },
			{ Integer.MIN_VALUE, 1, Integer.MIN_VALUE + 1 },
			{ 1, Integer.MIN_VALUE, Integer.MIN_VALUE + 1 },
			{ Integer.MIN_VALUE, -1, Integer.MAX_VALUE },
			{ -1, Integer.MIN_VALUE, Integer.MAX_VALUE },
			{ null, null, 0 },
			{ null, 1, 1 },
			{ 1, null, 1 },
			{ null, -1, -1 },
			{ -1, null, -1 }
		};
	}

	@Test(
		groups = { "sum" },
		dataProvider = "getSumValues")
	public void testSum(Integer a, Integer b, Integer expectedResult) {
		// Assert
		Calculator calculator = new Calculator("Tejo");

		// Act
		Integer result = calculator.sum(a, b);

		// Assert
		assertEquals(result, expectedResult);
	}
}