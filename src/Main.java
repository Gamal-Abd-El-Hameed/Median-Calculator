import Medians.MedianOfMedians;
import Medians.NaiveMedian;
import Medians.RandomizedDivideAndConquer;
import helperFunctions.HelperFunctions;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        RandomizedDivideAndConquer randomizedDivideAndConquer = new RandomizedDivideAndConquer();
        NaiveMedian naiveMedian = new NaiveMedian();
        MedianOfMedians medianOfMedians = new MedianOfMedians();
        HelperFunctions helper = new HelperFunctions();
        int NUMBER_OF_TEST_CASES = 50, NUMBER_OF_RUNS = 5;
        int[] arr;
        int[] sizes = new int[NUMBER_OF_TEST_CASES];
        long[] RandomizedDivideAndConquerTimes = new long[NUMBER_OF_TEST_CASES];
        long[] MedianOfMediansTimes = new long[NUMBER_OF_TEST_CASES];
        long[] NaiveMedianTimes = new long[NUMBER_OF_TEST_CASES];
        for(int testCase = 0; testCase < NUMBER_OF_TEST_CASES; ++testCase) {
            int size = helper.getRandomNumber(1, (int) Math.pow(10, 7));
            sizes[testCase] = size;
            arr = new int[size];
            for(int j = 0; j < size; ++j)
                arr[j] = helper.getRandomNumber(-1 * (int) Math.pow(10, 6), (int) Math.pow(10, 6));
            int med1 = 0, med2 = 0, med3 = 0;
            long t1, t2, avg;

            avg = 0;
            for(int k = 0; k < NUMBER_OF_RUNS; ++k) {
                t1 = System.currentTimeMillis();
                med1 = randomizedDivideAndConquer.findMedian(arr);
                t2 = System.currentTimeMillis();
                avg += (t2 - t1);
            }
            RandomizedDivideAndConquerTimes[testCase] = avg / NUMBER_OF_RUNS;
            avg = 0;
            for(int k = 0; k < NUMBER_OF_RUNS; ++k) {
                t1 = System.currentTimeMillis();
                med2 = medianOfMedians.findMedian(arr);
                t2 = System.currentTimeMillis();
                avg += (t2 - t1);
            }
            MedianOfMediansTimes[testCase] = avg / NUMBER_OF_RUNS;
            avg = 0;
            for(int k = 0; k < NUMBER_OF_RUNS; ++k) {
                t1 = System.currentTimeMillis();
                med3 = naiveMedian.findMedian(arr);
                t2 = System.currentTimeMillis();
                avg += (t2 - t1);
            }
            NaiveMedianTimes[testCase] = avg / NUMBER_OF_RUNS;
            if(med1 != med3 || med2 != med3) System.out.println();
        }
        System.out.println("Sizes = " + Arrays.toString(sizes));
        System.out.println("RandomizedDivideAndConquerTimes = " + Arrays.toString(RandomizedDivideAndConquerTimes));
        System.out.println("MedianOfMediansTimes = " + Arrays.toString(MedianOfMediansTimes));
        System.out.println("NaiveMedianTimes = " + Arrays.toString(NaiveMedianTimes));
    }
}
