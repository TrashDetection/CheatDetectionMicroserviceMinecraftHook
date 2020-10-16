package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IOpenWindowOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getWindowId();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IOpenWindowOutgoingPacket.class;
	}
}
