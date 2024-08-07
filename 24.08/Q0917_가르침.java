// 성공
// https://www.acmicpc.net/problem/1062

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침 {
	static int n;
	static int k;
	static int result;
	static String[] str;
	static boolean[] visited = new boolean[26];
	
	public static void count() {
		int cnt = 0;
		for(int s = 0; s < n; s++) {
			boolean flag = true;
			for(int i = 0; i < str[s].length(); i++) {
				if(!visited[str[s].charAt(i) - 'a']) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}
		result = Math.max(cnt, result);
	}
	
	public static void dfs(int depth, int start) {
		if(depth == k - 5) {
			count();
			return;
		}
		for(int i = start; i < 26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		str = new String[n];
		for(int s = 0; s < n; s++) {
			String temp = br.readLine();
			str[s] = temp.substring(4, temp.length() - 4);
		}
		
		if(k == 26) {
			result = n;
		} else if(k < 5) {
			result = 0;
		} else {
			result = 0;
			visited['a'-'a'] = true;
			visited['n'-'a'] = true;
			visited['t'-'a'] = true;
			visited['i'-'a'] = true;
			visited['c'-'a'] = true;
			
			dfs(0, 0);
		}
		System.out.println(result);
	}
}

// 시간초과
package 약점_체크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class 가르침 {
	static int n;
	static int k;
	static int result = 0;
	static boolean[] visited = new boolean[26]; //배운 알파벳들을 넣는 곳
	static HashMap<Integer, Set<Integer>> map = new HashMap<>();
	
	
	public static void count() {
		HashSet<Integer> set = new HashSet<>();
		for(Map.Entry<Integer, Set<Integer>> i:
			map.entrySet()) {
			if(!visited[i.getKey()]) {
				Iterator<Integer> it = map.get(i.getKey()).iterator();
				while(it.hasNext()) {
					set.add(it.next());
				}
			}
		}
		
		int sum = n - set.size();
		if(sum > result) {
			result = sum;
		}
	}
	
	public static void dfs(int depth, int cnt) {
		if(depth == cnt) {
			count();
			return;
		}
		for(Map.Entry<Integer, Set<Integer>> set :
			map.entrySet()) {
			int k = set.getKey();
			if(!visited[k]) {
				visited[k] = true;
				dfs(depth + 1, cnt);
				visited[k] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 단어 개수
		k = Integer.parseInt(st.nextToken()); // 가르칠 수 있는 글자 개수
		
		// 모든 단어는 "anta"와 "tica"로 끝나기 때문에 k의 값은 5이상이여야 함.
		if(k >= 5) {
			// 기본 알파벳 ASCII 코드 사용해 불린에 넣어주기.
			visited['a'-'a'] = true;
			visited['n'-'a'] = true;
			visited['t'-'a'] = true;
			visited['i'-'a'] = true;
			visited['c'-'a'] = true;
			
			// 단어의 알파벳을 ASCII 코드로 변환해 넣어주기.
			for(int s = 0; s < n; s++) {
				String str = br.readLine();
				int len = str.length();
				// 길이 8 이하는 체크할 필요 x
				if(len > 8) {
					Set<Character> set = new HashSet<>();
					for(int i = 4; i < len - 4; i++) {
						set.add(str.charAt(i));
					}					
					if(!set.isEmpty()) {
						Iterator<Character> i = set.iterator();
						while(i.hasNext()) {
							int a = i.next() - 'a';
							if(!visited[a]) {
								if(!map.containsKey(a)) {
									map.put(a, new HashSet<>());
								}
								map.get(a).add(s);
							}
						}					
					}
				}
			}
			
			int cnt = map.size();
			
			// 배우지 않은 단어의 개수가 배울 수 있는 단어의 개수보다 적으면 모든 단어를 익힐 수 있음.
			if(cnt <= k - 5) {
				result = n;
			} else {
				dfs(0, k - 5);				
			}
		}
		
		System.out.println(result);
	}
}