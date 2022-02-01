package code.dp;

import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Sets;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Unit Test for {@link WordBreakProblem}
 */
public class WordBreakProblemTest {

    private WordBreakProblem classToTest = null;

    @BeforeMethod
    private void beforeMethod() {
        classToTest = new WordBreakProblem();
    }

    private void setDictionary(final String[] dictionary) {
        ReflectionTestUtils.setField(classToTest, "dictionary", Sets.newHashSet(Arrays.asList(dictionary)));
    }

    @Test(groups = "unit")
    public void testNullCase() {
        boolean result = classToTest.wordBreak(null);
        assertFalse(result);
    }

    @Test(groups = "unit")
    public void testEmptyCase() {
        setDictionary(new String[]{"", "a", "ab"});

        boolean result = classToTest.wordBreak("");
        assertTrue(result);
    }

    @Test(groups = "unit", dataProvider = "dataProviderToTestWordBreak", timeOut = 1000)
    public void testWordBreak(final String word, final String[] dictionary, final boolean expectedResult) {
        setDictionary(dictionary);

        boolean result = classToTest.wordBreak(word);
        assertEquals(result, expectedResult);
    }

    @DataProvider
    private Object[][] dataProviderToTestWordBreak() {
        return new Object[][] {
                // test single characters
                {"a", new String[]{"a", "ab"}, Boolean.TRUE},
                {"a", new String[]{"b", "ab"}, Boolean.FALSE},
                {"a", new String[]{"ab"}, Boolean.FALSE},

                //test given cases
                {"ilike", new String[]{"i", "like", "sam", "sung", "samsung", "mobile"}, Boolean.TRUE},
                {"ilikesamsung", new String[]{"i", "like", "sam", "sung", "samsung", "mobile"}, Boolean.TRUE},
                {"applepenapple", new String[]{"apple","pen"}, Boolean.TRUE},
                {"catsandog", new String[]{"cats","dog","sand","and","cat"}, Boolean.FALSE},

                //manual scenarios
                {"ilikesamsung", new String[]{"i", "mango", "ice", "mobile", "like"}, Boolean.FALSE},
                {"catsandog", new String[]{"cats","dog","sand","and","cat", "og"}, Boolean.TRUE},
                {"ilike", new String[]{"i", "l", "ke"}, Boolean.TRUE},
                {"ilike", new String[]{"il", "i", "ke"}, Boolean.TRUE},
                {"ilike", new String[]{"il", "ke", "l"}, Boolean.FALSE},

                //extreme case
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                        new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}, Boolean.FALSE},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                        new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaab","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}, Boolean.TRUE},
        };
    }

}