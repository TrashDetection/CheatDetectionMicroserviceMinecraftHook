package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IKeepAliveIncomingPacket extends IMinecraftIncomingPacket
{
	public int getId();
	
    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IKeepAliveIncomingPacket.class;
	}

    @Override
	public default String asString()
	{
    	return String.format("Keep Alive | Id: %d", this.getId());
	}
}
