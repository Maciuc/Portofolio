import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {

        Map<Character,Integer> romansLetter=new HashMap<>();
        romansLetter.put('I',1);
        romansLetter.put('V',5);
        romansLetter.put('X',10);
        romansLetter.put('L',50);
        romansLetter.put('C',100);
        romansLetter.put('D',500);
        romansLetter.put('M',1000);
        romansLetter.put('Y',0);
        s=s+"Y";

        int sum=0;
        for (int i=0;i<s.length()-1;i++)
        {
            Character nextChar=s.charAt(i+1);
            Character currentChar=s.charAt(i);

            if (romansLetter.get(nextChar)>romansLetter.get(currentChar))
            {
                sum += romansLetter.get(nextChar)-romansLetter.get(currentChar);
                i++;
            }
            else
                sum+=romansLetter.get(currentChar);
        }
        return sum;
    }


    public static void main(String[] args) {

        System.out.println(romanToInt("MMCDIX"));
    }
}
