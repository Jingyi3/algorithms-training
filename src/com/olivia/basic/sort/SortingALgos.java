package com.olivia.basic.sort;

import java.util.Arrays;

public class SortingALgos {
    public static void main(String[] args) {
        int[] arr = {9, 24, 3, 8, 13, 7, 16, 5};
//        insertionSort(arr);
//        shellSort(arr);
//        quicksort(arr,0,arr.length-1);
//        bubbleSort(arr);
        int[] res =MergeSort(arr);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 归并排序
     * 5. 4 算法分析
     * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

//最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j<arr.length; j++) {
                if(arr[j]>arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;


                }
            }
        }
    }
    //O(n^2) Best n Worst n^2
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j - 1] > curr) {
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = curr;
                    break;
                }
            }
        }
    }

    //
    public static void shell_sort(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1;      // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
        }
    }
    private static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int i = 0; i + gap < arr.length; i++) {
                for (int k = 0; k + gap < arr.length; k += gap) {
                    if (arr[k] > arr[k + gap]) {
                        int next = arr[k + gap];
                        arr[k + gap] = arr[k];
                        arr[k] = next;

                    }
                }
            }
        }
    }

    private static int partition (int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start-1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i+1;
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotPos = partition(arr, start, end);
            quicksort(arr, start, pivotPos - 1);
            quicksort(arr, pivotPos + 1, end);
        }
    }


    private static int partition1(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition1(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}
