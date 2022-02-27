package code.general;

import com.google.common.collect.ImmutableSet;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

/**
 * Unit Tests for {@link code.general.FindWorseGitCommit}
 */
public class FindWorseGitCommitTest {

    private FindWorseGitCommit classToTest = null;

    @BeforeMethod
    private void beforeMethod() {
        classToTest = new FindWorseGitCommit();
    }

    private void setPerformanceMatrix(final Integer[] commits, final Integer[] performances) {
        final Map<Integer, Integer> performanceMatrix = new HashMap<>(commits.length);

        for (int i=0; i < commits.length; i++) {
            performanceMatrix.put(commits[i], performances[i]);
        }

        ReflectionTestUtils.setField(classToTest, "performanceMatrix", performanceMatrix);
    }

    @Test(groups = "unit")
    public void testNullCase() {
        final Set<Integer> result = classToTest.findWorstCommits(null);
        assertNull(result);
    }

    @Test(groups = "unit")
    public void testNoCommits() {
        final Set<Integer> result = classToTest.findWorstCommits(new Integer[]{});
        assertNull(result);
    }

    @Test(groups = "unit")
    public void testSingleCommits() {
        final Set<Integer> result = classToTest.findWorstCommits(new Integer[]{123});
        assertNull(result);
    }

    @Test(groups = "unit")
    public void testTwoCommits() {
        setPerformanceMatrix(new Integer[]{10, 11}, new Integer[]{50, 40});

        final Set<Integer> result = classToTest.findWorstCommits(new Integer[]{10, 11});
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result.toArray()[0], 11);
    }

    @Test(groups = "unit")
    public void testTwoCommitsWithSamePerformance() {
        setPerformanceMatrix(new Integer[]{10, 11}, new Integer[]{50, 50});

        final Set<Integer> result = classToTest.findWorstCommits(new Integer[]{10, 11});
        assertNull(result);
    }

    @Test(groups = "unit")
    public void testCaseWithNoPerformanceChangeOdd() {
        final Integer[] commits = new Integer[]{10, 11, 12, 13, 14, 15, 16};
        setPerformanceMatrix(commits, new Integer[]{50, 50, 50, 50, 50, 50, 50});

        final Set<Integer> result = classToTest.findWorstCommits(commits);
        assertNotNull(result);
        assertEquals(result.size(), 0);
    }

    @Test(groups = "unit")
    public void testCaseWithNoPerformanceChangeEven() {
        final Integer[] commits = new Integer[]{10, 11, 12, 13, 14, 15};
        setPerformanceMatrix(commits, new Integer[]{50, 50, 50, 50, 50, 50});

        final Set<Integer> result = classToTest.findWorstCommits(commits);
        assertNotNull(result);
        assertEquals(result.size(), 0);
    }

    @Test(groups = "unit")
    public void testGivenCase1() {
        final Integer[] commits = new Integer[]{10, 11, 12, 13};
        setPerformanceMatrix(commits, new Integer[]{50, 50, 50, 40});

        final Set<Integer> result = classToTest.findWorstCommits(commits);
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result, ImmutableSet.of(13));
    }

    @Test(groups = "unit")
    public void testGivenCase2Odd() {
        final Integer[] commits = new Integer[]{10, 11, 12, 13, 14};
        setPerformanceMatrix(commits, new Integer[]{50, 50, 50, 40, 40});

        final Set<Integer> result = classToTest.findWorstCommits(commits);
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result, ImmutableSet.of(13));
    }

    @Test(groups = "unit")
    public void testGivenCase2Even() {
        final Integer[] commits = new Integer[]{10, 11, 12, 13, 14, 15};
        setPerformanceMatrix(commits, new Integer[]{50, 50, 50, 40, 40, 40});

        final Set<Integer> result = classToTest.findWorstCommits(commits);
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result, ImmutableSet.of(13));
    }

    @Test(groups = "unit")
    public void testGivenCase3() {
        final Integer[] commits = new Integer[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        setPerformanceMatrix(commits, new Integer[]{70, 70, 70, 60, 60, 50, 40, 30, 30, 20, 10});

        final Set<Integer> result = classToTest.findWorstCommits(commits);
        assertNotNull(result);
        assertEquals(result.size(), 6);
        assertEquals(result, ImmutableSet.of(13, 15, 16, 17, 19, 20));
    }
}