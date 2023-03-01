import java.util.Scanner;

public class Tarefa5 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        float raio;
        System.out.println("Qual é o raio do circulo que deija caulcular?");
        raio = inp.nextFloat();
        double area = Math.pow(raio, 2) * Math.PI;
        System.out.println("A área do ciculo é " + area);
    }
}
