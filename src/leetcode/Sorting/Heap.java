package leetcode.Sorting;

import java.util.*;

@SuppressWarnings("unchecked")
public class Heap<T>
{
   private static final int CAPACITY = 2;

   private int size;            // Number of elements in heap
   private T[] heap;     // The heap array

   public Heap()
   {
      size = 0;
      heap = (T[]) new Comparable[CAPACITY];
   }

 /**
  * Construct the binary heap given an array of items.
  */
   public Heap(T[] array)
   {
      size = array.length;
      heap = (T[]) new Comparable[array.length+1];

      System.arraycopy(array, 0, heap, 1, array.length);//we do not use 0 index

      buildHeap();
   }
 /**
  *   runs at O(size)
  */
   private void buildHeap()
   {
      for (int k = size/2; k > 0; k--)
      {
         percolatingDown(k);
      }
   }
   
   //Swap with smallest of two children
   private void percolatingDown(int k)
   {
      while(2*k <= size){
    	  int child = 2*k;
    	  if(child < size && larger(heap[child], heap[child + 1]))  // find smallest child
    		  child++;
    	  if(!larger(heap[k], heap[child]))                        
    		  break;
    	  swap(heap, k, child);                                    // swap and percolate, if necessary
    	  k = child;  	  
      }
   }

 private void swap(T[] heap, int k, int child) {
	T tmp = heap[k];
	heap[k] = heap[child];
	heap[child] = tmp;
}

private boolean larger(T i, T j	) {
	 return ((Comparable) i).compareTo(j) > 0;
}

/**
  *  Sorts a given array of items.
  */
   public void heapSort(T[] array)
   {
      size = array.length;
      heap = (T[]) new Comparable[size+1];
      System.arraycopy(array, 0, heap, 1, size);
      buildHeap();

      for (int i = size; i > 0; i--)
      {
    	//move top item to the end of the heap array
         swap(heap, i, 1);
         size--;
         percolatingDown(1);
      }
      
      for(int k = 0; k < heap.length-1; k++)
         array[k] = heap[heap.length - 1 - k];
   }

 /**
  * Deletes the top item
  */
   public T deleteMin() throws RuntimeException
   {
      if (size == 0) throw new RuntimeException();
      T min = heap[1];            //minimum element is the root
      heap[1] = heap[size--];     //replace root with last element in heap
      percolatingDown(1);         // percolate new root downwards
      return min;                 // return min
	}

 /**
  * Inserts a new item
  */
   public void insert(T x)
   {
      if(size == heap.length - 1) doubleSize();

      //Insert a new item to the end of the array
      int pos = ++size;

      //Percolate up
      //If the heap order is violated because a node's key becomes larger than that node's parents key, 
      //then we can make progress toward fixing the violation by exchanging the node with its parent.
      while(pos > 1  && larger(heap[pos/2], x)){
    	  heap[pos] = heap[pos/2];
    	  pos = pos/2;
      }
      
      heap[pos] = x;
   }
   private void doubleSize()
   {
      T [] old = heap;
      heap = (T []) new Comparable[heap.length * 2];
      System.arraycopy(old, 1, heap, 1, size);
   }

   public String toString()
   {
      String out = "";
      for(int k = 1; k <= size; k++) out += heap[k]+" ";
      return out;
   }

   public static void main(String[] args)
   {
      Heap<String> h = new Heap<String>();

      h.insert("p");
      h.insert("r");
      h.insert("i");
      h.insert("o");
      System.out.println(h);
      h.deleteMin();
      System.out.println(h);


      Heap<Integer> tmp = new Heap<Integer>();
      Integer[] a = {4,7,7,7,5,0,2,3,5,1};
      tmp.heapSort(a);
      System.out.println(Arrays.toString(a));
   }
}
