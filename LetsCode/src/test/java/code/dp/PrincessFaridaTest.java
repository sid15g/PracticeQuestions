package code.dp;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Unit Test for {@link code.dp.PrincessFarida}
 */
public class PrincessFaridaTest {

    private PrincessFarida classToTest = null;

    @BeforeMethod
    private void beforeMethod() {
        classToTest = new PrincessFarida();
    }

    @Test(groups = "unit")
    public void testNullCase() {
        int result = classToTest.solve(1, 0, new int[]{});
        assertEquals(result, 0);
    }

    @Test(groups = "unit")
    public void testSingleElement() {
        int result = classToTest.solve(1, 1, new int[]{5});
        assertEquals(result, 5);
    }

    @Test(groups = "unit")
    public void testCase1() {
        int result = classToTest.solve(1, 5, new int[]{1, 2, 3, 4, 5});
        assertEquals(result, 9);
    }

    @Test(groups = "unit")
    public void testCase2() {
        int result = classToTest.solve(2, 6, new int[]{1, 1, 1, 4, 1, 5});
        assertEquals(result, 10);
    }

    @Test(groups = "unit")
    public void testCase3() {
        int result = classToTest.solve(3, 6, new int[]{1, 0, 0, 4, 1, 5});
        assertEquals(result, 10);
    }

}