package code.general;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a list of commits, find all the commits that have degraded the performance
 * The performance cannot increase and can only degrade or stay same
 * <p>
 * The performance matrix is not given for each commit,
 * Instead the following method is provided:
 * <p>
 * boolean isWorseCommit(int commit1, int commit2);
 * <p>
 * The above method returns true if commit2 followed by commit1 has degraded the performance.
 * Otherwise false.
 * Assume that the internal implementation of "isWorseCommit" is unknown
 * <p>
 * The commit can be considered as integers and will always be increasing with time.
 */
public class FindWorseGitCommit {

    private Map<Integer, Integer> performanceMatrix = null;
    private Set<Integer> worstCommits = null;
    private Integer[] commitList = null;

    private boolean isWorseCommit(int commit1, int commit2) {
        final int performance1 = performanceMatrix.getOrDefault(commit1, 0);
        final int performance2 = performanceMatrix.getOrDefault(commit2, 0);

        return (performance2 - performance1) < 0;
    }

    public Set<Integer> findWorstCommits(final Integer[] commitList) {

        if (commitList == null || commitList.length <= 1) {
            return null;
        }
        if (commitList.length == 2) {
            return isWorseCommit(commitList[0], commitList[1]) ? Collections.singleton(commitList[1]) : null;
        }

        this.commitList = commitList;
        this.worstCommits = new HashSet<>();
        findWorstCommitsUsingBinarySearch(0, commitList.length - 1);
        return worstCommits;
    }

    /**
     * Use Binary Search to determine the worst commits
     *
     * Check if the first and the last commit of any sub-array has any degradation in performance,
     * If yes then divide and conquer.
     * Otherwise skip checking the sub-array
     *
     * Worst case: O(n)
     * Best case: O(log n)
     *
     * @param start start index
     * @param end end index
     */
    private void findWorstCommitsUsingBinarySearch(final int start, final int end) {

        final int length = end - start + 1;
        //System.out.printf("Recursing : %d -> %d \n", start, end);

        boolean res = isWorseCommit(commitList[start], commitList[end]);

        if (res) {
            if (length > 2) {
                int middle = (start + end) / 2;
                findWorstCommitsUsingBinarySearch(start, middle);
                findWorstCommitsUsingBinarySearch(middle, end);
            } else {
                worstCommits.add(commitList[end]);
            }
        }
    }

}
