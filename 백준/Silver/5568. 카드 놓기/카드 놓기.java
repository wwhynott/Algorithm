
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		// 조합으로 풀어보려 했으나 
		// 고른 카드의 순서도 바꿔가면서 정수를 만들어줘야 하는데
		// 그건 또 어떻게 해야할지 모르겠어서...
		// 2 <= k <= 4 이니까 무지성 for문 돌려도 괜찮지 않을까 싶음
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		HashSet<String> set = new HashSet<>();
		
		for (int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		switch (k) {
			case 2: {
				for (int i=0; i<n; i++) {
					for (int j=0; j<n; j++) {
						if (i != j) {
							String str = arr[i]+arr[j];
							set.add(str);
						}
					}
				}
				break;
			}
			case 3: {
				for (int i=0; i<n; i++) {
					for (int j=0; j<n; j++) {
						for (int k2=0; k2<n; k2++) {
							if (i != j && j != k2 && k2 != i) {
								String str = arr[i]+arr[j]+arr[k2];
								set.add(str);
							}
						}
					}
				}
				break;
			}
			case 4: {
				for (int i=0; i<n; i++) {
					for (int j=0; j<n; j++) {
						for (int k2=0; k2<n; k2++) {
							for (int l=0; l<n; l++) {
								if (i != j && j != k2 && k2 != l && l != i &&
										i != k2 && j != l) {
									String str = arr[i]+arr[j]+arr[k2]+arr[l];
									set.add(str);
								}
							}
						}
					}
				}
				break;
			}
		}
		
		System.out.println(set.size());

	}

}
