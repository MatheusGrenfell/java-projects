package Exe30;

public class Triangulo {

    private double lado1, lado2, lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public String getTriangulo() {
        if (lado1 < lado2 + lado3 && lado2 < lado1 + lado3 && lado3 < lado1 + lado2) {
            if (lado1 == lado2 && lado1 == lado3) {
                return "Triangulo eq�il�tero";
            }
            if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                return "Triangulo is�sceles";
            }
            return "Triangulo escaleno";

        }
        return "N�o � um tri�ngulo";
    }
}
