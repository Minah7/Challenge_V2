// 성공
// https://www.acmicpc.net/problem/2309

package 튼튼한_기본기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 일곱_난쟁이 {
	
	static int find = 7;
	static int dwarves = 9;
	static int sumD = 100;
	static int[] dwarf = new int[dwarves];
	static int[] result = new int[find];
	static boolean[] visited = new boolean[dwarves];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < dwarves; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		findDwarves(0, 0);
		
	}
	
	public static void findDwarves(int start, int depth) throws IOException {
		if(depth == find) {
			int sum = 0;
			for(int i = 0; i < find; i++) {
				sum += result[i];
			}
			if(sum == sumD) {
				Arrays.sort(result);
				for(int i = 0; i < find; i++) {
					bw.write(result[i]+"\n");
				}
				bw.flush();
				bw.close();
				System.exit(0);
			}
			return;
		}
		
		
		for(int i = start; i < dwarves; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = dwarf[i];
				findDwarves(start + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
}
