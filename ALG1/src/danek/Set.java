package danek;

public class Set {
	private double[] array;
	public int length;
	
	public Set() {
		this.array = new double[0];
		this.length = 0;
	}
	
	public void add(double element) {
		if (this.contains(element)) return;
		
		double[] newArray = new double[this.array.length + 1];
		
		for (int i = 0; i < this.array.length; i++) {
			newArray[i] = this.array[i];
		}
		
		newArray[newArray.length - 1] = element;
		this.array = newArray;
		this.length = this.array.length;
	}
	
	public boolean contains(double element) {
		return this.indexOf(element) > -1;
	}
	
	public int indexOf(double element) {
		int index = -1;
		
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] == element) {
				index = i;
				break;
			}
			
		}
		
		return index;
	}
	
	public void remove(double element) {
		if (!this.contains(element)) return;
		
		double[] newArray = new double[this.array.length - 1];
		
		for (int i = 0; i < (this.array.length - 1); i++) {
			if (this.array[i] == element) continue;
			newArray[i] = this.array[i];
		}

		this.array = newArray;
		this.length = this.array.length;
	}
	
	public double[] asArray() {
		return this.array;
	}
}
