package sortArr;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        int[] tree = {2,5,3,1,10,4};
        int n = tree.length;
        h.heap_sort(tree,n);
        System.out.println(Arrays.toString(tree));
    }

    /**
     *
     * @param tree
     * @param n 元素个数
     * @param i  进行堆排序的元素
     */
    void heapify(int[] tree, int n, int i){
        if(i >= n)  //排序索引超出
        {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if(c1 < n&& tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2]> tree[max]){
            max = c2;
        }
        if(max != i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }
     void swap(int[] tree, int i, int j){
        int temp = tree[j];
        tree[j] = tree[i];
        tree[i] = temp;
    }
    void build_heap(int[] tree,int n){
       int lastNode = n - 1;
       int parent = (lastNode - 1) / 2;
       for(int i = parent; i >= 0; i--){
           heapify(tree,n,i);
       }
    }

     void heap_sort(int[] tree,int n){
        build_heap(tree,n);
        for(int i = n - 1; i >= 0; i--){
            swap(tree,i,0);
            heapify(tree,i,0);
        }
    }
}
