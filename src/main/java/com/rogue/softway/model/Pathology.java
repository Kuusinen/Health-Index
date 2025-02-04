package com.rogue.softway.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class Pathology {

	int indexFactor;

	MedicalUnit medicalUnit;

	public boolean isInterventionRequired(final int healthIndex) {
		return healthIndex % indexFactor == 0;
	}

	public String medicalUnitName() {
		return medicalUnit.getName();
	}
}
