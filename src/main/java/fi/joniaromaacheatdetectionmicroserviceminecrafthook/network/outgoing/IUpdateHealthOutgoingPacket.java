package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IUpdateHealthOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getFood();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IUpdateHealthOutgoingPacket.class;
	}
}
