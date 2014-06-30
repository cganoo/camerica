package javaToyProblemsSuite;

import javatoys.JavaToyProblems;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cganoo on 6/29/14.
 */
public class JavaToyProblemsOpsSuite {

    @Test
    public void verifyIfBalanced() {
        final String s0 = "(()())";
        final String s1 = "(if (zero? x) max (/ 1 x))";
        final String s2 = "I told him (that it’s not [yet] done). {But he wasn’t listening}";
        final String s3 = ":-)";
        final String s4 = "())(";
        final String s5 = "[[}}";
        final String s6 = null;
        final String s7 = "";
        final String s8 = "    ";

        assertThat(JavaToyProblems.isBalanced(s0), is(true));
        assertThat(JavaToyProblems.isBalanced(s1), is(true));
        assertThat(JavaToyProblems.isBalanced(s2), is(true));
        assertThat(JavaToyProblems.isBalanced(s3), is(false));
        assertThat(JavaToyProblems.isBalanced(s4), is(false));
        assertThat(JavaToyProblems.isBalanced(s5), is(false));
        assertThat(JavaToyProblems.isBalanced(s6), is(true));
        assertThat(JavaToyProblems.isBalanced(s7), is(true));
        assertThat(JavaToyProblems.isBalanced(s8), is(true));

    }
}
