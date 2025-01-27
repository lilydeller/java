public class Triangle {
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
	public Triangle(){
		setLength(0);
		setHeight(0);
	}
	public Triangle(double length, double height) {	
		setLength(length);
		setHeight(height);
	}
	public double area() {
		return 0.5 * getLength() * getHeight();
	}
	public String toString() {
		return "The area of the triangle is: "+ this.area();		
	}
	public boolean equals(Triangle input) {
		return area() == input.area();
	}
}
