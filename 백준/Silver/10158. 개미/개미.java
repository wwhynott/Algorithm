import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 격자 공간
        StringTokenizer areaToken = new StringTokenizer(br.readLine());
        // 개미 초기 위치
        StringTokenizer antToken = new StringTokenizer(br.readLine());
        // 개미가 움직일 시간
        int T = Integer.parseInt(br.readLine());

        // 격자 공간 배열 설정
        int w = Integer.parseInt(areaToken.nextToken());
        int h = Integer.parseInt(areaToken.nextToken());

        // 개미 초기 좌표
        int r = Integer.parseInt(antToken.nextToken());
        int c = Integer.parseInt(antToken.nextToken());

        int R = (T+r) % w;
        int C = (T+c) % h;

        // 가로 좌표
        // (T+r)/w가 홀수일때
        if (((T+r)/ w) % 2 != 0) {
            R = w-R;
        } 
        // 세로 좌표
        // (T+c)/h가 홀수일때
        if (((T+c)/h) % 2 != 0) {
            C = h-C;
        }

        System.out.printf("%d %d", R, C);
    }
}