import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

/*
    A ModalGR possui um cofre eletrônico que precisa estar protegido por 3 senhas, sendo
    essas criptografadas e armazenadas numa base de dados SQL. Cada uma dessas senhas deve
    possuir uma regra/método de criptografia distinta, mas ambas devem utilizar uma única
    chave secreta. Para isso, você foi escolhido para criar o sistema de criptografia dessas senhas.
    
    Chave secreta:  #modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista
    
    Observação: Codificar apenas a parte responsável pela criptografia das senhas, sem a
    necessidade da codificação de inclusão na base SQL.
*/


public class desafio1 {

    private static final String CHAVE_SECRETA = "#modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista";

    public static String criptografarSenha1(String senha) throws Exception {
        return criptografar(senha, 1);
    }

    public static String criptografarSenha2(String senha) throws Exception {
        return criptografar(senha, 2);
    }

    public static String criptografarSenha3(String senha) throws Exception {
        return criptografar(senha, 3);
    }

    private static String criptografar(String senha, int tipoSenha) throws Exception {
        byte[] salt = CHAVE_SECRETA.getBytes();
        int iteracoes = 65536;
        int comprimentoChave = 256;

        KeySpec keySpec = new PBEKeySpec(CHAVE_SECRETA.toCharArray(), salt, iteracoes, comprimentoChave);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] chaveRaw = factory.generateSecret(keySpec).getEncoded();
        SecretKey chaveSecreta = new SecretKeySpec(chaveRaw, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chaveSecreta);
        byte[] senhaCriptografada = cipher.doFinal(senha.getBytes());

        return Base64.getEncoder().encodeToString(senhaCriptografada);
    }

    public static void main(String[] args) {
        try {
            String senha1 = "ModalGR";
            String senha2 = "ModalGR Formação";
            String senha3 = "ModalGR Maior Empresa";

            String senhaCriptografada1 = criptografarSenha1(senha1);
            String senhaCriptografada2 = criptografarSenha2(senha2);
            String senhaCriptografada3 = criptografarSenha3(senha3);

            System.out.println("Senha 1 criptografada: " + senhaCriptografada1);
            System.out.println("Senha 2 criptografada: " + senhaCriptografada2);
            System.out.println("Senha 3 criptografada: " + senhaCriptografada3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
