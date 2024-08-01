// 성공
// https://www.acmicpc.net/problem/3460

package 튼튼한_기본기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 이진수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= testcase; tc++) {
			int n = Integer.parseInt(br.readLine());
			int idx = 0;
			while(n > 0) {
				if(n % 2 == 1) {
					bw.write(idx + " ");					
				}
				n /= 2;
				idx++;
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
