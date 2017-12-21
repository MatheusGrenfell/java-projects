package seguranca.criptografiaSimetrica;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesCifer {

    //constante com a chave (precisa ter 8 d�gitos)
    private static final String password = "12345678";

    public static void main(String args[]) throws Exception {

        //cria uma entrada rand�mica  
        Set set = new HashSet();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Point point = new Point(random.nextInt(1000), random.nextInt(2000));
            set.add(point);
        }
        int last = random.nextInt(5000);

        //Cria a chave
        byte key[] = password.getBytes();
        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        //Cria uma inst�ncia do cifrador
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, secretKey);// modo encripta��o

        //cria um arquivo de sa�da
        FileOutputStream fos = new FileOutputStream("out.des");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //cria um output a partir do cifrador
        CipherOutputStream cos = new CipherOutputStream(bos, desCipher);
        ObjectOutputStream oos = new ObjectOutputStream(cos);

        //grava o conjunto de dados cifrado
        oos.writeObject(set);//grava objeto
        oos.writeInt(last);  //grava um int
        oos.flush();
        oos.close();

        //altera o modo do cifrador para DECRIPTAR
        desCipher.init(Cipher.DECRYPT_MODE, secretKey);

        //cria o canal de entrada
        FileInputStream fis = new FileInputStream("out.des");
        BufferedInputStream bis = new BufferedInputStream(fis);

        //cria o input a partir do cifrador
        CipherInputStream cis = new CipherInputStream(bis, desCipher);
        ObjectInputStream ois = new ObjectInputStream(cis);

        //l� o conjunto de dados
        Set set2 = (Set) ois.readObject();//l� objeto
        int last2 = ois.readInt();        //l� um int
        ois.close();

        //compara os dois objetos
        int count = 0;
        if (set.equals(set2)) {
            System.out.println("Set1: " + set);
            System.out.println("Set2: " + set2);
            System.out.println("Objeto lido est� OK");
            count++;
        }

        //compara os dois inteiros
        if (last == last2) {
            System.out.println("int1: " + last);
            System.out.println("int2: " + last2);
            System.out.println("Int lido est� OK");
            count++;
        }

        //verifica problemas
        if (count != 2) {
            System.out.println("Problemas durante a decripta��o.");
        }
    }
}
