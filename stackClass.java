package Stack;

import java.util.*;

public class stackClass {
	List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
	List<Integer> stack = new ArrayList<Integer>();

	public int peek() {
		return stack.get(stack.size() - 1);
	}

	public int pop() {
		return stack.remove(stack.size() - 1);
	}

	public void push(int number) {
		Map<String, Integer> newMinMax = new HashMap<String, Integer>();

		newMinMax.put("min", number);
		newMinMax.put("max", number);

		if (minMaxStack.size() > 0) {
			// var maps=minMaxStack.get(minMaxStack.size()-1);
			// maps.size();

			Map<String, Integer> lastMinMax = new HashMap<String, Integer>(minMaxStack.get(minMaxStack.size() - 1));

			var min = Math.min(lastMinMax.get("min"), number);
			var max = Math.max(lastMinMax.get("max"), number);

			newMinMax.replace("min", min);
			newMinMax.replace("max", max);
		}

		minMaxStack.add(newMinMax);

		stack.add(number);
	}

	public int getMin() {
		return minMaxStack.get(minMaxStack.size() - 1).get("min");
	}

	public int getMax() {
		return minMaxStack.get(minMaxStack.size() - 1).get("max");
	}

	public float getAvg() {
		float total = 0;

		for (Integer i : stack) {
			total += i;
		}

		return total / stack.size();
	}

	public int Count() {
		return stack.size();
	}
}