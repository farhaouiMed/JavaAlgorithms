package algorithme3;

import java.util.Arrays;

public class Solution {
	
	public static int solution(int[] A) {
		if(A.length > 0) {
			///////////////////////////////////
			int val_max = Integer.MIN_VALUE;
			int sum = 0;
			for(int i=0; i<A.length; i++) {
				int val = Math.abs(A[i]);
				sum += val;
	            if (val_max < val) {
	            	val_max = val;
	            }
	            A[i] = val;
			}
			///////////////////////////////////
			int[] counts = new int[val_max + 1];
			for (int value: A) {
	            counts[value]++;
	        }
			///////////////////////////////////
			//initialize a table tab with -1 except the first element
			int[] Total = new int[sum + 1];

		    for (int i = 1; i < Total.length; i++) {
		        Total[i] = -1;
		    }

		    for (int i = 1; i < counts.length; i++) {

		        for (int j = 0; j < Total.length; j++) {

		            if (Total[j] >= 0) {
		                Total[j] = counts[i];
		            } else if (j - i >= 0 && Total[j - i] > 0) {
		                Total[j] = Total[j - i] - 1;
		            }
		        }
		    }

		    int result = sum;

		    for (int i = 0; i < Total.length / 2 + 1; i++) {
		        if (Total[i] >= 0 && result > Math.abs(sum - 2 * i)) {
		            result = Math.abs(sum - 2 * i);
		        }
		    }
		    return result;
		} 
		return 0;
	}

	public static void main(String[] args) {
		int[] A = new int[] {1, 5, 2, -2};
		System.out.println("result = " + solution(A));
	}

}
