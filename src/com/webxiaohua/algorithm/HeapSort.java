package com.webxiaohua.algorithm;

/**
 * @Author: shen_xh
 * @Time: 2019/1/18 12:47
 * @Desc: 堆排序:从一堆数据中建立大根堆，然后采用顶部移除法进行排序
 * https://blog.csdn.net/qq_35178267/article/details/78313306
 */
public class HeapSort {
	/**
	 * 父节点位置
	 * */
	static int parent(int i){
		return (i-1)/2;
	}
	/**
	 * 左子节点位置
	 * */
	static int left(int i){
		return 2*i + 1;
	}
	/**
	 * 右子节点
	 * */
	static int right(int i){
		return 2*i + 2;
	}

	//数组a，第i个结点，heapSize是数组中实际要排序的元素的长度
	static void maxHeapfy(int[] a,int i,int heapSize){
		int left = left(i);//有的时候能够递归到叶子结点，叶子结点无后继，下面两个if都注意到了这一点
		int right = right(i);
		int largest = i;
		if(left < heapSize && a[left] > a[largest]){
			largest = right;
		}
		if(right < heapSize && a[right] > a[largest]){
			largest = right;
		}
		if(largest != i){ //把最大值给父结点
			a[largest] = a[largest] ^ a[i];
			a[i] = a[largest] ^ a[i];
			maxHeapfy(a,largest,heapSize);  //发生交换之后还要保证大根堆性质
		}
	}

	static void buildMaxHeap(int[] a,int heapSize){
		for(int i=(heapSize-1)/2;i>=0;i--){
			maxHeapfy(a,i,heapSize);
		}
	}



}
