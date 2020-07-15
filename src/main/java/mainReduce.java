import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mainReduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 4, 10, 1, 3);
        int result = numbers.stream()
                            .reduce(0, (subtotal,item)->subtotal+item);

        System.out.println(result);
    }
}
