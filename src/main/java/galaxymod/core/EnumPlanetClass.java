/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.core;

public enum EnumPlanetClass {
	D("D"), H("H"), J("J"), K("K"), L("L"), M("M"), Y("Y"), NINE("9");
	
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