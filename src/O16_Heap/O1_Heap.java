package O16_Heap;

import java.util.ArrayList;

// Heap is data structure whose parent is higher priority than child
// and it should be complete binary tree
// Heap is also called Priority queue.
// Whenwver we remove from heap the element with max priority can be remove first.

public class O1_Heap {
    // we can store tree in the form of arraylist
    ArrayList<Integer> arr = new ArrayList<>();
    
    public void add(int item){
        arr.add(item);
        int currIdx = arr.indexOf(item);
        // we can do heapify
        while(currIdx > 0){
            int parentIdx = (currIdx - 1) / 2;
            if(arr.get(parentIdx) > item ){
                arr.set(currIdx, arr.get(parentIdx));
                arr.set(parentIdx, item);
                currIdx = parentIdx;
            }else{
                break;
            }
        }
    }

    public int remove(){
        int min = arr.get(0);
        // replacing 0th index with last item
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        int currIdx = 0;
        // we can do down heapify
        while(currIdx < arr.size()){
            int leftChildIdx = 2 * currIdx + 1;
            int rightChildIdx = 2 * currIdx + 2;
            int val = arr.get(currIdx);
            if(leftChildIdx < arr.size() && rightChildIdx < arr.size() && arr.get(currIdx) > arr.get(leftChildIdx) && arr.get(currIdx) > arr.get(rightChildIdx)){
                if(arr.get(leftChildIdx) < arr.get(rightChildIdx)){
                    arr.set(currIdx, arr.get(leftChildIdx));
                    arr.set(leftChildIdx, val);
                    currIdx = leftChildIdx;
                }else{
                    arr.set(currIdx, arr.get(rightChildIdx));
                    arr.set(rightChildIdx, val);
                    currIdx = rightChildIdx;
                }
            }else if(leftChildIdx < arr.size() && arr.get(currIdx) > arr.get(leftChildIdx)){
                arr.set(currIdx, arr.get(leftChildIdx));
                arr.set(leftChildIdx, val);
                currIdx = leftChildIdx;
            }else if(rightChildIdx < arr.size() && arr.get(currIdx) > arr.get(rightChildIdx)){
                arr.set(currIdx, arr.get(rightChildIdx));
                    arr.set(rightChildIdx, val);
                    currIdx = rightChildIdx;
            }else{
                break;
            }
        }
        return min;
    }

    public void display(){
        System.out.println(arr);
    }

    public int size(){
        return arr.size();
    }

    public boolean isEmpty(){
        return arr.isEmpty();
    }

    public static void main(String[] args){
        O1_Heap heap = new O1_Heap();
        heap.add(10);
        heap.display();
        heap.add(20);
        heap.display();
        heap.add(30);
        heap.display();
        heap.add(40);
        heap.display();
        heap.add(5);
        heap.display();
        heap.add(3);
        heap.display();
        heap.remove();
        heap.display();
        heap.remove();
        heap.display();
    }
}
