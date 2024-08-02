// 성공
// https://www.acmicpc.net/problem/1978
	 
package 튼튼한_기본기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수_찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int prime = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 1) {
				boolean check = false;
				for(int div = 2; div <= (int) Math.sqrt(num); div++) {
					if(num % div == 0) {
						check = true;
						break;
					}
				}
				if(!check) {
					prime++;
				}
			}
		}
		
		System.out.println(prime);
	}
}
