import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tree {
    private int size;
    private double baubleProbability = 0.3;
    public Tree(int size) {
        this.size = size;
    }

    private String tile() {
        if (Math.random() < baubleProbability) {
            return "O";
        }
        return "x";
    }

    private String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    private String layer(int i) {
        return IntStream.range(1, i)
            .mapToObj(pos -> tile())
            .collect(Collectors.joining(""));
    }

    private Stream<String> branches() {
        return IntStream.range(1, size + 1)
            .mapToObj(i -> padLeft(layer(i), size - 1)
            + layer(i + 1)
            );
    }

    public Stream<String> get() {
        var tip = Stream.of(padLeft("+", size));
        var trunk = Stream.of(padLeft("|||", size + 1));
        return Stream.concat(Stream.concat(
            tip,
            branches()),
            trunk);
    }

    public static void main(String[] args) {
        var tree = new Tree(8);
        tree.get().forEach(System.out::println);
    }
}