// 성공
// https://www.acmicpc.net/problem/2609

package 튼튼한_기본기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 최대공약수와_최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 0, max = 0;
		int gcd = 1, lcm = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int temp1 = Integer.parseInt(st.nextToken());
		int temp2 = Integer.parseInt(st.nextToken());
		
		if(temp1 >= temp2) {
			min = temp2;
			max = temp1;
		} else {
			min = temp1;
			max = temp2;
		}
		
		while(min > 1) {
			boolean check = false;
			for(int div = 2; div <= min; div++) {
				if(min % div == 0 && max % div == 0) {
					min /= div;
					max /= div;
					gcd *= div;
					break;
				}
				if(div == min) {
					check = true;
					break;
				}
			}
			if(check) {
				break;
			}
		}
		
		lcm = lcm * gcd * min * max;
		
		System.out.println(gcd);
		System.out.println(lcm);
		
	}
}
