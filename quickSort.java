
import java.util.Random;



public class quickSort {


	public static int partition(int[] arr, int left, int right, int pivotIndex) {

		//Swap pivot value with right most element
		int pivot = arr[pivotIndex];

		arr[pivotIndex] = arr[right];
		arr[right] = pivot;

		//Set pivot index to right index
		pivotIndex = right;
		//Right index minus 1
		right = right - 1;

		while (left <= right){
			
			//Two pointers towards the middle, till they cross or till one finds an element that shouldn't be in its current partition
			while (arr[left] < pivot){ left ++;}
			while (right >= left && arr[right] >= pivot) {right --;}

			//Swap bad elements
			if (right > left){
				
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

			}
		}

		//Swap pivot index with current center
		arr[pivotIndex] = arr[left];
		arr[left] = pivot;

		return left;

	}

	public static void quickSortRec(int[] arr, int left, int right) {

		//Randomly choose a pivot between left and right
		Random generator = new Random();
		int pivotIndex = generator.nextInt(right-left+1)+left;
		int newPivotIndex = partition(arr, left, right, pivotIndex);

		//Recursion calls
		if (newPivotIndex - left > 1)
			quickSortRec(arr, left, newPivotIndex -1);
		if (right - newPivotIndex > 1)
			quickSortRec(arr, newPivotIndex, right);
	}


	public static void main(String[] args) {

		int[] arr = {9,7,5,3,1};

		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println("");


		quickSortRec(arr, 0, arr.length-1);

		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}

	}
}