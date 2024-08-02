// 성공
// https://www.acmicpc.net/problem/10870

package 튼튼한_기본기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_수5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] fibo = new int[21];
		fibo[0] = 0;
		fibo[1] = 1;
		
		if(n > 1) {
			for(int i = 2; i <= n; i++) {
				fibo[i] = fibo[i-2] + fibo[i-1];
			}
		}
		
		System.out.println(fibo[n]);
	}
}
