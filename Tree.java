import java.util.stream.Stream;

public class Tree {

    private int size;
    public Tree(int size) {
        this.size = size;
    }

    private String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    public Stream<String> get() {
        return Stream.concat(Stream.of(
        padLeft("+", size + 1)),
            Stream.of(padLeft("|||", size + 2)));
    }

    public static void main(String[] args) {
        var tree = new Tree(8);
        tree.get().forEach(System.out::println);
    }
}