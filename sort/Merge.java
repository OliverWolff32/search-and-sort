package sort;

import java.util.Arrays;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge
{
  
  /**
   * Returns the sorted array
   */
  public static int[] sort(int[] arr) {
    // Your algorithm goes here!
    int n = arr.length;
    if (n < 2) {
        return arr;
    }
    
    int middle = n/2;
    int[] left = new int[middle];
    int[] right = new int[n - middle];
    
    for (int index = 0; index < middle; index++) {
        left[index] = arr[index]; 
    }
    int rightIndex = 0;
    for (int index = middle; index < n; index++) {
        right[rightIndex] = arr[index]; 
        rightIndex++;
    }
    sort(left);
    sort(right);
    merge(arr, left, right);
    return arr;
  }
  
  public static int[] merge(int[] arr, int[] left, int[] right) {
      int leftSize = left.length; 
      int rightSize = right.length; 
      
      int a = 0,b = 0,c = 0;
      
      while (a < leftSize && b < rightSize) {
          if (left[a] <= right[b]) {
              arr[c] = left[a];
              a++;
          } else {
              arr[c] = right[b];
              b++;
          }
          c++;
      }
      
      while (a < leftSize) {
          arr[c] = left[a]; 
          a++;
          c++;
          
      }
      while (b < rightSize) {
          arr[c] = right[b];
          b++;
          c++;
      }
      
      
      
      return arr; 
  }
  
  public static void main(String[] args) {
    int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
      31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
      73,54,51,25,33,20,52,79,97,70,54,63,49};    
    
    // Test the sort
    testSort(sort(arr));
  }
  
  public static void testSort(int[] arr) {
    for (int i=0; i<arr.length-1; i++) {
      if (arr[i] > arr[i+1]) {
        System.out.println("FAIL at index "+i);
        System.out.println(Arrays.toString(arr));
        return;
      }
    }
    System.out.println("SUCCESS!");
  }

}
