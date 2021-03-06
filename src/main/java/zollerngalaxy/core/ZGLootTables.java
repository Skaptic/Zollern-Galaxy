/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core;

import net.minecraft.util.ResourceLocation;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ZGLootTables {
	
	// Mobs
	public static final ResourceLocation ENTITY_MOOLUS = CommonZGRegisterHelper.registerEntityLoot("moolus");
	public static final ResourceLocation ENTITY_OINKUS = CommonZGRegisterHelper.registerEntityLoot("oinkus");
	
	// Chests
	public static final ResourceLocation CHEST_EDEN_TOWER = CommonZGRegisterHelper.registerChestLoot("edentower");
	public static final ResourceLocation CHEST_GIANT_BONE = CommonZGRegisterHelper.registerChestLoot("giantbone");
	public static final ResourceLocation CHEST_BURIED_TREASURE = CommonZGRegisterHelper.registerChestLoot("buriedtreasure");
	public static final ResourceLocation CHEST_OCEAN_TREASURE = CommonZGRegisterHelper.registerChestLoot("oceantreasure");
	
	// Gameplay
	public static final ResourceLocation GAMEPLAY_FISHING = CommonZGRegisterHelper.registerGameplayLoot("zgfishing");
	
}