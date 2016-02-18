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

package galaxymod.integration;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.event.FMLInterModComms;

public class ThermalExpansionHelper {
	
	public static void addCrucibleRecipe(int energy, ItemStack input,
			FluidStack output) {
		if (input == null || output == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setInteger("energy", energy);
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("output", new NBTTagCompound());
		input.writeToNBT(toSend.getCompoundTag("input"));
		output.writeToNBT(toSend.getCompoundTag("output"));
		FMLInterModComms.sendMessage("ThermalExpansion", "CrucibleRecipe",
				toSend);
	}
	
	public static void addSmelterBlastOre(String oreType) {
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setString("oreType", oreType);
		FMLInterModComms.sendMessage("ThermalExpansion", "SmelterBlastOreType",
				toSend);
	}
	
	public static void addTransposerExtract(int energy, ItemStack input,
			ItemStack output, FluidStack fluid, int chance, boolean reversible) {
		if (input == null || output == null || fluid == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setInteger("energy", energy);
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("output", new NBTTagCompound());
		toSend.setTag("fluid", new NBTTagCompound());
		input.writeToNBT(toSend.getCompoundTag("input"));
		output.writeToNBT(toSend.getCompoundTag("output"));
		toSend.setBoolean("reversible", reversible);
		toSend.setInteger("chance", chance);
		fluid.writeToNBT(toSend.getCompoundTag("fluid"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"TransposerExtractRecipe", toSend);
	}
	
	public static void addTransposerFill(int energy, ItemStack input,
			ItemStack output, FluidStack fluid, boolean reversible) {
		if (input == null || output == null || fluid == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setInteger("energy", energy);
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("output", new NBTTagCompound());
		toSend.setTag("fluid", new NBTTagCompound());
		input.writeToNBT(toSend.getCompoundTag("input"));
		output.writeToNBT(toSend.getCompoundTag("output"));
		toSend.setBoolean("reversible", reversible);
		fluid.writeToNBT(toSend.getCompoundTag("fluid"));
		FMLInterModComms.sendMessage("ThermalExpansion",
				"TransposerFillRecipe", toSend);
	}
	
	public static void addCompressionFuel(String fluidName, int energy) {
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setString("fluidName", fluidName);
		toSend.setInteger("energy", energy);
		FMLInterModComms.sendMessage("ThermalExpansion", "CompressionFuel",
				toSend);
	}
	
	public static void addReactantFuel(String fluidName, int energy) {
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setString("fluidName", fluidName);
		toSend.setInteger("energy", energy);
		FMLInterModComms
				.sendMessage("ThermalExpansion", "ReactantFuel", toSend);
	}
	
	public static void addCoolant(String fluidName, int energy) {
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setString("fluidName", fluidName);
		toSend.setInteger("energy", energy);
		FMLInterModComms.sendMessage("ThermalExpansion", "Coolant", toSend);
	}
	
	public static void addFurnaceRecipe(int energy, ItemStack input,
			ItemStack output) {
		if (input == null || output == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setInteger("energy", energy);
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("output", new NBTTagCompound());
		input.writeToNBT(toSend.getCompoundTag("input"));
		output.writeToNBT(toSend.getCompoundTag("output"));
		FMLInterModComms.sendMessage("ThermalExpansion", "FurnaceRecipe",
				toSend);
	}
	
	public static void addPulverizerRecipe(int energy, ItemStack input,
			ItemStack primaryOutput) {
		addPulverizerRecipe(energy, input, primaryOutput, null, 0);
	}
	
	public static void addPulverizerRecipe(int energy, ItemStack input,
			ItemStack primaryOutput, ItemStack secondaryOutput) {
		addPulverizerRecipe(energy, input, primaryOutput, secondaryOutput, 100);
	}
	
	public static void addPulverizerRecipe(int energy, ItemStack input,
			ItemStack primaryOutput, ItemStack secondaryOutput,
			int secondaryChance) {
		if (input == null || primaryOutput == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setInteger("energy", energy);
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("primaryOutput", new NBTTagCompound());
		if (secondaryOutput != null) {
			toSend.setTag("secondaryOutput", new NBTTagCompound());
		}
		input.writeToNBT(toSend.getCompoundTag("input"));
		primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));
		if (secondaryOutput != null) {
			secondaryOutput
					.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
			toSend.setInteger("secondaryChance", secondaryChance);
		}
		FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe",
				toSend);
	}
	
	public static void addSawmillRecipe(int energy, ItemStack input,
			ItemStack primaryOutput) {
		addSawmillRecipe(energy, input, primaryOutput, null, 0);
	}
	
	public static void addSawmillRecipe(int energy, ItemStack input,
			ItemStack primaryOutput, ItemStack secondaryOutput) {
		addSawmillRecipe(energy, input, primaryOutput, secondaryOutput, 100);
	}
	
	public static void addSawmillRecipe(int energy, ItemStack input,
			ItemStack primaryOutput, ItemStack secondaryOutput,
			int secondaryChance) {
		if (input == null || primaryOutput == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setInteger("energy", energy);
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("primaryOutput", new NBTTagCompound());
		if (secondaryOutput != null) {
			toSend.setTag("secondaryOutput", new NBTTagCompound());
		}
		input.writeToNBT(toSend.getCompoundTag("input"));
		primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));
		if (secondaryOutput != null) {
			secondaryOutput
					.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
			toSend.setInteger("secondaryChance", secondaryChance);
		}
		FMLInterModComms.sendMessage("ThermalExpansion", "SawmillRecipe",
				toSend);
	}
	
	public static void addSmelterRecipe(int energy, ItemStack primaryInput,
			ItemStack secondaryInput, ItemStack primaryOutput) {
		addSmelterRecipe(energy, primaryInput, secondaryInput, primaryOutput,
				null, 0);
	}
	
	public static void addSmelterRecipe(int energy, ItemStack primaryInput,
			ItemStack secondaryInput, ItemStack primaryOutput,
			ItemStack secondaryOutput) {
		addSmelterRecipe(energy, primaryInput, secondaryInput, primaryOutput,
				secondaryOutput, 100);
	}
	
	public static void addSmelterRecipe(int energy, ItemStack primaryInput,
			ItemStack secondaryInput, ItemStack primaryOutput,
			ItemStack secondaryOutput, int secondaryChance) {
		if (primaryInput == null || secondaryInput == null
				|| primaryOutput == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setInteger("energy", energy);
		toSend.setTag("primaryInput", new NBTTagCompound());
		toSend.setTag("secondaryInput", new NBTTagCompound());
		toSend.setTag("primaryOutput", new NBTTagCompound());
		if (secondaryOutput != null) {
			toSend.setTag("secondaryOutput", new NBTTagCompound());
		}
		primaryInput.writeToNBT(toSend.getCompoundTag("primaryInput"));
		secondaryInput.writeToNBT(toSend.getCompoundTag("secondaryInput"));
		primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));
		if (secondaryOutput != null) {
			secondaryOutput
					.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
			toSend.setInteger("secondaryChance", secondaryChance);
		}
		FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe",
				toSend);
	}
}