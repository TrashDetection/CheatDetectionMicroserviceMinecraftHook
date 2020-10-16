package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IEntityStatusOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	
	public byte getStatus();
	
    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IEntityStatusOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Entity Status | Entity Id: %d | Status: %d", this.getEntityId(), this.getStatus());
	}
}
