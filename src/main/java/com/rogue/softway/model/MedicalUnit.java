package com.rogue.softway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MedicalUnit {

	TRAUMA("Traumatologie"),
	CARDIOLOGY("Cardiologie");

	final String name;
}
