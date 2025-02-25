package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    public void testTriangleArea() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0); // Прямоугольный треугольник
        double s = (3.0 + 4.0 + 5.0) / 2; // Полупериметр
        double expectedArea = Math.sqrt(s * (s - 3.0) * (s - 4.0) * (s - 5.0));
        assertEquals(expectedArea, triangle.area(), 0.0001); // Проверка площади по формуле Герона
    }

    @Test
    public void testTrianglePerimeter() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        assertEquals(12.0, triangle.perimeter(), 0.0001); // Проверка периметра (сумма сторон)
    }
}