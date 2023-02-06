package Medians;

import helperFunctions.HelperFunctions;

import java.util.*;

public class MedianOfMedians implements Median {
    private final HelperFunctions helper = new HelperFunctions();
    @Override
    public int findMedian(int[] arr) {
        int n = arr.length;
        return select(arr, (n - 1) / 2, 0, n - 1);
    }

    private int select(int[] arr, int target, int low, int high) {
        if(low == high)
            return arr[low];

        // 1. Divide the n elements into groups of 5. Find the median of each 5-element group.
        int[] medians = findMedians(arr, low, high);
        // 2. Recursively SELECT the median x of the ⌊n / 5⌋ group medians to be the pivot.
        int mediansSize = medians.length;
        int medianOfMedians;
        if(mediansSize % 2 == 0)
             medianOfMedians = select(medians, mediansSize / 2 - 1, 0, mediansSize - 1);
        else
            medianOfMedians = select(medians, mediansSize / 2, 0, mediansSize - 1);
        // 3. Partition around the pivot x. Let k = rank(x).
        int pivot = partitionAround(arr, medianOfMedians, low, high);
        if(pivot - low == target)
            return medianOfMedians;
        if(target < pivot - low)
            return select(arr, target, low, pivot - 1);
        return select(arr, low + target - pivot - 1, pivot + 1, high);
    }

    private int[] findMedians(int[] arr, int low, int high) {
        int n = high - low + 1;
        int DIVIDING_FACTOR = 5;
        int size = (int) Math.ceil(n * 1.0 / DIVIDING_FACTOR);
        int[] ans = new int[size];
        int i, k;
        for(i = low, k = 0; i <= low + n - DIVIDING_FACTOR; i += DIVIDING_FACTOR, ++k) {
            Arrays.sort(arr, i, i + DIVIDING_FACTOR);
            ans[k] = arr[i + DIVIDING_FACTOR / 2];
        }
        if(n % DIVIDING_FACTOR != 0) {
            Arrays.sort(arr, i, high + 1);
            ans[k] = arr[i + (high - i) / 2];
        }
        return ans;
    }

    private int partitionAround(int[] arr, int x, int low, int high) {
        int pivot = low;
        for(int i = low; i <= high; ++i) {
            if(arr[i] == x) { // if(Math.abs(arr[i] - x) <= Math.pow(10, -7))
                pivot = i;
                break;
            }
        }
        helper.swap(arr, pivot, high);
        return helper.partition(arr, low, high);
    }
}
