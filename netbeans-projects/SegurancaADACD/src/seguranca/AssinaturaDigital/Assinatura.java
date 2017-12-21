package seguranca.AssinaturaDigital;

import java.security.*;

public class Assinatura {

    public static void main(String[] args) {
        //define as vari�veis
        KeyPairGenerator chaves = null;
        Signature sgn = null;
        Signature vrf = null;
        byte[] assina = null;

        //define uma mensagem
        String mensagem = "teste teste";
        /*    for(int i = 0; i < args.length; i++)
         mensagem = mensagem + " " + args[i];    */

        try {
            //cria uma inst�ncia do gerador de chaves 
            chaves = KeyPairGenerator.getInstance("DSA");

            //cria uma inst�ncia do DSA
            sgn = Signature.getInstance("DSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //inicializa e gera as chaves
        chaves.initialize(512);
        System.out.println("Gerando o par de chaves...");
        KeyPair par = chaves.generateKeyPair(); //gera as chaves        
        PrivateKey priv = par.getPrivate();   //obtem chave privada
        PublicKey pub = par.getPublic();  //obtem chave p�blica

        try {
            sgn.initSign(priv); //inicializa o algoritmo de assinatura

            //adiciona a mensagem ao algoritmo
            sgn.update(mensagem.getBytes());

            //faz a assinatura
            assina = sgn.sign();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sa�das parte de assinatura
        System.out.println("Chave privada: " + priv);
        System.out.println("Chave p�blica: " + pub);
        
        System.out.println("tamanho privada: " + priv.getEncoded().length);
        System.out.println("tamanho p�blica: " + pub.getEncoded().length);
        
        System.out.println("Mensagem: " + mensagem);
        System.out.print("Assinatura da mensagem: ");
        for (int i = 0; i < assina.length; i++) {
            System.out.print((assina[i] + 128) + " ");
        }
        System.out.println("");
        System.out.println("Tamanho da mensagen assinada: " + assina.length);

        boolean ok;

        //inicia a verifica��o
        try {
            // cria uma inst�ncia do DAS
            vrf = Signature.getInstance("DSA");

            //inicializa uma verifica��o com a chave p�blica do par�metro
            vrf.initVerify(pub);

            //adiciona o texto ao algoritmo
            vrf.update(mensagem.getBytes());

            //faz a verifica��o com a assinatura do par�metro
            ok = vrf.verify(assina);

            //sa�da da parte de verifica��o
            System.out.println("Validou: " + ok);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
