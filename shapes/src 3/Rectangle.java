public class Rectangle {
	private double length;
	public void setLength(double i) {
		this.length = i;
	}
	public double getLength() {
		return length;
	}
	private double height;
	public void setHeight(double i) {
		this.height = i;
	}
	public double getHeight() {
		return height;
	}
	public Rectangle(){
		setLength(0);
		setHeight(0);
	}
	public Rectangle(double length, double height) {
		setLength(length);
		setHeight(height);
	}
	public double area() {
		return getLength() * getHeight();
	}
	public String toString() {
		return "The area of the rectangle is: "+ this.area();		
	}
	public boolean equals(Rectangle input) {
		return area() == input.area();
	}
}

