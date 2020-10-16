package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface ICloseWindowIncomingPacket extends IMinecraftIncomingPacket
{
    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return ICloseWindowIncomingPacket.class;
	}
}
