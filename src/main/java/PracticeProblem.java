import java.util.HashMap;

public class PracticeProblem {

	public static void main(String args[]) {
		System.out.println(fib(4));
		int[] cost = {10, 15, 20};
		System.out.println(minCostClimbingStairs(cost));

	}

	public static int fib(int num) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		return fibHelper(num, map);
	}

	public static int fibHelper(int num, HashMap<Integer, Integer> map) {
		//base cases
		if(num == 0){
			return 0;
		}

		if(num == 1){
			return 1;
		}
		//check the map, if not in the map, add it
		if(!map.containsKey(num)){
			map.put(num, fibHelper(num - 1, map) + fibHelper(num - 2, map));
		}

		return map.get(num);

	}

	public static int minCostClimbingStairs(int[] cost){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(cost.length == 1){
			return cost[0];
		}
		//find min of both starts at index 0 and 1?
		int start0 = minCostClimbingStairsHelper(0, map, cost);
		int start1 = minCostClimbingStairsHelper(1, map, cost);
		return(Math.min(start0,start1));
	}

	public static int minCostClimbingStairsHelper(int i, HashMap<Integer, Integer> map, int[] cost){
		//base cases
		if(i > cost.length-1){
			return 0;
		}

		//check map
		if(!map.containsKey(i)){
			int step1 = minCostClimbingStairsHelper(i+1, map, cost);
			int step2 = minCostClimbingStairsHelper(i+2, map, cost);
			
			//check which is minimum step/cost and add to the cost we are on
			map.put(i, cost[i] + (Math.min(step1, step2)));
		}
		return map.get(i);
	}
	
}
