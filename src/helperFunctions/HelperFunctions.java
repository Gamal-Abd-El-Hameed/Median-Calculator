package helperFunctions;

public class HelperFunctions {
    public int partition(int[] arr, int low, int high) {
        int x = arr[high];
        int i = low - 1;
        for(int j = low; j < high; ++j) {
            if(arr[j] < x) {
                ++i;
                swap(arr, i, j);
            }
        }
         swap(arr, i + 1, high);
        return i + 1;
    }

    public int RandomizedPartition(int[] arr, int low, int high) {
        int i = getRandomNumber(low, high);
        swap(arr, i, high);
        return partition(arr, low, high);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getRandomNumber(int low, int high) {
        return (int) ((Math.random() * (high + 1 - low)) + low);
    }
}
