import java.util.Scanner;

public class Atividade3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o primeiro termo da progressão aritimetica");
        double primTerm = in.nextDouble();
        System.out.println("Digite a posição do numero a ser achado");
        int numN = in.nextInt();
        System.out.println("Digite a razão da progressão aritimetica");
        double razao = in.nextDouble();
        double pA = primTerm + (razao * (numN - 1));
        System.out.println("O valor da posição " + numN + " da progressão aritimetica é " + pA);
    }
}
