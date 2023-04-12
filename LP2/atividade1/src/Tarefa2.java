public class Tarefa2 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int d;
        System.out.println("A=" + a + "\nB=" + b + "\nC=" + c);
        d = a;
        a = c;
        c = b;
        b = d;

        System.out.println("\nA=" + a + "\nB=" + b + "\nC=" + c);
    }
}
