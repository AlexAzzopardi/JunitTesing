package com.alex.calculator;

import com.alex.exception.NegativeNumberException;

public class Calculator {
	
	//RQ1. Divide two Positive Integers
	public int divide(int number1,int number2)throws NegativeNumberException {
		if(number1>=0 && number2>=0)
			return number1/number2;
		else
			throw new NegativeNumberException("Negative Integers Not Allowed");
	}
	

	//RQ2. Sum of two Positive Integers
	public int add(int number1,int number2)throws NegativeNumberException{
		if(number1>=0 && number2>=0)
			return number1 + number2;
		else
			throw new NegativeNumberException("Negative Integers Not Allowed");
	}
}
