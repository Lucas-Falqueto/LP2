import java.util.Scanner;

public class Tarefa3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String nome;
        System.out.println("Olá eu sou o Nº 1, como é seu nome?");
        nome = inp.nextLine();
        System.out.println("Bem-vindo ao clube " + nome);
    }
}
