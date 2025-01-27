
public class Circle {
	private double radius;
	public void setRadius(double i) {	
		this.radius = i;
	}
	public Circle(){
		setRadius(0);
	}
	public Circle(double i) {	
		setRadius(i);
	}
	public double getRadius() {
		return radius;
	}
	public double area() {
		return Math.PI * getRadius() * getRadius(); 
	}
	public String toString() {
		return "The area of the circle is: "+ this.area();		
	}
	public boolean equals(Circle input) {
		return area()== input.area();
	}
}
