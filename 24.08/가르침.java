// 테케 통과. 시간초과
// https://www.acmicpc.net/problem/1062

package 약점_체크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가르침 {
	static int n;
	static int k;
	static int result = 0;
	static boolean[] visited = new boolean[26];
	static boolean[] alpha = new boolean[26];
	static ArrayList<Integer>[] arr;

	public static void dfs(int depth, int cnt) {
		if(depth == cnt) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				boolean check = true;
				if(!arr[i].isEmpty()) {
					for(int j = 0; j < arr[i].size(); j++) {
						if(!visited[arr[i].get(j)]) {
							check = false;
							break;
						}
					}
				}
				if(check) {
					sum++;
				}
			}
			if(sum > result) {
				result = sum;
			}
			return;
		}
		
		for(int i = 0; i < 26; i++) {
			if(alpha[i] && !visited[i]) {
				visited[i] = true;
				dfs(depth + 1, cnt);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(k >= 5) {
			visited['a'-'a'] = true;
			visited['n'-'a'] = true;
			visited['t'-'a'] = true;
			visited['i'-'a'] = true;
			visited['c'-'a'] = true;
			
			arr = new ArrayList[n];
			for(int i = 0; i < n; i++) {
				arr[i] = new ArrayList<>();
			}
			
			
			for(int s = 0; s < n; s++) {
				String str = br.readLine();
				for(int i = 4; i < str.length() - 4; i++) {
					Integer temp = str.charAt(i) - 'a';
					if(!visited[temp] && !arr[s].contains(temp)) {
						arr[s].add(temp);
						alpha[temp] = true;
					}
				}
				if(arr[s].isEmpty()) {
					result++;
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < 26; i++) {
				if(alpha[i]) {
					cnt++;
				}
			}
			
			if(cnt <= k - 5) {
				result = n;
			} else {
				dfs(0, k - 5);				
			}
		}
		
		System.out.println(result);
	}
	
}
