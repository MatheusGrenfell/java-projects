package View;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exe2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Jogo da forca");
        String palavra = JOptionPane.showInputDialog(null, "Entre com uma palavra", "Entrada", JOptionPane.INFORMATION_MESSAGE);
        if (palavra != null) {
            String tentativas = JOptionPane.showInputDialog(null, "Entre com o n�mero de tentativas", "Entrada", JOptionPane.INFORMATION_MESSAGE);
            if (tentativas != null) {
                int numTentativas = Integer.parseInt(tentativas);//N�mero de tentativas para tentar certar a palavra
                char[] vetAux = new char[palavra.length()];//caracteres que ser�o exibidos na tela
                int[] indice;//indice onde se encontra a letra para ser substituida
                for (int i = 0; i < palavra.length(); i++) {
                    vetAux[i] = 'x';
                    System.out.print("x");
                }
                System.out.println();
                char letra;
                char[] vet;
                boolean encontrouLetra;//flag letra digitada encontrada
                boolean acertouForca = true;//flag verificar t�rmino
                for (int i = 0; i < numTentativas; i++) {
                    encontrouLetra = false;
                    indice = new int[palavra.length()];//novo vet de �ndice
                    System.out.println("Entre com uma letra, " + (i + 1) + "� tentativa ");
                    letra = scan.next().charAt(0);//leitura somente uma letra
                    if (letra == '?') {//? n�o pode ser usada pois � usada para substituir letra encontrada na palavra
                        System.out.println("Letra n�o encontrada");
                        acertouForca = false;
                        continue;
                    }
                    vet = palavra.toCharArray();
                    for (int y = 0; y < vet.length; y++) {//verifica letra a letra
                        if (vet[y] == letra) {
                            vet[y] = '?';//substitui letra por ?
                            indice[y] = 1;//seta a posi��o a ser trocada
                            encontrouLetra = true;//encontrou uma letra
                        }
                    }
                    palavra = "";
                    for (int j = 0; j < vet.length; j++) {//atualiza palavra
                        palavra += vet[j];
                    }
                    if (!encontrouLetra) {
                        System.out.println("Letra n�o encontrada");
                    } else {
                        for (int y = 0; y < indice.length; y++) {//atualiza caracteres que ser�o exibidos na tela, substitui x pela letra detectada atrav�s �ndice setado
                            if (indice[y] == 1) {
                                vetAux[y] = letra;
                            }
                        }
                        acertouForca = true;
                        for (int y = 0; y < vetAux.length; y++) {//exibe na console com as respectivas letras atualizadas
                            System.out.print(vetAux[y]);
                            if (vetAux[y] == 'x') {//se encontrar um x ainda n�o terminou
                                acertouForca = false;
                            }
                        }
                        System.out.println();
                        if (acertouForca) {//fim
                            System.out.println("Voc� acertou");
                            break;
                        }
                    }
                }
                if (!acertouForca) {//tempo limite
                    System.out.println("Tempo limite esgotado, tente novamente");
                }
            }
        }
    }
}
