package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface ICloseWindowOutgoingPacket extends IMinecraftOutgoingPacket
{
    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return ICloseWindowOutgoingPacket.class;
	}
}
