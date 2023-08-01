import examples.Example;
import examples.dayxtra.DeyxtraStack;

public class Main {
    public static void main(String[] args) {
        Example first = new DeyxtraStack();
        var simple = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        var withSqrt = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )";
        var result = first.run(withSqrt);
        System.out.println(result);

    }
}