import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tarefa1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Digite um numero");
        nums.add(inp.nextInt());
        System.out.println("Digite um numero novamente");
        nums.add(inp.nextInt());
        System.out.println("Digite um numero novamente");
        nums.add(inp.nextInt());
        Collections.reverse(nums);
        System.out.println(nums);
    }
}
