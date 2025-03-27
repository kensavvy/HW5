/******************************************************************
 *
 *   Kendall Savino / COMP 272 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOUR CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

        // Initialize boolean variable assuming array is not a subset
        boolean isSubset = false;

        // Initialize new HashSet
        Set<Integer> set = new HashSet<>();

        // Add elements from list1 into set
        for (int num : list1) {
            set.add(num);
        }

        // Loop through list2 to check if every element is also in list1
        for (int num : list2) {

            if (!set.contains(num)) {
                return false;
            }

        }

        // Update boolean variable to be true if every element passes
        isSubset = true;

        return isSubset;

    } // method isSubset


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE

        // Initialize new PriorityQueue which implements a minHeap by default
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert elements in array into priority queue
        for (int num : array) {
            minHeap.offer(num);

            // If heap size is greater than k, remove and return smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        
        // Continue looping through array, keeping minHeap restricted to k elements,
        // until all elements are processed and the heap contains the k largest elements

        }

        // Return root of heap, the smallest value AKA the kth largest element
        return minHeap.peek();

    } // method findKthLargest


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOUR CODE HERE

        // Initialize new PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elemets from array1 into priority queue
        for (int num : array1) {
            minHeap.offer(num);
        }

        // Add all elements from array2 into priority queue
        for (int num : array2) {
            minHeap.offer(num);
        }

        // Initialize empty array which will store both array1 and array2 elements
        int[] sortedArray = new int[array1.length + array2.length];

        // Initialize index counter
        int i = 0;

        // Remove and return the smallest element in heap, placing it in the sorted array
        while (!minHeap.isEmpty()) {
            sortedArray[i++] = minHeap.poll();
        }

        // After the heap is empty, sortedArray will be fully populated in ascending order
        return sortedArray;

    } // method sort2Arrays

} // class ProblemSolutions