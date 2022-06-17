import java.util.Random;

public class BubbleSorter {
	private int[] list;
	
	public BubbleSorter(int size) {
		list=new int[size];
		
		Random rand = new Random();
		
		for (int i=0; i<list.length; i++) {
			list[i] = rand.nextInt(100);
		}
	}
	
	public void swap(int i, int j) {
		int temp=list[i];
		list[i]=list[j];
		list[j]=temp;
	}
	
	public void sort() {
		boolean done=false;
		
		while (!done) {
			done=true;
			for (int i=1; i<list.length; i++) {
				if(list[i-1]>list[i]) {
					swap(i-1, i);
					done=false;
				}
			}
		}
	}
	
	
	public String toString(){
		String output="Array Contents: ";
		for (int i: list) {
			output+=i + ", ";
		}
		return output;
	}
	
}

