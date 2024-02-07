package org.triangles;

import java.io.IOException;
import java.util.List;
import java.util.logging.*;

public class Triangle {
    private double lado1;
    private double lado2;
    private double lado3;
    private String typeAccordingSide;

    private final static Logger LOGGER = Logger.getLogger("org.triangles");

    public Triangle(double lado1, double lado2, double lado3) throws ExcepcionTriangulo {
        if (isTriangle(lado1, lado2, lado3)) {
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
            this.typeAccordingSide = determinateType();
            logException();
        } else {
            logException(new ExcepcionTriangulo("Los valores no forman un triángulo"));
            throw new ExcepcionTriangulo("Los valores no forman un triángulo");
        }
    }

    private void logException(){
        try {
            Handler fileHandler = new FileHandler("/Users/colchita/Projects/TrianglesCalculator/excepciones.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());

            LOGGER.addHandler(fileHandler);
            fileHandler.setLevel(Level.ALL);

            LOGGER.log(Level.FINE, "CREACION EXITOSA Triangulo " + this.typeAccordingSide);
            fileHandler.close();

        }catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
        }

    }
    private void logException(Exception notTriangle){
        try {
            Handler fileHandler = new FileHandler("/Users/colchita/Projects/TrianglesCalculator/excepciones.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());

            LOGGER.addHandler(fileHandler);
            fileHandler.setLevel(Level.ALL);

            LOGGER.log(Level.SEVERE, "TRIANGULO NO CREADO",notTriangle.getMessage());
            fileHandler.close();

        }catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
        }

    }

    private boolean isTriangle(double lado1, double lado2, double lado3){
        return (lado1 + lado2) > lado3 && (lado1 + lado3) > lado2 && (lado2 + lado3) > lado1;
    }
    public String determinateType() {
        if (this.lado1 == this.lado2 && this.lado2 == this.lado3) {
            return "Equilátero";
        } else if (this.lado1 == this.lado2 || this.lado2 == this.lado3 || this.lado1 == this.lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public String getTypeAccordingSide(){
        return this.typeAccordingSide;
    }

    public double calculateArea() {
        double semiPerimeter = (this.lado1 + this.lado2 + this.lado3) / 2;
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - this.lado1) * (semiPerimeter - this.lado2) * (semiPerimeter - this.lado3));
        return Math.floor(area*100)/100;
    }
}
