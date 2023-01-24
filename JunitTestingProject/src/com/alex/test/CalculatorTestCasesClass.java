package com.alex.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import com.alex.calculator.Calculator;
import com.alex.exception.NegativeNumberException;

class CalculatorTestCasesClass {

	private Calculator calculator;

	@BeforeEach
	void setUp() throws Exception {
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		calculator = null;
	}

	//Run in reverse order
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	class DivideCheck {
		@Order(7)
		@Test
		void RQ1TC01() throws NegativeNumberException {
			assertEquals(5, calculator.divide(10, 2));
		}

		@Order(6)
		@Test
		void RQ1_TC02() throws NegativeNumberException {
			assertEquals(0, calculator.divide(0, 2));
		}

		@Order(5)
		@Test
		void RQ1_TC03() {
			assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
		}

		@Order(4)
		@Test
		void RQ1_TC04() {
			assertThrows(NegativeNumberException.class, () -> calculator.divide(-10, 2));
		}

		@Order(3)
		@Test
		void RQ1_TC05() {
			assertThrows(NegativeNumberException.class, () -> calculator.divide(10, -2));
		}

		@Order(2)
		@Test
		void RQ1_TC06() {
			assertThrows(NegativeNumberException.class, () -> calculator.divide(-10, -2));
		}

		@Order(1)
		@Test
		void RQ1_TC07() {
			assertThrows(NegativeNumberException.class, () -> calculator.divide(-10, 0));
		}
	}

	//Enables and Disables certain requirements
	@Nested
	class AddCheck {
		@DisabledOnOs(value = {OS.WINDOWS,OS.LINUX})
		@Test
		void RQ2_TC01() throws NegativeNumberException {
			assertEquals(30, calculator.add(10, 20));
		}

		@DisabledOnJre(value = {JRE.JAVA_11})
		@Test
		void RQ2_TC02() {
			assertThrows(NegativeNumberException.class, () -> calculator.add(-10, 20));
		}

		@EnabledOnOs(value = {OS.WINDOWS,OS.AIX})
		@Test
		void RQ2_TC03() {
			assertThrows(NegativeNumberException.class, () -> calculator.add(10, -20));
		}

		@Test
		void RQ2_TC04() {
			assertThrows(NegativeNumberException.class, () -> calculator.add(-10, -20));
		}

		@Test
		void RQ2_TC05() throws NegativeNumberException {
			assertEquals(10, calculator.add(10, 0));
		}

		@Test
		void RQ2_TC06() throws NegativeNumberException {
			assertEquals(20, calculator.add(0, 20));
		}

		@Test
		void RQ2_TC07() {
			assertThrows(NegativeNumberException.class, () -> calculator.add(-10, 0));
		}

		@Test
		void RQ2_TC08() {
			assertThrows(NegativeNumberException.class, () -> calculator.add(0, -20));
		}
	}
}
