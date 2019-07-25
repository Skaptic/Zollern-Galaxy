package zollerngalaxy.events;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.util.CachedEnum;

public class ZGEvents {
	
	// My way around loot tables. Use a randomized integer to get a chance for a
	// specific mob to drop an item or items.
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity theEntity = event.getEntityLiving();
		World worldObj = theEntity.world;
		Random rand = new Random();
		int randInt = rand.nextInt(100);
		
		// Moolus (Alien Cow)
		if (theEntity instanceof EntityMoolus) {
			for (int i = 0; i < ZGHelper.rngNumber(1, 4); i++) {
				ZGHelper.dropItem(ZGItems.rawAlienBeef, worldObj, theEntity);
			}
		} else if (theEntity instanceof EntityOinkus) {
			// Oinkus (Alien Pig)
			for (int i = 0; i < ZGHelper.rngNumber(1, 4); i++) {
				ZGHelper.dropItem(ZGItems.rawAlienBacon, worldObj, theEntity);
			}
		}
	}
	
	@SubscribeEvent
	public void onUseHoe(UseHoeEvent event) {
		if (event.getResult() != Result.DEFAULT || event.isCanceled()) {
			return;
		}
		
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		
		if (world.isAirBlock(pos.up())) {
			if (block instanceof ZGBlockGrass || block instanceof ZGBlockDirt) {
				this.setFarmland(event, world, pos, Blocks.FARMLAND);
			}
		}
	}
	
	private void setFarmland(UseHoeEvent event, World world, BlockPos pos, IBlockState state,
			IProperty<?> property, Object value, Block dirt, Block farmland) {
		if (state.getValue(property) == value) {
			world.setBlockState(pos, dirt.getDefaultState());
		} else {
			world.setBlockState(pos, farmland.getDefaultState());
		}
		event.setResult(Result.ALLOW);
		world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundType.GROUND.getStepSound(),
				SoundCategory.BLOCKS, (SoundType.GROUND.getVolume() + 1.0F) / 2.0F,
				SoundType.GROUND.getPitch() * 0.8F);
		
		for (EnumHand hand : CachedEnum.valuesHandCached()) {
			event.getEntityPlayer().swingArm(hand);
		}
	}
	
	private void setFarmland(UseHoeEvent event, World world, BlockPos pos, Block farmland) {
		world.setBlockState(pos, farmland.getDefaultState());
		event.setResult(Result.ALLOW);
		world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundType.GROUND.getStepSound(),
				SoundCategory.BLOCKS, (SoundType.GROUND.getVolume() + 1.0F) / 2.0F,
				SoundType.GROUND.getPitch() * 0.8F);
		
		for (EnumHand hand : CachedEnum.valuesHandCached()) {
			event.getEntityPlayer().swingArm(hand);
		}
	}
}