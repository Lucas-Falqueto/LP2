import java.util.Scanner;

public class Atividade1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Escreva a temperatura em Farenheit que deseja converter para graus Centigrados");
        double tempF = inp.nextDouble();
        double tempC = (5 / 9) * (tempF - 32);
        System.out.println("A temperatura em Farenheit " + tempC);

    }
}
