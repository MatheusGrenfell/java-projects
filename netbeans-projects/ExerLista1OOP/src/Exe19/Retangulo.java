package Exe19;

public class Retangulo {

    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public String getArea() {
        return "�rea: " + (largura * altura);
    }

    public String getPerimetro() {
        return "Pe�metro: " + ((largura * 2) + (altura * 2));
    }
}
