package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertEquals(12.0, rectangle.area(), 0.0001); // Проверка площади (ширина * высота)
    }

    @Test
    public void testRectanglePerimeter() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertEquals(14.0, rectangle.perimeter(), 0.0001); // Проверка периметра (2 * (ширина + высота))
    }
}