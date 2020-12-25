import java.util.stream.Stream;

public class Tree {

    private int size;
    public Tree(int size) {
        this.size = size;
    }

    public Stream<String> get() {
        return Stream.concat(Stream.of("+"),
            Stream.of("|||"));
    }

    public static void main(String[] args) {
        var tree = new Tree(8);
        tree.get().forEach(System.out::println);
    }
}