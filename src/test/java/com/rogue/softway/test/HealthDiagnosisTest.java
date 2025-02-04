package com.rogue.softway.test;

import static org.junit.jupiter.api.Assertions.fail;

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
	}

	@Test
	public void multipleOf5Test() {
		fail("Not yet implemented");
	}

	@Test
	public void multipleOf3and5Test() {
		fail("Not yet implemented");
	}

	@Test
	public void notMultipleOf3and5Test() {
		fail("Not yet implemented");
	}
}
