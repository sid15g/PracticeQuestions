package code.general;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Unit Test for {@link code.general.MinimumPlatform}
 */
public class MinimumPlatformTest {

    private MinimumPlatform minimumPlatform = null;

    @BeforeMethod
    private void beforeMethod() {
        minimumPlatform = new MinimumPlatform();
    }

    @Test(groups = "unit")
    public void testNull() {
        final int result = minimumPlatform.findMinimumPlatformsRequired(new int[]{}, new int[]{}, 0);
        assertEquals(result, 0);
    }

    @Test(groups = "unit")
    public void testSingle() {
        final int result = minimumPlatform.findMinimumPlatformsRequired(new int[]{1100}, new int[]{1200}, 1);
        assertEquals(result, 1);
    }

    @Test(groups = "unit")
    public void testIntersection() {
        final int result = minimumPlatform.findMinimumPlatformsRequired(new int[]{1100, 1150}, new int[]{1200, 1250}, 2);
        assertEquals(result, 2);
    }

    @Test(groups = "unit")
    public void testAdjacent() {
        final int result = minimumPlatform.findMinimumPlatformsRequired(new int[]{1100, 1200}, new int[]{1200, 1250}, 2);
        assertEquals(result, 1);
    }

    @Test(groups = "unit")
    public void testGivenCase1() {
        final int result = minimumPlatform.findMinimumPlatformsRequired(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6);
        assertEquals(result, 3);
    }

    @Test(groups = "unit")
    public void testGivenCase2() {
        final int result = minimumPlatform.findMinimumPlatformsRequired(new int[]{900, 940}, new int[]{910, 1200}, 2);
        assertEquals(result, 1);
    }

    @Test(groups = "unit")
    public void testManualComplicatedOne() {
        //Will fail without sorting
        final int result = minimumPlatform.findMinimumPlatformsRequired(new int[]{900, 940, 950, 1100, 1500, 1800, 900, 1700, 1120}, new int[]{910, 1200, 1120, 1130, 1900, 2000, 940, 1800, 1800}, 9);
        assertEquals(result, 3);
    }

    @Test(groups = "unit")
    public void testManualComplicatedOneWithSequenceChanged() {
        //Same input as testManualComplicatedOne, just different sequence. Will pass without sorting.
        final int result = minimumPlatform.findMinimumPlatformsRequired(new int[]{900, 940, 950, 1100, 1500, 1800, 900, 1120, 1700}, new int[]{910, 1200, 1120, 1130, 1900, 2000, 940, 1800, 1800}, 9);
        assertEquals(result, 3);
    }
}