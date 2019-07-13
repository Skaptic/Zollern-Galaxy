package zollerngalaxy.core.enums;

public enum EnumHarvestLevel {
	
	WOOD(0), STONE(1), IRON(2), RUBY(2), SAPPHIRE(2), DIAMOND(3);
	
	int harvestLevel = 0;
	
	EnumHarvestLevel(int par1HarvestLevel) {
		this.harvestLevel = par1HarvestLevel;
	}
	
	public int getHarvestLevel() {
		return this.harvestLevel;
	}
	
}