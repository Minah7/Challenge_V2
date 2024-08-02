// 성공
// https://www.acmicpc.net/problem/2581

package 튼튼한_기본기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int min = 0;
		int sum = 0;
		
		for(int i = m; i <= n; i++) {
			if(i < 2) {
				continue;
			}
			
			boolean check = false;
			for(int div = 2; div <= (int) Math.sqrt(i); div++) {
				if(i % div == 0) {
					check = true;
					break;
				}
			}
			
			if(!check) {
				if(min == 0) {
					min = i;
				}
				sum += i;
			}
		}
		
		if(min == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);			
		}
	}
}
