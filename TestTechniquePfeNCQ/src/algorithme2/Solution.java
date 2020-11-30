package algorithme2;

import java.util.Arrays;

public class Solution {
	
	public static int[] solution(int[] A, int[] B) {
		final int[] tab = new int[A.length < 2 ? 2 : A.length];
        tab[0] = 1;
        tab[1] = 2;
		for (int i = 2; i < A.length; i++) {
            tab[i] = (tab[i - 1] + tab[i - 2]) & ((1 << 30) - 1);
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = tab[A[i] - 1] & ((1 << B[i]) - 1);
        }
        return A;
	}
	public static void main(String[] args) {
		int[] A = new int[]{4,4,5,5,1};
		int[] B = new int[] {3,2,4,3,1};
		int[] C = new int[A.length];
		C = solution(A, B);
		for(int i=0; i<C.length; i++) {
			System.out.println("C["+i+"] : "+C[i]);
		}
		
	}
}
