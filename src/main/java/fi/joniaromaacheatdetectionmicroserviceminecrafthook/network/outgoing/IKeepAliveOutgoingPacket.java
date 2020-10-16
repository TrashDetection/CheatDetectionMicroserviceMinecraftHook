package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IKeepAliveOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getId();
	
    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IKeepAliveOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
    	return String.format("Keep Alive | Id: %d", this.getId());
	}
}
