package org.samo_lego.spawnershards.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public abstract class MixinBlock {
	@Inject(method = "onPlaced(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;)V", at = @At("HEAD"))
	private void onPlaced(World world_1, BlockPos blockPos_1, BlockState blockState_1, LivingEntity livingEntity_1, ItemStack itemStack_1, CallbackInfo ci) {
		BlockEntity blockEntity = world_1.getBlockEntity(blockPos_1);
		if (blockEntity instanceof MobSpawnerBlockEntity && itemStack_1.getTag() != null && itemStack_1.getTag().contains("BlockEntityTag")) {
			blockEntity.fromTag(itemStack_1.getTag().getCompound("BlockEntityTag"));
			blockEntity.setPos(blockPos_1);
			world_1.updateListeners(blockPos_1, world_1.getBlockState(blockPos_1), world_1.getBlockState(blockPos_1), 3);
		}
	}
}