package com.anmol.array;

import java.util.Stack;

import org.junit.Assert;

import org.junit.Test;

/**
 * LeetCode – Evaluate Reverse Polish Notation 
 * @see http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
 * @author Anmol M
 * 
 */
public class ReversePolishNotation {
	public static void main(String[] args) {
//		ReversePolishNotation rpn = new ReversePolishNotation();
//		System.out.println(rpn.evaluate());
	}
	
	@Test
	public void test1() {
		ReversePolishNotation rpn = new ReversePolishNotation();
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		Assert.assertEquals(Integer.valueOf(9), rpn.evaluate(tokens));
	}
	
	@Test
	public void test2() {
		ReversePolishNotation rpn = new ReversePolishNotation();
		String[] tokens = new String[] { "4", "2", "5", "*", "+", "1", "3", "2", "*", "+", "/" };
		Assert.assertEquals(Integer.valueOf(2), rpn.evaluate(tokens));
	}
	
	@Test
	public void test3() {
		ReversePolishNotation rpn = new ReversePolishNotation();
		String[] tokens = new String[] { "5", "1", "2", "+", "4", "*", "3", "-", "+" };
		Assert.assertEquals(Integer.valueOf(14), rpn.evaluate(tokens));
	}
	
	public Integer evaluate(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for(String token : tokens) {
			try {
				Integer number = Integer.valueOf(token);
				stack.push(number);
			}
			catch(NumberFormatException ex) {
				Integer number2 = stack.pop();
				Integer number1 = stack.pop();
				stack.push(calculate(token.charAt(0), number1, number2));
			}
		}
		return stack.pop();
	}
	
	private Integer calculate(char ch, Integer number1, Integer number2) {
		switch(ch) {
			case '+' :
				return number1 + number2;
			case '*' :
				return number1 * number2;
			case '/' :
				return number1 / number2;
			case '-' :
				return number1 - number2;
		}
		return null;
	}
}
