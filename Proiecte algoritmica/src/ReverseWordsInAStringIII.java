import java.util.Arrays;

public class ReverseWordsInAStringIII {
    public static String reverseString(String s) {

        char[] str=s.toCharArray();
        for (int i=0;i<s.length()/2;i++)
        {
            char aux=str[i];
            str[i]=str[s.length()-1-i];
            str[s.length()-1-i]=aux;
        }
        return new String(str);
    }
    public static String reverseWords(String s) {
        String[] words=s.split(" ");
        String newString="";
        for (String word:words)
            newString+=reverseString(word)+" ";
        return newString.trim();
    }
    public static void main(String[] args){

        System.out.println(reverseWords("Let's go"));
    }
}
