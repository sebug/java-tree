import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tree {

    private int size;
    public Tree(int size) {
        this.size = size;
    }

    private String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    public String layer(int i) {
        return IntStream.range(1, i)
            .mapToObj(pos -> "x")
            .collect(Collectors.joining(""));
    }

    public Stream<String> branches() {
        return IntStream.range(1, size)
            .mapToObj(i -> padLeft(layer(i), size)
            + layer(i + 1)
            );
    }

    public Stream<String> get() {
        return Stream.concat(Stream.concat(Stream.of(
        padLeft("+", size + 1)),
        branches()),
            Stream.of(padLeft("|||", size + 2)));
    }

    public static void main(String[] args) {
        var tree = new Tree(8);
        tree.get().forEach(System.out::println);
    }
}