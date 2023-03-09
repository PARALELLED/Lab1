package com.ctbc.boot.lab1.calculator;

public class SubCalculator implements Calculator{
	// 沒有跟Spring有關聯之前，都沒關係
	@Override
	public int calc(int a, int b) {
		return a - b;
	}
	

}