package menorDistanciaPontos;

public class Sistema {

    public static void main(String[] args) {
        /* Maior Dist�ncia
        
        Seguindo a solu��o que fiz abaixo para calcular a menor dist�ncia,
        para calcular a maior dist�ncia seria apenas alterar o m�todo
        calcular(), alterando as seguintes linhas:
        
        double menorDistancia = Double.MAX_VALUE - para - double maiorDistancia = Double.MIN_VALUE 
        e 
        if (distCalculada < menorDistancia) - para - if (distCalculada > maiorDistancia)
        e
        menorDistancia = distCalculada; - para - maiorDistancia = distCalculada;*/

        // Solu��o menor dist�ncia
        MenorDistanciaPontos menorDistancia = new MenorDistanciaPontos();
        menorDistancia.addPonto(new Ponto(4, 5));
        menorDistancia.addPonto(new Ponto(3, 1));
        menorDistancia.addPonto(new Ponto(2, 3));
        menorDistancia.addPonto(new Ponto(0, 2));
        menorDistancia.addPonto(new Ponto(5, 4));
        menorDistancia.addPonto(new Ponto(5, 2));
        menorDistancia.addPonto(new Ponto(1, 5));
        menorDistancia.addPonto(new Ponto(2, 4));
        menorDistancia.addPonto(new Ponto(4, 0));
        menorDistancia.addPonto(new Ponto(0, 0));
        System.out.println("Menor Dist�ncia:");
        System.out.println(menorDistancia.calcular());
    }
}
