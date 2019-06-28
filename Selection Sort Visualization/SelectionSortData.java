
public class SelectionSortData {
	
	private int[] numbers;			
	
	public int orderedIndex = -1;			//[0...orderedIndex]是有序的
	public int currentMinIndex = -1;		//当前找到的最小元素的索引
	public int currentCompareIndex = -1;	//当前正在比较的元素索引
	
	public SelectionSortData(int N, int randomBound) {
		
		//randomBound是排序数字的范围的最大值，由用户指定
		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = (int)(Math.random() * randomBound) + 1;	//生成非0的数字，方便在图中表示出来
		}
	}
	
	public int N() {
		return numbers.length;	//返回排序数组的大小
	}
	
	public int get(int index) {
		if(index < 0 || index >= numbers.length) {
			throw new IllegalArgumentException("Invalid index to access Sort Data.");
		}
		return numbers[index];
	}
	
	public void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
