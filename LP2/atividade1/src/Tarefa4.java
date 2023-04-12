import java.util.Scanner;

public class Tarefa4 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String nome;
        int idade;
        System.out.println("Como é seu nome?");
        nome = inp.nextLine();
        System.out.println("Qual é sua idade?");
        idade = inp.nextInt();
        idade = idade * 365;
        System.out.println("Olá " + nome + " você possui aproximadamente " + idade + " dias de idade");
    }
}
