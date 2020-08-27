import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // put your code here
        final var scanner = new Scanner(System.in);
        final var nodesNumber = scanner.nextInt();
        final var nodes = scanner.tokens().mapToInt(Integer::parseInt).toArray();

        IntUnaryOperator getDeep = (int index) -> {
            int deep = 1;
            for (int i = index; nodes[i] != -1; i = nodes[i]) {
                ++deep;
            }
            return deep;
        };
        final var maxDeep = IntStream.range(0, nodesNumber).map(getDeep).max().orElse(0);

        System.out.println(maxDeep);
    }
}