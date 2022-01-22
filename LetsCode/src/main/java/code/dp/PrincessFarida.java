package code.dp;

import java.util.Arrays;

/**
 * https://www.spoj.com/problems/FARIDA/
 *
 * Once upon time there was a cute princess called Farida living in a castle with her father, mother and uncle.
 * On the way to the castle there lived many monsters. Each one of them had some gold coins.
 * Although they are monsters they will not hurt. Instead they will give you the gold coins,
 * but if and only if you didn't take any coins from the monster directly before the current one.
 * To marry princess Farida you have to pass all the monsters and collect as many coins as possible.
 * Given the number of gold coins each monster has, calculate the maximum number of coins you can collect on your way to the castle.
 *
 * Input
 * The first line of input contains the number of test cases. Each test case starts with a number N, the number of monsters, 0 <= N <= 10^4.
 * The next line will have N numbers, number of coins each monster has, 0 <= The number of coins with each monster <= 10^9.
 * Monsters described in the order they are encountered on the way to the castle.
 *
 * Output
 * For each test case print “Case C: X” without quotes.
 * C is the case number, starting with 1.
 * X is the maximum number of coins you can collect.
 *
 * Example:--
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 1
 * 10
 *
 * Output:
 * Case 1: 9
 * Case 2: 10
 */
public class PrincessFarida {

    /**
     * Solve the problem - FARIDA
     * @param caseId Case ID (C)
     * @param numberOfMonsters Number of Monsters (N)
     * @param coinsArray integer array defining coins every monster has
     * @return the max number of coins collected
     */
    public int solve(final int caseId, final int numberOfMonsters, final int[] coinsArray) {
        //final int result = solveUsingRecursion(coinsArray, 0, numberOfMonsters);
        final int result = solveUsingDynamicProgramming(numberOfMonsters, coinsArray);

        System.out.printf("Case %d: %d", caseId, result);
        return result;
    }

    /**
     * Solve the problem using recursion
     * @param coinsArray Array of coins
     * @param current current index
     * @param size size of array => number of monsters
     * @return max coins (integer)
     */
    private int solveUsingRecursion(final int[] coinsArray, final int current, final int size) {
        if (coinsArray == null || size == 0) {
            return 0;
        }
        if (coinsArray.length == 1 || size == 1) {
            return coinsArray[current];
        }
        if (current >= size) {
            return 0;
        }
        if (current == size - 1) {
            return coinsArray[current];
        }

        int resultA = coinsArray[current] + solveUsingRecursion(coinsArray, current+2, size);
        int resultB = solveUsingRecursion(coinsArray, current+1, size);
        return Math.max(resultA, resultB);
    }

    /**
     * Initializes the buffer
     * @param coinsArray  Array of coins
     * @param buffer buffer to story history used for DP
     */
    private void initializeBaseCases(final int[] coinsArray, final int[][] buffer) {
        Arrays.stream(buffer).forEach(arr -> Arrays.fill(arr, 0));

        for(int i=0; i<coinsArray.length; i++) {
            buffer[i][i] = coinsArray[i];
        }
    }

    /**
     * Solve the problem using dynamic programming
     * @param numberOfMonsters number of monsters
     * @param coinsArray  Array of coins
     * @return max coins (integer)
     */
    private int solveUsingDynamicProgramming(final int numberOfMonsters, final int[] coinsArray) {
        if (coinsArray == null || numberOfMonsters == 0) {
            return 0;
        }
        if (coinsArray.length == 1 || numberOfMonsters == 1) {
            return coinsArray[0];
        }

        final int[][] buffer = new int[numberOfMonsters][numberOfMonsters];
        initializeBaseCases(coinsArray, buffer);
        int max = numberOfMonsters;

        for (int i=0; i<numberOfMonsters; i++ ) {
            for (int j=0; j<max; j++ ) {
                int resultA = buffer[j][j] + safeFetch(buffer, j+2, i+j);
                int resultB = safeFetch(buffer, j+1, i+j);
                buffer[j][j+i] = Math.max(resultA, resultB);
            }
            max--;
        }

        return buffer[0][numberOfMonsters-1];
    }

    /**
     * Safely fetches values from the buffer, to prevent exceptions
     * @param buffer DP buffer
     * @param i index i
     * @param j index j
     * @return integer value of buffer[i][j]
     */
    private int safeFetch(final int[][] buffer, final int i, final int j) {
        if ( i > j ) {
            return 0;
        }
        if (i >= buffer.length || j >= buffer.length) {
            return 0;
        }

        return buffer[i][j];
    }
}
