package org.triangles;

public class Triangle {
    private double lado1;
    private double lado2;
    private double lado3;
    private String typeAccordingSide;

    public Triangle(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.typeAccordingSide = getType();
    }

    public String getType() {
        if (this.lado1 == this.lado2 && this.lado2 == this.lado3) {
            return "Equilátero";
        } else if (this.lado1 == this.lado2 || this.lado2 == this.lado3 || this.lado1 == this.lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public double getArea() {
        return 0;
    }
}
