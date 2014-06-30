package javatoys;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by cganoo on 6/29/14.
 */
public class JavaToyProblems {
    final static Logger log = LoggerFactory.getLogger(JavaToyProblems.class);

    /**
     * Checks whether the parentheses in the specified string are balanced
     * Checks are made for the following kinds of parentheses '[', '(', '{'
     * @param s the string to be checked for balanced parentheses
     * @return true if s is empty or contains correctly balanced parentheses, false otherwise
     */
    public static Boolean isBalanced(final String s) {
        Deque<Character> stack = new ArrayDeque<>();
        final ImmutableMap<Character, Character> parens = ImmutableMap.of('(', ')', '{', '}', '[', ']');

        if(StringUtils.isBlank(s)) return true;

        for(final Character c : s.toCharArray()) {
            /*
             * Examine only those characters which are present
             * in the parens map as either keys or values
             */
            if(parens.containsKey(c)) {
                /*
                 * Add all recognized opening parentheses to our stack
                 */
                stack.addFirst(c);
            } else if(parens.containsValue(c)) {
                try {
                    /*
                     * The last added opening brace in the stack should 'match' the closing brace
                     * represented by c for the string to be balanced. If not, fail fast.
                     */
                    if(!c.equals(parens.get(stack.removeFirst()))) return false;
                } catch(NoSuchElementException e) {
                    /*
                     * We have a value from the parens map in hand (c)
                     * but our stack is empty. This implies the string in unbalanced
                     */
                    return false;
                }
            }
        }
        return true;
    }

    public static void regularPrint(final int[][] matrix) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                log.info("{}", matrix[row][col]);
            }
        }
    }

    private static void print_top_right(final int[][] m, int x1, int y1, int x2, int y2) {

        // Print the row from (x1, y1) to (x2, y1)
        for (int i = x1; i <= x2; i++) System.out.print(m[y1][i] + " ");

        // Print the column starting at (x2, y1) to (x2, y2)
        for (int j = y1 + 1; j <= y2; j++) System.out.print(m[j][x2] + " ");

        if(x2 > x1) {
            print_bottom_left(m, x1, y1 + 1, x2 - 1, y2);
        }
    }

    private static void print_bottom_left(final int[][] m, int x1, int y1, int x2, int y2) {

        // Print the row from (x2, y2) to (x1, y1)
        for (int i = x2; i >= x1; i--) System.out.print(m[y2][i] + " ");

        // Print the column starting at (x1, y2) to (x1, y1)
        for (int j = y2 - 1; j >= y1; j--) System.out.print(m[j][x1] + " ");

        if(x2 > x1) {
            print_top_right(m, x1 + 1, y1, x2, y2 - 1);
        }
    }

    public static void spiralPrint(final int[][] matrix) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        log.info("Rows [{}], Columns [{}]", rows, cols);
        print_top_right(matrix, 0, 0, cols - 1, rows - 1);
    }

    public static void spiralPrint2(int[][] matrix)
    {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        log.info("Rows [{}], Columns [{}]", rows, cols);

        if(rows == 0)
            return;
        // Initialize our four indexes
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true)
        {
            // Print top row
            for(int j = left; j <= right; ++j) System.out.print(matrix[top][j] + " ");
            top++;
            if(top > down || left > right) break;
            //Print the rightmost column
            for(int i = top; i <= down; ++i) System.out.print(matrix[i][right] + " ");
            right--;
            if(top > down || left > right) break;
            //Print the bottom row
            for(int j = right; j >= left; --j) System.out.print(matrix[down][j] + " ");
            down--;
            if(top > down || left > right) break;
            //Print the leftmost column
            for(int i = down; i >= top; --i) System.out.print(matrix[i][left] + " ");
            left++;
            if(top > down || left > right) break;
        }


    }

    public static void main(String[] args) {
        final int[][] matrix = {{1, 2, 3, 4}
                , {5, 6, 7, 8}
                , {9, 10, 11, 12}
                , {13, 14, 15, 16}
                , {17, 18, 19, 20}};
        spiralPrint(matrix);
        System.out.println();
        spiralPrint2(matrix);
    }
}
