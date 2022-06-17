package demo1;

public class Second {
	public static int secondLargest (int[] array) {
		int largest=array[0] ;//largest  in array
		int secondLargest=array[0];
			for (int i=1; i<array.length; i++) {
				if (largest <= array[i]) {
					secondLargest=largest; //second largest in array
					largest=array[i];
				} else if (array[i]>=secondLargest) {
					secondLargest=array[i];
				}
		}
		return secondLargest;
		}


	public static void main(String[] args) {
		int[] array= {2,3,4,7,5,6,7,9};
		System.out.println(secondLargest(array));
	}

}
