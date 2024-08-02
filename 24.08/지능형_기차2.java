// 성공
// https://www.acmicpc.net/problem/2460

package 튼튼한_기본기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지능형_기차2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int people = 0, max = 0;
		for(int station = 1; station <= 10; station++) {
			st = new StringTokenizer(br.readLine());
			people -= Integer.parseInt(st.nextToken());
			people += Integer.parseInt(st.nextToken());
			if(people > max) {
				max = people;
			}
		}
		
		System.out.println(max);
	}
}
