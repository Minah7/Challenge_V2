// 성공
// https://www.acmicpc.net/problem/2501

package 튼튼한_기본기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 약수_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int answer = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 1;
		int totalCnt = 0;
		int root = (int) Math.sqrt(n);
		for(int i = 1; i <= root; i++) {
			if(n % i == 0) {
				if(cnt == k) {
					answer = i;
					break;
				}
				map.put(i, n / i);
				list.add(i);
				cnt++;
				totalCnt += 2;
				if(i == n / i) {
					totalCnt -= 1;
				}
			}
		}
		
		if(answer == 0) {
			if(k <= totalCnt) {
				k -= map.size();
				if(totalCnt % 2 == 0) {
					k = map.size() - k;					
				} else {
					k = map.size() - k - 1;
				}
				answer = map.get(list.get(k));
			}
		}
		
		System.out.println(answer);
	}
}
