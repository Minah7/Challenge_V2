// 경상북도 특산품인 사과를 학생들에게 나눠주기 위해 여러 학교에 사과를 배정하였다. 
// 배정된 사과 개수는 학교마다 다를 수 있고, 학생 수도 학교마다 다를 수 있다.
// 각 학교에서는 배정된 사과를 모든 학생들에게 똑같이 나눠주되, 
// 남는 사과의 개수를 최소로 하려고 한다. 
// (서로 다른 학교에 속한 학생이 받는 사과 개수는 다를 수 있다.)

// 예를 들어, 5개 학교의 학생 수와 배정된 사과 수가 다음과 같다고 하자.

// 학교	A	B	C	D	E
// 학생 수	24	13	5	23	7
// 사과 개수	52	22	53	10	70
// A 학교에서는 모든 학생에게 사과를 두 개씩 나눠주고 4개의 사과가 남게 된다. 
// B 학교에서는 모든 학생에게 사과를 한 개씩 나눠주고 9개의 사과가 남게 된다. 
// 비슷하게 C 학교에서는 3개의 사과가, D 학교에서는 10개의 사과가,
//  E 학교에서는 0개의 사과가 남게 되어, 남는 사과의 총 수는 4+9+3+10+0 = 26이다. 

// 각 학교의 학생 수와 사과 개수가 주어졌을 때, 
// 학생들에게 나눠주고 남는 사과의 총 개수를 구하는 프로그램을 작성하시오.

// 성공

package Baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int student = sc.nextInt();
			int apple = sc.nextInt();
			answer += apple%student;
		}
		System.out.println(answer);
	}
}
