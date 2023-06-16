public class iTecProbleme {

    public int solution(int[] A, int[] B, int X, int Y) {
        int sum = 0;
        char poz;
        if (A[0] < B[0]) {
            sum += A[0];
            poz = 'A';
        } else {
            sum += B[0];
            poz = 'B';
        }
        for (int i = 0; i < A.length-1; i++) {
            if (poz == 'A') {
                if (A[i + 1] < X + B[i + 1] + Y )
                    sum += A[i + 1];
                else {
                    sum += X + B[i + 1];
                    poz = 'B';
                }
                continue;
            }
            if (poz == 'B')
                if (B[i + 1] < Y + A[i + 1] + X )
                    sum += B[i + 1];
                else {
                    sum += Y + A[i + 1];
                    poz = 'A';
                }
        }
        return sum;
    }
    public static void main(String[] args){
        char a='a';
        char b='b';
        char temp=a;
        a=b;
        b=temp;
        System.out.println(a);

    }
}



/*
class Solution {
    public int solution(int[] A) {
        int maxx=0;
        int sum=0;
        for (int i=0;i<A.length;i++){
            if (A[i]>=0)
                sum+=A[i];

            else
            {
                if (maxx<sum)
                    maxx=sum;
                sum=0;
            }
            if (i==A.length-1)
                if (maxx<sum)
                    maxx=sum;
        }
        if (maxx!=0)
            return maxx;
        return -1;
    }
}*/

/*
import java.util.HashSet;
        import java.util.Set;

class Solution {
    public int solution(int[] A) {

        if (A.length == 2) {
            if (A[0] == A[1])
                return A[0] + A[1];
            else
                return -1;
        }
        Set<Integer> elParcurse = new HashSet<>();
        int maxx = 0;
        for (int i = 0; i < A.length - 1; i++)
            if (elParcurse.add(A[i])) {
                int pozFinal = A.length - 1;

                while (A[pozFinal] != A[i])
                    pozFinal--;

                if (pozFinal == i)
                    continue;

                int sum = 0;
                for (int j = i; j <= pozFinal; j++)
                    sum += A[j];

                if (sum > maxx)
                    maxx = sum;
            }

        if (maxx != 0)
            return maxx;
        return -1;
    }
}*/
