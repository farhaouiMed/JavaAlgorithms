package algorithme1;

import java.util.Arrays;

public class Solution {

	public static int[] solution(int N, int[] A) {
		
		int[] result_array = new int[N];
		
		for(int i=0; i<A.length; i++) {
			if ((A[i] >= 1) && (A[i] <= N)){
				
				result_array[A[i] - 1] += 1;
				
			} else if (A[i] == N + 1) {
				
				//sort array to make the maximum number in the last case of the array
				Arrays.sort(result_array);
				int a = result_array[result_array.length - 1];
				
				//set the maximum of the table in all cases
				Arrays.fill(result_array, a);
			}
		}
		return result_array;
	}
	public static void main(String[] args) {
		int[] A = {3,4,4,6,1,4,4};
		int N = 5;
		int[] result = solution(N,A);
		for(int i=0; i<result.length; i++) {
			System.out.println("result["+i+"] : "+ result[i]);
		}
	}

}
