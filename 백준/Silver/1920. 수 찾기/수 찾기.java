import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        // N
        int N = Integer.parseInt(br.readLine());
        StringTokenizer nToken = new StringTokenizer(br.readLine());
        int[] nArr = new int[N];
        for (int i=0; i<N; i++) {
            nArr[i] = Integer.parseInt(nToken.nextToken());
        }
        
        // M
        int M = Integer.parseInt(br.readLine());
        StringTokenizer mToken = new StringTokenizer(br.readLine());
        int[] mArr = new int[M];
        for (int i=0; i<M; i++) {
            mArr[i] = Integer.parseInt(mToken.nextToken());
        }
        
        // M 배열 하나씩 돌면서
        // N은 이진 탐색
        // 이진 탐색을 위해 N 보관배열 정렬
        // 카운팅 정렬?
        // => 노노...... 정수 범위가 -2^31 부터 2^31 ;;;
        // 그냥 sort 메소드 고고?
        Arrays.sort(nArr);
        
        
        // Arrays.binarySearch 메소드가 있다...
        for (int i=0; i<M; i++) {
            int idx = Arrays.binarySearch(nArr, mArr[i]);
            if (idx < 0) {
                sb.append(0+"\n");
            } else {
                sb.append(1+"\n");
            }
        }
        
        System.out.println(sb);
    }
}
