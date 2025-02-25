package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {
    @Test
    public void testSquareArea() {
        Square square = new Square(4.0);
        assertEquals(16.0, square.area(), 0.0001); // Проверка площади (сторона * сторона)
    }

    @Test
    public void testSquarePerimeter() {
        Square square = new Square(4.0);
        assertEquals(16.0, square.perimeter(), 0.0001); // Проверка периметра (4 * сторона)
    }
}