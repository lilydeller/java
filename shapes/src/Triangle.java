public class Triangle {
	private double length;
	public void setLength(double i) {
		this.length = i;
		//PRIVATE - making only accessible within declared class
		//making variables
	}
	public double getLength() {
		return length;
		//getter
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
		//default constructor - no parameters 
	}
	public Triangle(double length, double height) {	
		setLength(length);
		setHeight(height);
		//parameterized constructors - both are doubles
	}
	public double area() {
		return 0.5 * getLength() * getHeight();
		//formula for triangle 1/2 length times height
	}
	public String toString() {
		return "The area of the triangle is: "+ this.area();		
	}
	public boolean equals(Triangle input) {
		return area() == input.area();
		//return true if the height and length are the same - only one parameter
	}
}
