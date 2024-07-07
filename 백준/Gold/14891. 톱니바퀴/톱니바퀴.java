
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] gearArr = new int[4][8];
	static int K; // 회전 횟수
	
	static boolean a,b,c,d; // 돌아갈 톱니바퀴
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<4; i++) {
			String input = br.readLine();
			for (int j=0; j<8; j++) {
				gearArr[i][j] = input.charAt(j) -'0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		for (int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = false;
			b = false;
			c = false;
			d = false;
			
			int num = Integer.parseInt(st.nextToken()); // 회전하는 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 회전방향
			
			switch (num) {
				case 1: {
					a = true;
					if (gearArr[0][2] != gearArr[1][6]) {
						b = true;
						if (gearArr[1][2] != gearArr[2][6]) {
							c = true;
							if (gearArr[2][2] != gearArr[3][6]) {
								d = true;
							}
						}
					}
					
					if (a) {
						rotate(1,dir);
					}
					if (b) {
						rotate(2,-dir);
					}
					if (c) {
						rotate(3, dir);
					}
					if (d) {
						rotate(4, -dir);
					}
					break;
				}
				case 2: {
					b = true;
					
					// 왼
					if (gearArr[0][2] != gearArr[1][6]) {
						a = true;
					}
					
					// 오
					if (gearArr[1][2] != gearArr[2][6]) {
						c = true;
						if (gearArr[2][2] != gearArr[3][6]) {
							d = true;
						}	
					}
					
					if (a) {
						rotate(1,-dir);
					}
					if (b) {
						rotate(2,dir);
					}
					if (c) {
						rotate(3,-dir);
					}
					if (d) {
						rotate(4,dir);
					}
					break;
				}
				case 3: {
					c = true;
					
					// 왼
					if (gearArr[1][2] != gearArr[2][6]) {
						b = true;
						if (gearArr[0][2] != gearArr[1][6]) {
							a = true;
						}
					}
					
					// 오 
					if (gearArr[2][2] != gearArr[3][6]) {
						d = true;
					}
					
					if (a) {
						rotate(1,dir);
					}
					if (b) {
						rotate(2,-dir);
					}
					if (c) {
						rotate(3,dir);
					}
					if (d) {
						rotate(4,-dir);
					}
					break;
				}
				case 4: {
					d = true; 
					
					if (gearArr[2][2] != gearArr[3][6]) {
						c = true;
						if (gearArr[1][2] != gearArr[2][6]) {
							b = true;
							if (gearArr[0][2] != gearArr[1][6]) {
								a = true;
							}
						}
					} 
					
					if (a) {
						rotate(1,-dir);
					}
					if (b) {
						rotate(2,dir);
					}
					if (c) {
						rotate(3,-dir);
					}
					if (d) {
						rotate(4,dir);
					}
					break;
				}
			}
			
		}
		
		int sum = gearArr[0][0] * 1
				+ gearArr[1][0] * 2
				+ gearArr[2][0] * 4
				+ gearArr[3][0] * 8;
		
		System.out.println(sum);
		
	}
	
	// num : 회전하는 톱니바퀴 / dir : 회전방향
	static void rotate(int num, int dir) {
		if (dir == 1) {
			int last = gearArr[num-1][7];
			for (int i=7; i>=1; i--) {
				gearArr[num-1][i] = gearArr[num-1][i-1];
			}
			gearArr[num-1][0] = last;
		} else {
			int first = gearArr[num-1][0];
			for (int i=0; i<7; i++) {
				gearArr[num-1][i] = gearArr[num-1][i+1];
			}
			gearArr[num-1][7] = first;
		}
	}
}
