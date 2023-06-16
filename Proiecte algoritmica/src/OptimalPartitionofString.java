import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionofString {
    static int partitionString(String s) {

        Set<Character> letter=new HashSet<>();
        int rezult=1;
        for (int i = 0; i < s.length(); i++)
        {
            if (!letter.add(s.charAt(i)))
            {
                letter.clear();
                letter.add(s.charAt(i));
                rezult++;
            }
        }
        return rezult;
    }

    public static void main(String[] args) {

        System.out.println(partitionString("ss"));
    }
}
