package org.triangles;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TriangleTest{
    @Test
    public void given_3doubles_when_createTriangle_then_notATriangle() throws ExcepcionTriangulo{
        double lado1 = 1;
        double lado2 = 2;
        double lado3 = 10;
        ExcepcionTriangulo result = assertThrows(ExcepcionTriangulo.class, () -> new Triangle(lado1, lado2, lado3));
        assertEquals("Los valores no forman un triángulo", result.getMessage());
    }
    @Test
    public void given_3doubles_when_createTriangle_then_notATriangle_test2() throws ExcepcionTriangulo{
        double lado1 = 3;
        double lado2 = 9;
        double lado3 = 2;
        ExcepcionTriangulo result = assertThrows(ExcepcionTriangulo.class, () -> new Triangle(lado1, lado2, lado3));
        assertEquals("Los valores no forman un triángulo", result.getMessage());
    }

    @Test
    public void given_3doubles_when_createTriangle_then_triangleEquilateral() throws ExcepcionTriangulo {
        double lado1 = 5;
        double lado2 = 5;
        double lado3 = 5;
        Triangle triangle = new Triangle(lado1, lado2, lado3);
        assertEquals("Equilátero", triangle.getTypeAccordingSide());
    }

    @Test
    public void given_3doubles_when_createTriangle_then_triangleIsosceles() throws ExcepcionTriangulo{
        double lado1 = 4;
        double lado2 = 4;
        double lado3 = 6;
        Triangle triangle = new Triangle(lado1, lado2, lado3);
        assertEquals("Isósceles", triangle.getTypeAccordingSide());
    }
    @Test
    public void given_3doubles_when_createTriangle_then_triangleScalenon() throws ExcepcionTriangulo{
        double lado1 = 3;
        double lado2 = 4;
        double lado3 = 5;
        Triangle triangle = new Triangle(lado1, lado2, lado3);
        assertEquals("Escaleno", triangle.getTypeAccordingSide());
    }
    @Test
    public void given_triangleEquilateral_when_getArea_then_OK()throws ExcepcionTriangulo {
        double lado1 = 5;
        double lado2 = 5;
        double lado3 = 5;
        Triangle triangle = new Triangle(lado1, lado2, lado3);
        double areaExpected = 10.82;
        double tolerance = 0.01;
        assertEquals(areaExpected, triangle.calculateArea(), tolerance );
    }

    @Test
    public void given_triangleIsosceles_when_getArea_then_OK()throws ExcepcionTriangulo {
        double lado1 = 4;
        double lado2 = 4;
        double lado3 = 6;
        Triangle triangle = new Triangle(lado1, lado2, lado3);
        double areaExpected = 7.93;
        double tolerance = 0.01;
        assertEquals(areaExpected, triangle.calculateArea(), tolerance );
    }

    @Test
    public void given_triangleScalenon_when_getArea_then_OK()throws ExcepcionTriangulo {
        double lado1 = 3;
        double lado2 = 4;
        double lado3 = 5;
        Triangle triangle = new Triangle(lado1, lado2, lado3);
        double areaExpected = 6;
        double tolerance = 0.01;
        assertEquals(areaExpected, triangle.calculateArea(), tolerance );
    }


}