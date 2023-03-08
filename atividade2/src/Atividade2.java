import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva uns dados referentes ao pneu de um automóvel");
        System.out.println("Pressão");
        double p = in.nextDouble();
        System.out.println("Volume");
        double v = in.nextDouble();
        System.out.println("Temperatura");
        double t = in.nextDouble();
        double massaPneu = (p * v + 0.37 * 460) / (0.37 * t);
        System.out.println("A massa de ar desse pneu " + massaPneu);
    }
}
