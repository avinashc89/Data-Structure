package com.tool.java.leetcode;

public class ShortestRangeInKSortedArray
{
    
    public static void main(String args[])
    {
        
        int[][] A = new int[3][];
        A[0] = new int[] { 4, 10, 15, 24, 26};
        A[1] = new int[] { 0, 9, 12, 20 };
        A[2] = new int[] { 5, 18, 22, 30 };
        
        shortestRange(A);
    }

    
    /*
     
     0     4 5     9 10   12   15  18  20  22  24  26    30
     --------------------------------------------------------
     
     longest range is 0-30 such that it contains atleat one element from each array.
     Now reduce the range between min and max,
     
     4,0,5 -> find the diff in min and max = 5 the current range size {0,5}
     
     move the min of those array -> 0 -> 9
     4,9,5 = 5 is the current range. {4,9}
     
     continue until the current range is smallest
     
     
     */
    
    public static void shortestRange(int[][] intList)
    {
        int[] pointers =  new int[intList.length];
        Element[] minHeap = new Element[intList.length];
        int minRange  =  Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int finalMin = Integer.MAX_VALUE;
        int finalMax = Integer.MIN_VALUE;
        
        //put the first elements in the min heap
        for(int i=0; i<intList.length; i++)
        {
            int[] tempList = intList[i];
        
            if(tempList.length > 0)
            {         
                minHeap[i] = new Element(i, tempList[0]);
                if(tempList[0] > max)
                {
                    max = tempList[0];
                }
                    
            }
            else
            {
                //print the range
                System.out.println("One of the lists is empty");
                return;
            }
        }
        
        //minHeap[] has the three elements. build minheap.
        while(true)
        {
            buildMinHeap(minHeap, minHeap.length);
            Element minElement = minHeap[0];          //contains the min element
            int listIndex = minElement.listIndex;
            min = minElement.value;
            
            
            if((max-min) < minRange)
            {
                finalMax = max;
                finalMin = min;
                minRange = max - min;
            }
            
            //check if the moving min has next element.
            if((pointers[listIndex] + 1 ) < intList[listIndex].length)
            {
                pointers[listIndex]++;
                Element nextElement = new Element(listIndex, intList[listIndex][pointers[listIndex]]);
                
                //if the next num is greater than current max update it.
                if(nextElement.value > max)
                {
                    max = nextElement.value;
                }
                
                //put in heap and continue the loop
                minHeap[0] = nextElement;
            }
            else
            {
                System.out.println("{" + finalMin + "," + finalMax + "}");
                return;
            }
            
            
        }
        
    }
    
     public static void minHeapify(Element[] array, int curIndex, int heapSize){
            // Left child in heap
            int left = 2*curIndex+1;
            // Right child in heap
            int right = 2*curIndex+2;
            int smallest = curIndex;
          
            if(left < heapSize && array[left].value < array[curIndex].value) {
                smallest = left;
            }
          
            if(right < heapSize && array[right].value < array[smallest].value) {
                smallest = right;
            }
          
            if(smallest != curIndex){
                swap(array, curIndex, smallest);
                minHeapify(array, smallest, heapSize);
            }
        }
         
        public static void buildMinHeap(Element[] array, int heapSize){
            // call maxHeapify on all internal nodes
            int lastElementIndex = array.length - 1;
            int parentIndex = (lastElementIndex - 1)/2;
            for(int i = parentIndex; i >= 0; i--){
                minHeapify(array, i, heapSize);
            }
        }
        
        private static void swap(Element[] array, int i, int j) {
            Element tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;     
        }
        
        

}

class Element{
    int listIndex;
    int value;
    
    Element(int a, int b)
    {
        this.listIndex = a;
        this.value = b;
    }
}
