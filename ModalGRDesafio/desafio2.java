import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
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
        Scanner scanner = new Scanner(new File("C:\\Users\\Vs Studio\\Desktop\\consultores.txt"));

        ArrayList<Aniversariante> aniversariantes = new ArrayList<>(); // Certifique-se de ter essa lista definida antes do loop, se não a declarou.

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split("\\|");

            Aniversariante anivers = new Aniversariante();
            anivers.nome = dados[0];
            anivers.email = dados[1];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataNascimento = LocalDate.parse(dados[2].trim(), formatter);
            anivers.dataNascimento = dataNascimento;

            LocalDate hoje = LocalDate.now();
            int mesAtual = hoje.getMonthValue();
            int mesNascimento = anivers.dataNascimento.getMonthValue();

            if (mesAtual == mesNascimento) {
                aniversariantes.add(anivers);
            }
        }


        scanner.close();

        PrintWriter writer = new PrintWriter("C:\\Users\\Vs Studio\\Desktop\\aniversariantes.txt");

        for (Aniversariante anivers : aniversariantes) {
            writer.println(anivers.nome + "|" + anivers.email);
        }

        writer.close();
    }
}

class Aniversariante {

    public String nome;
    public String email;
    public LocalDate dataNascimento;

    public Aniversariante() {
    }
}
