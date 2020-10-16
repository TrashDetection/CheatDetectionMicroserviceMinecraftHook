package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IHeldItemChangeOutgoingPacket extends IMinecraftOutgoingPacket
{
	public byte getSlot();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IHeldItemChangeOutgoingPacket.class;
	}
}
