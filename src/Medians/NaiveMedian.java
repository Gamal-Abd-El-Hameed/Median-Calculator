package Medians;

import java.util.*;

public class NaiveMedian implements Median {
    @Override
    public int findMedian(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        return arr[(n - 1) / 2];
    }
}
