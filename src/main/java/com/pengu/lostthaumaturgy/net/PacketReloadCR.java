package com.pengu.lostthaumaturgy.net;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.mrdimka.hammercore.net.packetAPI.IPacket;
import com.mrdimka.hammercore.net.packetAPI.IPacketListener;
import com.pengu.lostthaumaturgy.api.RecipesCrucible;

public class PacketReloadCR implements IPacket, IPacketListener<PacketReloadCR, IPacket>
{
	@Override
	public IPacket onArrived(PacketReloadCR packet, MessageContext context)
	{
		RecipesCrucible.reloadRecipes();
		return null;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
	}
}