// 성공
// https://www.acmicpc.net/problem/1292

package 튼튼한_기본기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쉽게_푸는_문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[b];
		int idx = 0;
		int num = 1, repeat = 0;
		while(idx < b) {
			arr[idx++] = num;
			repeat++;
			if(num == repeat) {
				num++;
				repeat = 0;
			}
		}
		
		int sum = 0;
		for(int i = a - 1; i < b; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
	}
}
