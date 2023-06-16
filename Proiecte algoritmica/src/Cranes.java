import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cranes {

    public static boolean HERE_COMES_THE_FUNCTION_HEADER(int[] a, int[] p, int b, int e){

        List<List<Integer>> puncte= new ArrayList<>();
        for (int i=0;i<a.length;i++)
        {
            if (p[i]-a[i]<=b && p[i]-a[i]<=e && p[i]+a[i]>=b && p[i]+a[i]>=e)
                return true;

            puncte.add(Arrays.asList(p[i]-a[i],p[i]+a[i]));

            List<Integer> copyToDelete=new ArrayList<>();
            List<Integer> copyToChange;

            for (List<Integer> setPuncte1 : puncte)
                for (List<Integer> setPuncte2 : puncte) {

                    if (puncte.indexOf(setPuncte2)<puncte.indexOf(setPuncte1))
                        continue;

                    if (setPuncte1.get(0) < setPuncte2.get(0) && setPuncte1.get(1) > setPuncte2.get(1))
                        copyToDelete=setPuncte2;

                    if (setPuncte1.get(0) > setPuncte2.get(0) && setPuncte1.get(1) < setPuncte2.get(1))
                        copyToDelete=setPuncte1;

                    if (setPuncte1.get(0)<setPuncte2.get(0) && setPuncte1.get(1)>=setPuncte2.get(0) && setPuncte1.get(1)<setPuncte2.get(1)) {
                        copyToChange = Arrays.asList(setPuncte1.get(0), setPuncte2.get(1));
                        puncte.set(puncte.indexOf(setPuncte1),copyToChange);
                        copyToDelete = setPuncte2;

                        if (copyToChange.get(0)<=b && copyToChange.get(0)<=e && copyToChange.get(1)>=b && copyToChange.get(1)>=e)
                            return true;

                    }
                    if (setPuncte1.get(0)>setPuncte2.get(0) && setPuncte1.get(0)<=setPuncte2.get(1) && setPuncte1.get(1)>setPuncte2.get(1)) {
                        copyToChange = Arrays.asList(setPuncte2.get(0), setPuncte1.get(1));
                        puncte.set(puncte.indexOf(setPuncte1),copyToChange);
                        copyToDelete = setPuncte2;

                        if (copyToChange.get(0)<=b && copyToChange.get(0)<=e && copyToChange.get(1)>=b && copyToChange.get(1)>=e)
                            return true;

                    }
                }
            puncte.remove(copyToDelete);

        }
        return false;
    }
    public static void main(String[] args) {

        int[] a={1,2,1,3};
        int[] p={3,5,1,12};

        System.out.println(HERE_COMES_THE_FUNCTION_HEADER(a,p,6,10));
    }
}
