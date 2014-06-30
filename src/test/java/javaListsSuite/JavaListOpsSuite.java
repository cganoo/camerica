package javaListsSuite;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import javaLists.JavaListOps;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by cganoo on 6/23/14.
 */
public class JavaListOpsSuite {

    @Test
    public void verifyAggregations() {
        final List<Double> dList1 = Lists.newArrayList(-100D, -2D, 0D, 0D, 1D, 10D, 10D);
        assertThat(JavaListOps.sum(dList1), is(-81D));

        final List<Double> dList2 = Lists.newArrayList(100D, 1D, 1D, -2D);
        assertThat(JavaListOps.multiply(dList2), is(-200D));
    }
}
