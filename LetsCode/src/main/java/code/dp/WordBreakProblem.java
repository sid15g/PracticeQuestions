package code.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * https://www.geeksforgeeks.org/word-break-problem-dp-32/
 * <p>
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
 * This is a famous Google interview question, also being asked by many other companies now a days.
 * <p>
 * Consider the following dictionary
 * { i, like, sam, sung, samsung, mobile, ice,
 * cream, icecream, man, go, mango}
 * <p>
 * Input:  ilike
 * Output: Yes
 * The string can be segmented as "i like".
 * <p>
 * Input:  ilikesamsung
 * Output: Yes
 * The string can be segmented as "i like samsung"
 * or "i like sam sung".
 */
public class WordBreakProblem {

    /**
     * Dictionary, empty by default
     */
    private Set<String> dictionary = Collections.emptySet();

    /**
     * DP buffer for recursive approach
     */
    private Map<String, Boolean> buffer = new HashMap<>();

    /**
     * Solve word break problem using recursive approach
     *
     * @param word given word
     * @return result as boolean
     */
    public boolean wordBreak(final String word) {

        if (word == null || dictionary == null) {
            return false;
        } else if (word.length() == 0 || word.length() == 1) {
            return dictionary.contains(word);
        }

        if (dictionary.isEmpty()) {
            return false;
        }

        /*boolean res = false;
        for (int i=0; i < word.length() && !res; i++) {
            this.buffer.clear();
            res = res || wordBreakWithRecursiveApproach(word, i);
        }
        this.buffer.forEach((k, v) -> System.out.printf("K: %s, V: %b\n", k, v));
        return res;*/
        return wordBreakWithDynamicProgramming(word);
    }

    /**
     * Solve word break problem using recursive approach
     * Optimized using memorization
     *
     * @param word  given word
     * @param index index to split the word
     * @return result as boolean
     */
    @Deprecated
    private boolean wordBreakWithRecursiveApproach(final String word, final int index) {

        if (word == null || index < 0) {
            return false;
        }
        System.out.printf("T: %s : %d\n", word, index);

        if (index == (word.length() - 1)) {
            final boolean res = dictionary.contains(word);
            this.buffer.put(word, res);
            return res;
        }

        final String firstHalf = word.substring(0, index + 1);
        final String secondHalf = word.substring(index + 1);

        boolean resultA = false;

        if (dictionary.contains(firstHalf)) {
            if (!this.buffer.containsKey(secondHalf)) {
                resultA = wordBreakWithRecursiveApproach(secondHalf, 0);
                this.buffer.put(secondHalf, resultA);
            } else {
                resultA = this.buffer.get(secondHalf);
            }
        }

        if (!resultA) {
            final String subStr = word.substring(index + 1);

            if (!this.buffer.containsKey(subStr)) {
                resultA = wordBreakWithRecursiveApproach(word, index + 1);
                this.buffer.put(subStr, resultA);
            } else {
                resultA = this.buffer.get(subStr);
            }
        }
        return resultA;
    }

    /**
     * Solve word break problem using my dynamic programming
     * Use 2D array to store if arr[i][j] implying str[i->j] is there in dictionary
     *
     * @param word  given word
     * @return result as boolean
     */
    private boolean wordBreakWithDynamicProgramming(final String word) {

        final int size = word.length();
        final boolean[] buffer = new boolean[size + 1];

        // initialize all array blocks to 0
        Arrays.fill(buffer, false);
        buffer[size] = true;

        for (int i = size - 1; i >= 0; i--) {
            for (String elem : dictionary) {

                final int totalSizeOfStringFromIWithThisElement = i + elem.length();
                final boolean lengthCheck = totalSizeOfStringFromIWithThisElement <= size;

                if(lengthCheck && elem.equals(word.substring(i, totalSizeOfStringFromIWithThisElement))) {
                    buffer[i] = buffer[i + elem.length()];
                }
                if (buffer[i]) {
                    break;
                }
            }
        }
        return buffer[0];
    }
}
