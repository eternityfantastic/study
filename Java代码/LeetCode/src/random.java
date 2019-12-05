import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class random {
    String name;
    Integer i;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof random)) {
            return false;
        }
        random random = (random) o;
        return Objects.equals(name, random.name) && Objects.equals(i, random.i);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        new random().hashCode();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        Integer[] integers1 = new Integer[4];
        list.toArray(integers1);
        System.out.println(Arrays.toString(integers1));
    }
}
