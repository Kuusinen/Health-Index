package com.rogue.softway.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rogue.softway.test.service.HealthDiagnosis;
import com.rogue.softway.test.service.HealthDiagnosisImpl;

public class HealthDiagnosisTest {

	HealthDiagnosis healthDiagnosis;

	@BeforeEach
	public void initServiceTest() {
		healthDiagnosis = new HealthDiagnosisImpl();
	}

	@Test
	public void multipleOf3Test() {
		final int testValue = 33;

		final List<String> diagnosisResult = healthDiagnosis.redirectPatiens(testValue);

		assertAll("Multiple of 3 test", () -> assertEquals(1, diagnosisResult.size()),
				() -> assertEquals("traumatologie", diagnosisResult.get(0)));
	}

	@Test
	public void multipleOf5Test() {
		final int testValue = 55;

		final List<String> diagnosisResult = healthDiagnosis.redirectPatiens(testValue);

		assertAll("Multiple of 5 test", () -> assertEquals(1, diagnosisResult.size()),
				() -> assertEquals("cardiologie", diagnosisResult.get(0)));
	}

	@Test
	public void multipleOf3and5Test() {
		final int testValue = 15;

		final List<String> resultExpected = Arrays.asList("cardiologie", "traumatologie");

		final List<String> diagnosisResult = healthDiagnosis.redirectPatiens(testValue);

		assertAll("Multiple of 3 and 5 test", () -> assertEquals(2, diagnosisResult.size()),
				() -> Assertions.assertIterableEquals(resultExpected, diagnosisResult));
	}

	@Test
	public void notMultipleOf3and5Test() {
		final int testValue = 11;

		final List<String> resultExpected = Collections.emptyList();

		final List<String> diagnosisResult = healthDiagnosis.redirectPatiens(testValue);

		assertAll("Multiple of 3 and 5 test", () -> assertEquals(2, diagnosisResult.size()),
				() -> Assertions.assertIterableEquals(resultExpected, diagnosisResult));
	}
}
