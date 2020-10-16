package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface ICameraOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return ICameraOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
    	return String.format("Camera | Entity Id: %d", this.getEntityId());
	}
}
