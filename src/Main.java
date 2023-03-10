import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer>0;
            }
        };

        Predicate<Integer> predicate1 = integer -> integer>0;
        //Задание 2
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> consumer1 = s -> System.out.println(s);

        //Задание 3.
        Function<Double,Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };

        Function<Double,Long> function1 = Double::longValue;
        //Задание 4
        Supplier<Double> supplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random()*100;
            }
        };
        Supplier<Double> supplier1 = () -> Math.random()*100;

        Function<Integer, String> checkEven = ternaryOperator(
                n -> n == 0,
                n -> "равен нулю",
                n -> "не равен нулю"
        );
        System.out.println(checkEven.apply(0));
    }
        //Задание 5
        public static <T, U> Function<T, U> ternaryOperator(
                Predicate<? super T> condition,
                Function<? super T, ? extends U> ifTrue,
                Function<? super T, ? extends U> ifFalse) {
            return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
        }

}