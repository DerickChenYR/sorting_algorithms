
public class mergeSort {


	public static void merge(int[] arr, int leftFirst, int leftLast, int rightFirst, int rightLast) {
		int rightNew = rightFirst;
		int leftNew = leftFirst;
		int indexNew = 0;

		//Create temp array to sort the sub partition of the array
		int[] newArr = new int[rightLast - leftFirst + 1];

		//Do swapping within the partition. Add to temp array in the right order
		while (rightNew <= rightLast && leftNew <= leftLast) {
			if (arr[leftNew] < arr[rightNew]){
				newArr[indexNew] = arr[leftNew];
				leftNew ++;
			}

			else {
				newArr[indexNew] = arr[rightNew];
				rightNew ++;
			}
			indexNew ++;
		}

		//Copy left over elements in left partition to temp array
		while (leftNew <= leftLast) {
			newArr[indexNew] = arr[leftNew];
			leftNew++;
			indexNew++;
		}

		//Copy left over elements in right partition to temp array
		while (rightNew <= rightLast) {
			newArr[indexNew] = arr[rightNew];
			rightNew++;
			indexNew++;
		}

		//Copy entire temp array content to original unsorted array starting from the index of the partition
		indexNew = 0;
		for (int i=leftFirst; i <= rightLast; i++) {
			arr[i] = newArr[indexNew];
			indexNew++;
		}
	}


	public static void mergeSortRec(int[] arr, int firstIndex, int lastIndex) {

		if (firstIndex >= lastIndex);
		else {

			int mid = (firstIndex + lastIndex)/2;

			mergeSortRec(arr, firstIndex, mid);
			mergeSortRec(arr, mid+1, lastIndex);
			merge(arr, firstIndex, mid, mid+1, lastIndex);
		}

	}


	public static void main(String[] args) {

		int[] arr = {9,7,5,3,1,2,4,6,8};

		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println("");


		mergeSortRec(arr, 0, arr.length-1);

		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}

	}
}