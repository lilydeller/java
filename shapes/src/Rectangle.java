public class Rectangle {
	private double length;
	//PRIVATE - making only accessible within declared class
	//making variables
	public void setLength(double i) {
		this.length = i;
		//this.radius refers to the instance variable above
	}
	public double getLength() {
		return length;
		//getLength = "getter"
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
		//default constructor - no parameters 
	}
	public Rectangle(double length, double height) {
		setLength(length);
		setHeight(height);
		//parameterized constructors - both are doubles
	}
	public double area() {
		return getLength() * getHeight();
		//formula for area of a rectangle is length times height
	}
	public String toString() {
		return "The area of the rectangle is: "+ this.area();	
		//print the result 
	}
	public boolean equals(Rectangle input) {
		return area() == input.area();
		//one parameters - print true if length and height are the same
	}
}

