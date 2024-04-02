import java.util.*;

public class HelloEveryone {
    public static void main(String[] args)
    {
        ArrayList<Integer> ls=new ArrayList<>();
        Stack<Integer> nl=new Stack<>();

        nl.push(1);

        ls.add(5);
        ls.add(8);
        ls.add(19);

        ls.remove(2);
        ls.add(2,2);
        System.out.println(nl);
        System.out.println("Hello World");
    }
}
