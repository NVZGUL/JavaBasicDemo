import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        HashSet<TestObj> hashSet = new HashSet<>();
        List<TestObj> lst = Arrays.asList(
                new TestObj(1,"Slava", 5),
                new TestObj(2,"Slava1", 10),
                new TestObj(10,"Slava", 5)
        );
        for (TestObj i : lst) {
            if (hashSet.contains(i)) {
                System.out.println("Object alredy exist in set " + i);
            }
            else {
                hashSet.add(i);
            }
        }
        System.out.println(hashSet);
    }

}
