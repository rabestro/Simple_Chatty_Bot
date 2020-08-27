import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var nodesNumber = scanner.nextInt();
        final var nodes = scanner.tokens().mapToInt(Integer::parseInt).toArray();

        final IntUnaryOperator getDeep = index ->
                (int) IntStream.iterate(index, i -> nodes[i] > -1, i -> nodes[i]).count() + 1;

        final var maxDeep = IntStream.range(0, nodesNumber).map(getDeep).max().orElse(0);

        System.out.println(maxDeep);
    }
}