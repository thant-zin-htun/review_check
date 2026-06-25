
abstract class Shape {
	protected String color;

	public abstract void area(); // concepts

	public Shape(String color) {
		super();
		this.color = color;
	}

	@Override
	public String toString() {
		return "Shape [color=" + color + "]";
	}
}

//Rectangle Shape
class Rectangle extends Shape {

	private int width;
	private int height;

	public Rectangle(String color, int width, int height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	public void area() {
		System.out.println("Area:" + (width * height));
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", color=" + color + "]";
	}

}

class Circle extends Shape {
	private int radius;

	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}

	public void diameter() {
		System.out.println("Diameter:" + (this.radius * 2));
	}

	public void area() {
		System.out.println("Area:" + (Math.PI * Math.pow(radius, 2)));
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}

}

class Triangle extends Shape {
	private int base;
	private int height;

	public Triangle(String color, int base, int height) {
		super(color);
		this.base = base;
		this.height = height;
	}

	public void area() {
		System.out.println("Area:" + (base * height) / 2);
	}

	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + ", color=" + color + "]";
	}

}

public class OOPConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Shape sc = new Shape("white"); // polymophism
		Shape re = new Rectangle("red", 2, 3);
		Shape re2 = new Rectangle("purple", 24, 3); // up casting polymophism
		Shape cir = new Circle("green", 3);
		Shape cir2 = new Circle("black", 7);
		Shape tri = new Triangle("blue", 7, 3);

		Shape[] shapes = { re, cir, tri, re2, cir2 };

		for (Shape shape : shapes) {
			System.out.println(shape);
			shape.area();

			if (shape instanceof Circle) {
				Circle obj = (Circle) shape; // down casting polymophism
				obj.diameter();
			}
		}

	}

}
