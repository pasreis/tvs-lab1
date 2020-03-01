import static org.testng.Assert.*;
import org.testng.anotations.*;

package app;

public class CaculatorTest {
	@Test(groups = {"constructor"})
	public void testConstructorWithNameOK() {
		// Arrange
		String name = "calc"; // 4 letters

		// Act
		Calculator calculator = new Calculator(name);

		// Assert
		assertNotNull(calculator);
		assertEquals(calculator.getNa
	}
}