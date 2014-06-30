package javaLists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by cganoo on 6/23/14.
 */
public class JavaListOps {
    final static Logger log = LoggerFactory.getLogger(JavaListOps.class);

    public static double sum(List<Double> list) {
        if(list == null || list.isEmpty()) return 0;
        double sum = 0;
        for(final double l : list ) {
            sum += l;
        }
        return sum;
    }

    public static double multiply(List<Double> list) {
        if(list == null || list.isEmpty()) return 0;
        double sum = 1;
        for(final double l : list ) {
            sum *= l;
        }
        return sum;
    }
}
