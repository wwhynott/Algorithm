
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] arr, sortedArr; // 원본배열, 정렬시 사용할 배열
	static int cnt = 0; // 몇번째 저장임? 
	static List<Integer> res; // K번째 저장되는 수 저장 리스트?
	
	public static void main(String[] args) throws Exception {
		// 병합정렬 구현 고고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sortedArr = new int[N];
		res = new ArrayList<>();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		mergeSort(0, N-1);
		
		if (res.size() >= K) {
			System.out.println(res.get(K-1));
		} else {
			System.out.println("-1");
		}
	}

	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left+right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		// 사용할 포인터를 만들자 ~
		int L = left; // 왼쪽 배열 시작위치
		int R = mid+1; // 오른쪽 배열 시작위치
		int idx = left; // 정렬한 값 넣어줄 인덱스
		
		// 서로 비교할 값 남아있는 동안
		while (L <= mid && R <= right) {
			// 작은 값을 idx에 넣자
			if (arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
				res.add(arr[L-1]);
			} else {
				sortedArr[idx++] = arr[R++];
				res.add(arr[R-1]);
			}
		}
		
		// 왼쪽이 남았다 ? 
		if (L <= mid) {
			// 남은거 추가하세염
			for (int i=L; i<=mid; i++) {
				sortedArr[idx++] = arr[i];
				res.add(arr[i]);
			}
		} else {
			for (int i=R; i<=right; i++) {
				sortedArr[idx++] = arr[i];
				res.add(arr[i]);
			}
		}
		
		// 원본 배열에 반영 !!!!
		for (int i=left; i<=right; i++) {
			arr[i] = sortedArr[i];
		}
		
	}
}
