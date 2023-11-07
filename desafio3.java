import java.util.*;
public class desafio3{
    
    public static void notasMaiorValor(int emprestimo){
        System.out.println("Notas de maior valor: ");
        int notas100 = emprestimo/100;
        System.out.println(""+notas100+" X 100 reais;");
        int notas50 = (emprestimo%100)/50;
        System.out.println(""+notas50+" X 50 reais.");
    }
    
    public static void notasMenorValor(int emprestimo){
        System.out.println("Notas de menor valor: ");
        int notas20 = emprestimo/20;
        System.out.println(""+notas20+" X 20 reais;");
        int notas10 = (emprestimo%20)/10;
        System.out.println(""+notas10+" X 10 reais.");
        int notas5 = (emprestimo%10)/5;
        System.out.println(""+notas5+" X 5 reais.");
        int notas2 = (emprestimo%5)/2;
        System.out.println(""+notas2+" X 2 reais.");
    }
    public static void notasMeioAMeio(int emprestimo){
      
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
      if(emprestimo<=(2*salario)){
        if(emprestimo%2 == 0){
          System.out.println("Valor do Empréstimo: \n"+ emprestimo);

          notasMaiorValor(emprestimo);
          
          System.out.println("");
          
          notasMenorValor(emprestimo);
          
          
          
        }
      }else{
        System.out.println("Insira um valor válido!");
      }
        
      
    }else{
      System.out.println("Agradecemos seu interesse, mas você não atende os requisitos mínimos do programa");
    }
    }
}
