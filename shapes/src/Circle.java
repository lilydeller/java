//lily deller
//circle class  
public class Circle {
	private double radius;
	//PRIVATE - 
	public void setRadius(double i) {	
		this.radius = i;
		//this.radius refers to the instance variable above
	}
	public Circle(){
		setRadius(0);
		////default constructor - no parameters 
	}
	public Circle(double i) {	
		setRadius(i);
		//parameterized constructors - both are doubles
	}
	public double getRadius() {
		return radius;
	}
	public double area() {
		return Math.PI * getRadius() * getRadius();
		//formula for area of circle is pi r^2
		//using the Math.PI method
	}
	public String toString() {
		//returns a string representation of the circle
		return "The area of the circle is: "+ this.area();		
	}
	public boolean equals(Circle input) {
		return area()== input.area();
	}
}
