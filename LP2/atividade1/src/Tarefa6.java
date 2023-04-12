import java.util.Scanner;

public class Tarefa6 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        double alt, comp;
        System.out.println("Digite a altura");
        alt = inp.nextDouble();
        System.out.println("Digite a comprimento");
        comp = inp.nextDouble();
        double area = comp * alt;
        double comsulTinta = area * 300;
        int lataTinta = (int) (comsulTinta / 2000);
        System.out.println("A quantidade de lata de tinta a ser usada é aproximandamente " +
                lataTinta);
    }
}
