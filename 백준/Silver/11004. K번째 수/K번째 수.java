
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		qSort(0, N-1);
		
		System.out.println(arr[K-1]);

	}

	static void qSort(int l, int r) {
		if (l < r) {
			int pivot = partition(l, r);
			/* 
			 * 1. pivot == K-1(인덱스라서 -1 해줌) 인 경우 -> 작업 진행필요 x
			 * 2. pivot > K-1 -> 오른쪽만 sort 진행
			 * 3. pivot < K-1 -> 왼쪽만 sort 진행
			 * */
			if (pivot == K-1) {
				return;
			} else if (pivot > K-1) {
				qSort(l, pivot-1);
			} else {
				qSort(pivot+1, r);
			}
		}
	}

	static int partition(int l, int r) {
		// 데이터가 2개인 경우는 바로 비교하여 정렬?
        if(l+1 == r) {
            if(arr[l] > arr[r]) swap(l, r);
            return r;
        }
		
		// 중앙값을 피봇으로 설정?
		int M = (l+r)/2;
		swap(l, M);
		
		// 가장 왼쪽의 값이 피봇
		int pivot = arr[l];

		// 피봇 한칸 뒤부터 시작
		int nl = l + 1;
		int nr = r;

		while (nl <= nr) {
			// nl : 피봇보다 큰 값 찾을때까지 이동
			while (nl <= r && arr[nl] < pivot)
				nl++;
			// nr : 피봇보다 작거나 같은 값 찾을때까지 이동
			while (nr >= l && arr[nr] > pivot)
				nr--;

			// 교환
			if (nl <= nr) {
				swap(nl++, nr--);
			}
		}

		// nr : 피봇이 이동해야할 곳
		arr[l] = arr[nr];
		arr[nr] = pivot;
		
		// 피봇 위치 반환
		return nr; 
	}
	
	static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
