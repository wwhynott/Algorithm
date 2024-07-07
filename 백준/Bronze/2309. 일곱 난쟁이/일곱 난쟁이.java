import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 9가지 중 7가지를 선택하는 경우의 수?
		// 블랙잭이랑 같게?
		// 9개 중에 7개 선택 7C3 = (7!)/3!*4! = (7 * 6 * 5) / 6 = 35
		// 35 만큼의 길이를 가진 배열을 생성하고 그 안에 모든 경우의 수 넣기
		
		// 이렇게 하면............
		// 7중 for문이 되는거 아닌가 ㅠ
		
		// 2개 제외하고 고르는 경우
		
		// sort 사용을 위해 List로 풀기?
		List<Integer> list = new ArrayList<>();
		
		// 아홉 난쟁이 키가 입력된 리스트
		for (int i=0;i<9;i++) {
			list.add(sc.nextInt());
		}
		
		// 정답 배열
		// Q. 배열의 요소로 ArrayList를 받으면 2차원 배열인가?
		List<List> resList = new ArrayList<>();
		

		// 난쟁이 두명을 제거했을때 나머지 7명의 키의 합이 100이 되는 경우에 거짓난쟁이 두명의 index 저장
		for (int a=0;a<9;a++) {
			for (int b=0;b<9;b++) {
				if (a != b) { 
					// 제거할때 인덱스 바뀜..........
					// 제거하지 말고 값을 0으로 바꾸자?
//					list.set(a, 0);
//					list.set(b, 0);
					// 원본 리스트의 값이 변경됨 ㅠ ㅠ 
					// a,b 인덱스의 값은 건너뛰고 더하기!
					
					int sumHeight = 0;
					for (int i=0;i<9;i++) {
						if (i != a && i != b) {
							sumHeight += list.get(i);
						}
					}
					
					List<Integer> sList = new ArrayList<>(); // 진짜 난쟁이 리스트
					
					if (sumHeight == 100) {
						for (int i=0;i<9;i++) {
							if (i != a && i != b) {
								sList.add(list.get(i));
							}
						}
						sList.sort(null); // 오름차순 정렬
						
						// 정답 세트 중 한 세트만 출력하면 됨
						// 정답이 될 수 있는 것들을 또 배열로 넣어서............... 
						// 그 중 아무거나 출력?
						resList.add(sList);
						
					} 
					
				}
			}
		}
		for (int i=0;i<7;i++) {
			System.out.println(resList.get(0).get(i));
		}
		
	}
}