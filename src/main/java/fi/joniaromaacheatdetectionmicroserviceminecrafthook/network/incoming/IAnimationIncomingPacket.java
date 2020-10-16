package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IAnimationIncomingPacket extends IMinecraftIncomingPacket
{
    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IAnimationIncomingPacket.class;
	}
}
