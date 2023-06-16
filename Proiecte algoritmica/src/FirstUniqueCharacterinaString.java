public class FirstUniqueCharacterinaString {
    public static int firstUniqChar(String s) {
        if (s.length() == 1)
            return 0;
        int rezult = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int index1 = s.indexOf(c);
            int index2 = s.lastIndexOf(c);
            if (index2 != -1 && index1 == index2)
                if (rezult > index1)
                    rezult = index1;
        }
        if (rezult != Integer.MAX_VALUE)
            return rezult;
        return -1;
    }

    public static void main(String[] args) {
        String s = "letcod";
        System.out.println(firstUniqChar(s));

    }
}
