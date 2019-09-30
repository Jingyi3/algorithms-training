package com.olivia.basic.sort;

public class Demo01_HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, --heapSize);
        }

    }

    /**
     * 建立大根堆的过程
     * @param arr
     * @param index
     */

    public static void heapInsert(int[] arr, int index) {

        while (arr[index] > arr[(index - 1) / 2]) {
            // 当index==0时候 parentIndex = （0-1）/2 which is 0
            int parentIndex = (index - 1) / 2;
            swap(arr, index, parentIndex);
            index = parentIndex;
        }

    }

    /**
     * function: one node's value changed, if its value is smaller, it will go down
     *
     * @param arr
     * @param currIndex
     * @param heapSize
     */
    public static void heapify(int[] arr, int currIndex, int heapSize) {
        int leftLeafIndex = currIndex * 2 + 1;
        int rightLeafIndex = leftLeafIndex + 1;
        while (leftLeafIndex < heapSize) {
            int largestIndex = rightLeafIndex < heapSize && arr[rightLeafIndex] > arr[leftLeafIndex]
                    ? rightLeafIndex
                    : leftLeafIndex;
            largestIndex = arr[largestIndex] > arr[currIndex] ? largestIndex : currIndex;
            if (largestIndex == currIndex) break;
            swap(arr, largestIndex, currIndex);
            currIndex = largestIndex;
            leftLeafIndex = currIndex * 2 + 1;
            rightLeafIndex = leftLeafIndex + 1;
        }
    }


    public static void swap(int[] a, int b, int c) {

    }
}
