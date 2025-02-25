package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {
    @Test
    public void testCircleArea() {
        Circle circle = new Circle(2.0);
        assertEquals(Math.PI * 4, circle.area(), 0.0001); // Проверка площади (π * r²)
    }

    @Test
    public void testCirclePerimeter() {
        Circle circle = new Circle(2.0);
        assertEquals(2 * Math.PI * 2, circle.perimeter(), 0.0001); // Проверка периметра (2 * π * r)
    }
}