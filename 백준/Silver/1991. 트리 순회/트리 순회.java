import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left;
	Node right;
	char ldata;
	char rdata;
	
	Node() {}
	
	Node(char data) {
		this.data = data;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
        // 노드의 개수
        int N = Integer.parseInt(br.readLine());
        
        // 노드 담아둘 배열
        Node[] nodes = new Node[N+1]; // idx 0 비우기
        
        // data 입력
        for (int i=1; i<=N; i++) {
        	nodes[i] = new Node();
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	char curNode = st.nextToken().charAt(0);
        	char lNode = st.nextToken().charAt(0);
        	char rNode = st.nextToken().charAt(0);
        	
        	nodes[i].data = curNode;
        	nodes[i].ldata = lNode;
        	nodes[i].rdata = rNode;
        }
        
        // data 먼저 입력한 후에 각 노드의 왼쪽, 오른쪽 노드 정점 번호 탐색
        for (int i=1; i<=N; i++) {
        	// 왼쪽 노드 연결
        	if (nodes[i].ldata != '.') {
        		int n = i+1; // 자식 노드는 무조건 i보다 뒤에 주어진다
        		while (nodes[i].ldata != nodes[n].data) {
        			n++;
        		}
        		nodes[i].left = nodes[n];
        	}
        	// 오른쪽 노드 연결
        	if (nodes[i].rdata != '.') {
        		int n = i+1; // 자식 노드는 무조건 i보다 뒤에 주어진다
        		while (nodes[i].rdata != nodes[n].data) {
        			n++;
        		}
        		nodes[i].right = nodes[n];
        	}
        }
        
        preorder(nodes[1]);
        System.out.println();
        inorder(nodes[1]);
        System.out.println();
        postorder(nodes[1]);
        
        
	}
	
	// VLR
    static void preorder(Node node) {
        if (node == null) {
            return;
        }
 
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }
    
    // LVR
    static void inorder(Node node) {
        if (node == null) {
            return;
        }
 
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }
    
    // LRV
    static void postorder(Node node) {
        if (node == null) {
            return;
        }
 
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}