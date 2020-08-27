import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var nodesNumber = scanner.nextInt();
        final var nodes = scanner.tokens().mapToInt(Integer::parseInt).toArray();
        final var tree = new Tree(nodes);

        final var maxDeep = IntStream.range(0, nodesNumber).map(tree::getDeep).max().orElse(0);

        System.out.println(maxDeep);
    }
}

class Tree {
    private final int[] nodes;
    private final int[] deeps;

    Tree(final int[] nodes) {
        this.nodes = nodes;
        deeps = new int[nodes.length];
    }

    int getDeep(final int i) {
        if (deeps[i] > 0) {
            return deeps[i];
        }
        deeps[i] = nodes[i] == -1 ? 1 : 1 + getDeep(nodes[i]);
        return deeps[i];
    }
}