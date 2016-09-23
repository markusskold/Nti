package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.*;
import main.*;
public class StringCalculatorTest {

	private StringCalculator stringCalculator;
	
	@Before
	public void setUp() throws Exception {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void testAdd() {
		assertNotNull(stringCalculator.add(null));
		assertEquals(stringCalculator.add(""), 0);
		assertEquals(stringCalculator.add("1"), 1);
		assertEquals(stringCalculator.add("1,2"), 3);
		assertEquals(stringCalculator.add("1,2,3\n4,5\n6,7"), 28);
		assertNotEquals(stringCalculator.add("1,2,3,4,5,6,7"), 5);
		
		assertEquals(3, stringCalculator.add("//;\n1;2"));
		assertEquals(3, stringCalculator.add("//***\n1***5***6"), 12);
		
		assertEquals(stringCalculator.add("2,1001"), 2);
	}
	
	@Test
	public void testGetDelimiter() {
		assertNull(stringCalculator.getDelimiter(""));
		assertNull(stringCalculator.getDelimiter("/"));
		assertNull(stringCalculator.getDelimiter("//"));
		assertNull(stringCalculator.getDelimiter("//"));
		assertNull(stringCalculator.getDelimiter("//"));
		assertNull(stringCalculator.getDelimiter("//\\"));
		assertTrue(stringCalculator.getDelimiter("//\n").isEmpty());
		assertEquals(stringCalculator.getDelimiter("//***\n1"), "***");
		assertEquals("***", stringCalculator.getDelimiter("//***\n1***5***6"));
	}

}
