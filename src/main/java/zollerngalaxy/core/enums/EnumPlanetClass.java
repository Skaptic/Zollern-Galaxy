/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.enums;

public enum EnumPlanetClass {
	
	D("D"),
	H("H"),
	J("J"),
	K("K"),
	L("L"),
	M("M"),
	N("N"),
	R("R"),
	T("T"),
	Y("Y"),
	NINE("9"),
	EXOTIC("Exotic"),
	ABANDONED("Abandoned"),
	CONSTRUCTED("Constructed"),
	DESERT("Desert"),
	OCEAN("Ocean");
	
	private EnumPlanetClass planetClass;
	private String planetClassStr;
	
	private EnumPlanetClass(String strClass) {
		this.planetClassStr = strClass;
	}
	
	private EnumPlanetClass(EnumPlanetClass pClass) {
		this.planetClass = pClass;
	}
	
	public void setPlanetStrClass(String strClass) {
		this.planetClassStr = strClass;
	}
	
	public void setPlanetClass(EnumPlanetClass pClass) {
		this.planetClass = pClass;
	}
	
	public String getPlanetStrClass() {
		return this.planetClassStr;
	}
	
	public EnumPlanetClass getPlanetClass() {
		return this.planetClass;
	}
}