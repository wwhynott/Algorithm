import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int max = Integer.MIN_VALUE;
        int num = 0;

        for (int i=0; i<9; i++) {
            int x =  Integer.parseInt(br.readLine());
            arr[i] = x;
        }

        for (int i=0; i<9; i++) {
            if (arr[i] > max) {
                max = arr[i];
                num = i;
            }
        }

        System.out.println(max);
        System.out.println(num+1);

    }
}