public class strStr {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.startsWith(needle, i))
                return i;
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(strStr("butsad", "sad"));
    }
}
