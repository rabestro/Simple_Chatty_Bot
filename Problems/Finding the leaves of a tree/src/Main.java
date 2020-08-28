import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var edgesNumber = scanner.nextInt();

        final var edges = Stream
                .generate(() -> new Edge(scanner.nextInt(), scanner.nextInt()))
                .limit(edgesNumber)
                .collect(toSet());

        final var parents = edges.stream()
                .map(Edge::getParent)
                .collect(toSet());

        final var leaves = edges.stream()
                .map(Edge::getChild)
                .filter(not(parents::contains))
                .distinct()
                .sorted()
                .map(String::valueOf)
                .collect(toList());

        System.out.println(leaves.size());
        System.out.println(String.join(" ", leaves));
    }
}

class Edge {
    final int parent;
    final int child;

    Edge(final int parent, final int child) {
        this.parent = parent;
        this.child = child;
    }

    int getParent() {
        return parent;
    }

    int getChild() {
        return child;
    }
}