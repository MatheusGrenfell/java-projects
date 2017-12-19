package Exe16;

public class CalculaSistuacao {

    public String getSistuacao(Notas notas, int numFaltas) {
        if (numFaltas > 15) {
            return "Reprovado por faltas";
        }
        if (notas.getNota1() < 0 || notas.getNota1() > 10) {
            return "Primeira nota inv�lida";
        }
        if (notas.getNota2() < 0 || notas.getNota2() > 10) {
            return "Segunda nota inv�lida";
        }
        if (notas.getNota3() < 0 || notas.getNota3() > 10) {
            return "Terceira nota inv�lida";
        }
        if (notas.getNota4() < 0 || notas.getNota4() > 10) {
            return "Quarta nota inv�lida";
        }
        double media = (notas.getNota1() + notas.getNota2() + notas.getNota3() + notas.getNota4()) / 4;
        if (media <= 5) {
            return "M�dia: " + media + ", situa��o: Reprovado";
        }
        if (media >= 5.1 && media <= 6.9) {
            return "M�dia: " + media + ", situa��o: Em exame";
        }
        if (media >= 7 && media <= 8.9) {
            return "M�dia: " + media + ", situa��o: Bom";
        }
        if (media >= 9 && media <= 9.9) {
            return "M�dia: " + media + ", situa��o: �timo";
        }
        return "M�dia: " + media + ", situa��o: Parab�ns";
    }
}
