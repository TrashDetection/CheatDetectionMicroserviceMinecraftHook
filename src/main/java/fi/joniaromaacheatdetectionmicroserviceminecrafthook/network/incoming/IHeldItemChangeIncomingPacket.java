package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IHeldItemChangeIncomingPacket extends IMinecraftIncomingPacket
{
	public short getSlot();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IHeldItemChangeIncomingPacket.class;
	}
}
