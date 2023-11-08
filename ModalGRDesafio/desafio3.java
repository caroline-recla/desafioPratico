package ModalGRDesafio;
import java.util.*;
public class desafio3{
    
    public static void notasMaiorValor(int emprestimo){
        System.out.println("Notas de maior valor: ");
        int notas100 = emprestimo/100;
        int notas50 = (emprestimo%100)/50;
        int notas20 = (emprestimo%50)/20;
        int notas10 = (emprestimo%20)/10;
        int notas5 = (emprestimo%10)/5;
        int notas2 = (emprestimo%5)/2;
        System.out.println(""+notas100+" X 100 reais;");
        if(notas50 != 0){
         System.out.println(""+notas50+" X 50 reais.");   
        }
        if(notas20 != 0){
          System.out.println(""+notas20+" X 20 reais;");
        }
        if(notas10 != 0){
          System.out.println(""+notas10+" X 10 reais.");  
        }
        if(notas5 != 0){
          System.out.println(""+notas5+" X 5 reais.");
        }
        if(notas2 != 0){
          System.out.println(""+notas2+" X 2 reais.");
        }
    }
    
    public static void notasMenorValor(int emprestimo){
        System.out.println("Notas de menor valor: ");
        int notas20 = emprestimo/20;
        int notas10 = (emprestimo%20)/10;
        int notas5 = (emprestimo%10)/5;
        int notas2 = (emprestimo%5)/2;
        System.out.println(""+notas20+" X 20 reais;");
        if(notas10 != 0){
          System.out.println(""+notas10+" X 10 reais.");  
        }
        if(notas5 != 0){
          System.out.println(""+notas5+" X 5 reais.");
        }
        if(notas2 != 0){
          System.out.println(""+notas2+" X 2 reais.");
        }
    }
    public static void notasMeioAMeio(int emprestimo){
      int metadeValor = emprestimo/2;
      System.out.println("Notas meio a meio: ");
      System.out.println(metadeValor+" em notas de maior valor");
      notasMaiorValor(metadeValor);
      System.out.println(metadeValor+" em notas de menor valor");
      notasMenorValor(metadeValor);
    }
    
    
    
    public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Digite seu nome:");
    String nome = scan.nextLine();
    
    System.out.println("Digite a quantos anos você trabalha nesta empresa:");
    int admissao = scan.nextInt();
    
    System.out.println("Digite seu salário atual (valor inteiro):");
    int salario = scan.nextInt();

    if(admissao>5){
      int emprestimo = scan.nextInt();
      if(emprestimo > 0 && emprestimo <= 2 * salario && emprestimo % 2 == 0){
          System.out.println("Valor do Empréstimo: \n"+ emprestimo);

          notasMaiorValor(emprestimo);
          
          System.out.println("");
          
          notasMenorValor(emprestimo);
          
          System.out.println("");
          
          notasMeioAMeio(emprestimo);
      }else{
        System.out.println("Insira um valor de empréstimo válido (maior que 0, par e até duas vezes o salário).");
      }
        
      
    }else{
      System.out.println("Agradecemos seu interesse, mas você não atende os requisitos mínimos do programa");
    }
    }
}
