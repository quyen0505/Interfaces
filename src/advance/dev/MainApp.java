
package advance.dev;

import java.util.Scanner;

//Lớp cơ sở trừu tượng Shape
abstract class Shape {
	public abstract double chuVi();

	public abstract double dienTich();
}

// Interface IShape
interface IShape {
	void input(Shape[] shapes);

	void print(Shape[] shapes);
}

// Các lớp kế thừa từ Shape và thực thi IShape
class Triangle extends Shape implements IShape {
	private double a, b, c;

	public Triangle() {
	}

	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double chuVi() {
		return a + b + c;
	}

	@Override
	public double dienTich() {
		double s = chuVi() / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	@Override
	public void input(Shape[] shapes) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] instanceof Triangle) {
				System.out.println("Nhập cạnh a của Tam giác thứ " + (i + 1) + ":");
				double a = scanner.nextDouble();
				System.out.println("Nhập cạnh b của Tam giác thứ " + (i + 1) + ":");
				double b = scanner.nextDouble();
				System.out.println("Nhập cạnh c của Tam giác thứ " + (i + 1) + ":");
				double c = scanner.nextDouble();
				shapes[i] = new Triangle(a, b, c);
			}
		}
	}

	@Override
	public void print(Shape[] shapes) {
		for (Shape shape : shapes) {
			if (shape instanceof Triangle) {
				Triangle triangle = (Triangle) shape;
				System.out.printf("Tam giác với cạnh a: %.2f, b: %.2f, c: %.2f, Chu vi: %.2f, Diện tích: %.2f\n",
						triangle.a, triangle.b, triangle.c, triangle.chuVi(), triangle.dienTich());
			}
		}
	}
}

class Circle extends Shape implements IShape {
	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double chuVi() {
		return 2 * Math.PI * radius;
	}

	@Override
	public double dienTich() {
		return Math.PI * radius * radius;
	}

	@Override
	public void input(Shape[] shapes) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] instanceof Circle) {
				System.out.println("Nhập bán kính của Hình tròn thứ " + (i + 1) + ":");
				double radius = scanner.nextDouble();
				shapes[i] = new Circle(radius);
			}
		}
	}

	@Override
	public void print(Shape[] shapes) {
		for (Shape shape : shapes) {
			if (shape instanceof Circle) {
				Circle circle = (Circle) shape;
				System.out.printf("Hình tròn với bán kính: %.2f, Chu vi: %.2f, Diện tích: %.2f\n", circle.radius,
						circle.chuVi(), circle.dienTich());
			}
		}
	}
}

class Rectangle extends Shape implements IShape {
	private double length, width;

	public Rectangle() {
	}

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public double chuVi() {
		return 2 * (length + width);
	}

	@Override
	public double dienTich() {
		return length * width;
	}

	@Override
	public void input(Shape[] shapes) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] instanceof Rectangle) {
				System.out.println("Nhập chiều dài của Hình chữ nhật thứ " + (i + 1) + ":");
				double length = scanner.nextDouble();
				System.out.println("Nhập chiều rộng của Hình chữ nhật thứ " + (i + 1) + ":");
				double width = scanner.nextDouble();
				shapes[i] = new Rectangle(length, width);
			}
		}
	}

	@Override
	public void print(Shape[] shapes) {
		for (Shape shape : shapes) {
			if (shape instanceof Rectangle) {
				Rectangle rectangle = (Rectangle) shape;
				System.out.printf(
						"Hình chữ nhật với chiều dài: %.2f, chiều rộng: %.2f, Chu vi: %.2f, Diện tích: %.2f\n",
						rectangle.length, rectangle.width, rectangle.chuVi(), rectangle.dienTich());
			}
		}
	}
}

public class MainApp {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[10];
		// Khởi tạo các đối tượng trong mảng
		for (int i = 0; i < shapes.length; i++) {
			if (i < 3) {
				shapes[i] = new Circle();
			} else if (i < 6) {
				shapes[i] = new Rectangle();
			} else {
				shapes[i] = new Triangle();
			}
		}

		// Nhập thông tin các hình
		new Circle().input(shapes);
		new Rectangle().input(shapes);
		new Triangle().input(shapes);

		// In thông tin các hình
		new Circle().print(shapes);
		new Rectangle().print(shapes);
		new Triangle().print(shapes);

		// Tìm hình có diện tích lớn nhất
		Shape maxShape = shapes[0];
		for (Shape shape : shapes) {
			if (shape.dienTich() > maxShape.dienTich()) {
				maxShape = shape;
			}
		}
		System.out.println("Hình có diện tích lớn nhất là: " + maxShape.getClass().getSimpleName() + " với diện tích: "
				+ maxShape.dienTich());
	}
}
