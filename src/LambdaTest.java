import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class LambdaTest {

    private Scanner in;

    public LambdaTest() {
        this.in = new Scanner(System.in);
    }

    public String pobierzDane() {
        System.out.println("Podaj dane: ");
        return in.nextLine();
    }

    public static void main(String[] args) {

        LambdaTest lt = new LambdaTest();

        List<String> listString = Arrays.asList(
                lt.pobierzDane(),
                lt.pobierzDane(),
                lt.pobierzDane(),
                lt.pobierzDane()
        );

        listString.sort(Comparator.comparing(ar1 -> ar1.length(), Comparator.reverseOrder()));
        //listString.sort((Comparator.comparing(String::length).reversed()));
        System.out.println(listString);

        Object klasaInstancja = new Object();
        IntSupplier equalsOnObj = klasaInstancja::hashCode;
        System.out.println(equalsOnObj.getAsInt());

        Supplier<Object> klasaInstancja2 = Object::new;
        System.out.println(klasaInstancja2.get());

        BiFunction<Integer, String, Human> biFunc = Human::new;
        Human h1 = biFunc.apply(5, "ALA");
        System.out.println(h1.getAge() + " " + h1.getName());

    }
}
