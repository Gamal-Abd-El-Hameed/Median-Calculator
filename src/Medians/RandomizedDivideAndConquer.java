package Medians;

import helperFunctions.HelperFunctions;

public class RandomizedDivideAndConquer implements Median {
    HelperFunctions helper = new HelperFunctions();
    @Override
    public int findMedian(int[] arr) {
        int n = arr.length;
        return RandSelect(arr, 0, n - 1, (n - 1) / 2);
    }

    private int RandSelect(int[] arr, int low, int high, int target) {
        if(low == high)
            return arr[low];
        int r = helper.RandomizedPartition(arr, low, high);
        int k = r - low;
        if(k == target)
            return arr[r];
        if(target < k)
            return RandSelect(arr, low, r - 1, target);
        return RandSelect(arr, r + 1, high, target - k - 1);
    }
}
