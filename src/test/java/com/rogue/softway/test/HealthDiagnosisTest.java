package com.rogue.softway.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rogue.softway.service.HealthDiagnosis;
import com.rogue.softway.service.HealthDiagnosisImpl;

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
				() -> assertEquals("Traumatologie", diagnosisResult.get(0)));
	}

	@Test
	public void multipleOf5Test() {
		final int testValue = 55;

		final List<String> diagnosisResult = healthDiagnosis.redirectPatiens(testValue);

		assertAll("Multiple of 5 test", () -> assertEquals(1, diagnosisResult.size()),
				() -> assertEquals("Cardiologie", diagnosisResult.get(0)));
	}

	@Test
	public void multipleOf3and5Test() {
		final int testValue = 15;

		final List<String> resultExpected = Arrays.asList("Cardiologie", "Traumatologie");

		final List<String> diagnosisResult = healthDiagnosis.redirectPatiens(testValue);

		assertAll("Multiple of 3 and 5 test", () -> assertEquals(2, diagnosisResult.size()),
				() -> assertTrue(diagnosisResult.containsAll(resultExpected)));
	}

	@Test
	public void notMultipleOf3and5Test() {
		final int testValue = 11;

		final List<String> resultExpected = Collections.emptyList();

		final List<String> diagnosisResult = healthDiagnosis.redirectPatiens(testValue);

		assertAll("Multiple of 3 and 5 test", () -> assertEquals(0, diagnosisResult.size()),
				() -> assertTrue(diagnosisResult.containsAll(resultExpected)));
	}
}
