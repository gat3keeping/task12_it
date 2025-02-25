package org.example;
import java.io.*;
import java.util.*;

// Абстрактный класс "Фигура"
abstract class Shape {
    public abstract double area(); // Метод для вычисления площади
    public abstract double perimeter(); // Метод для вычисления периметра
}

// Класс "Круг"
class Circle extends Shape {
    private double radius; // Радиус круга

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius; // Площадь круга
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius; // Периметр круга
    }
}

// Класс "Квадрат", наследуется от Shape
class Square extends Shape {
    private double side; // Сторона квадрата

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом.");
        }
        this.side = side;
    }

    @Override
    public double area() {
        return side * side; // Площадь квадрата
    }

    @Override
    public double perimeter() {
        return 4 * side; // Периметр квадрата
    }
}

// Класс "Прямоугольник"
class Rectangle extends Shape {
    private double width; // Ширина прямоугольника
    private double height; // Высота прямоугольника

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными числами.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height; // Площадь прямоугольника
    }

    @Override
    public double perimeter() {
        return 2 * (width + height); // Периметр прямоугольника
    }
}

// Класс "Треугольник"
class Triangle extends Shape {
    private double a, b, c; // Стороны треугольника

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными числами.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Сумма двух сторон треугольника должна быть больше третьей стороны.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        // Площадь треугольника
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return a + b + c; // Периметр треугольника
    }
}

// Класс для чтения фигур из файла
class ShapeReader {
    // Метод для чтения фигур из файла
    public static List<Shape> readShapesFromFile(String filename) {
        List<Shape> shapes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new
                FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String shapeType = parts[0].toLowerCase(); // Определение типа фигуры
                // Объекты фигур в зависимости от типа
                switch (shapeType) {
                    case "circle":
                        double radius = Double.parseDouble(parts[1]);
                        shapes.add(new Circle(radius));
                        break;
                    case "square":
                        double side = Double.parseDouble(parts[1]);
                        shapes.add(new Square(side));
                        break;
                    case "rectangle":
                        double width = Double.parseDouble(parts[1]);
                        double height = Double.parseDouble(parts[2]);
                        shapes.add(new Rectangle(width, height));
                        break;
                    case "triangle":
                        double a = Double.parseDouble(parts[1]);
                        double b = Double.parseDouble(parts[2]);
                        double c = Double.parseDouble(parts[3]);
                        shapes.add(new Triangle(a, b, c));
                        break;
                    default:
                        System.out.println("Неизвестный тип фигуры: " +
                                shapeType);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректные данные фигуры: " +
                    e.getMessage());
        }
        return shapes;
    }

    public static void main(String[] args) {
        String filename = "src/main/resources/shapes.txt";
        List<Shape> shapes = readShapesFromFile(filename);
        for (Shape shape : shapes) {
            System.out.println("Фигура: " +
                    shape.getClass().getSimpleName());
            System.out.println("Площадь: " + shape.area());
            System.out.println("Периметр: " + shape.perimeter());
            System.out.println();
        }
    }
}