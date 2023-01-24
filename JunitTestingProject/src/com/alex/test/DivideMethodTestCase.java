package com.alex.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.alex.calculator.Calculator;
import com.alex.exception.NegativeNumberException;

//Shows how you can run multiple unit tests within a Stream
class DivideMethodTestCase {

	private Calculator calculator;

	@BeforeEach
	void setUp() throws Exception {
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		calculator = null;
	}

	@DisplayName("Diving 10 by 2")
	@Test
	void RQ1TC01() throws NegativeNumberException {
		assertEquals(5, calculator.divide(10, 2));
	}

	@DisplayName("Diving 0 by 2")
	@Test
	void RQ1_TC02() throws NegativeNumberException {
		assertEquals(0, calculator.divide(0, 2));
	}

	@ParameterizedTest(name="#{index}= {0}/{1} throws exception {2}")
	@MethodSource("valueForTestCases")
	void RQ1_TestCases(int num1,int num2,Class exception) {
		assertThrows(exception, () -> calculator.divide(num1, num2));
	}
	
	static Stream<Arguments> valueForTestCases(){
		return Stream.of(Arguments.arguments(10,0,ArithmeticException.class),
				Arguments.arguments(-10,2,NegativeNumberException.class),
				Arguments.arguments(-50,2,NegativeNumberException.class),
				Arguments.arguments(10,-2,NegativeNumberException.class),
				Arguments.arguments(-10,-2,NegativeNumberException.class),
				Arguments.arguments(-10,0,NegativeNumberException.class));
	}
}
