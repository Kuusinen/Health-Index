package com.rogue.softway.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.rogue.softway.model.Broken;
import com.rogue.softway.model.HeartProblem;
import com.rogue.softway.model.Pathology;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HealthDiagnosisImpl implements HealthDiagnosis {

	List<Pathology> pathologies;

	public HealthDiagnosisImpl() {
		pathologies = Arrays.asList(new Broken(), new HeartProblem());
	}

	@Override
	public List<String> redirectPatiens(final int healthIndex) {
		return pathologies.stream()
				.filter(pathology -> pathology.isInterventionRequired(healthIndex))
				.map(Pathology::medicalUnitName)
				.collect(Collectors.toList());
	}

}
