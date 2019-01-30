package jstest;

import java.util.HashSet;
import java.util.Set;

/*
 * 1. 1-45 난수 발생
 * 2. 같은 숫자 x
 * 3. 3개 숫자 발생.
 * 
 */

public class Lotto {
	public static void main(String[] args) {
		int num1 = (int) (Math.random()*3 + 1);
		int num2 = (int) (Math.random()*3 + 1);
		int num3 = (int) (Math.random()*3 + 1);
		boolean result = true;
				
		while(result) {
			if(num1 == num2 || num2 == num3 || num1 == num3) {
				num1 = (int) (Math.random()*3 + 1);
				num2 = (int) (Math.random()*3 + 1);
				num3 = (int) (Math.random()*3 + 1);
			} else {
				result = false;
			}
		}
		System.out.println("번호 : "  + num1 + "\t" + num2 + "\t" + num3);
		
		
		// set 으로
		Set<Integer> set = new HashSet<>();
		int cnt = 0;
		while(cnt != 6) {
			set.add((int) (Math.random()*45 + 1));
			cnt = set.size();
		}
		
		Integer num[] = set.toArray(new Integer[0]);
		for (int n : num) {
			System.out.println(n);
		}
		
	}
}
