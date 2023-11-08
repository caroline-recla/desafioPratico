import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
  A ModalGR possui um arquivo texto contendo o nome completo, e-mail e data de
  nascimento de seus consultores, separados por pipeline (|). O time de RH deseja que todo
  início de cada mês seja gerado um novo arquivo texto com apenas os dados dos
  aniversariantes do mês corrente, para assim, enviarem uma mensagem personalizada de
  felicitações. Você foi escolhido para criar uma solução que atenda esses quesitos.
*/

public class desafio2 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("//uploads/consultores.txt"));

        ArrayList<Aniversariante> aniversariantes = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split("|");

            Aniversariante anivers = new Aniversariante();
            anivers.nome = dados[0];
            anivers.email = dados[1];
            anivers.dataNascimento = new Date(dados[2]);

            Date hoje = new Date();
            int mesAtual = hoje.getMonth();
            int mesNascimento = anivers.dataNascimento.getMonth();
            if (mesAtual == mesNascimento) {
                aniversariantes.add(anivers);
            }
        }

        scanner.close();

        PrintWriter writer = new PrintWriter("aniversariantes.txt");

        for (Aniversariante anivers : aniversariantes) {
            writer.println(anivers.nome + "|" + anivers.email);
        }

        writer.close();
    }
}

class Aniversariante {

    public String nome;
    public String email;
    public Date dataNascimento;

    public Aniversariante() {
    }
}
