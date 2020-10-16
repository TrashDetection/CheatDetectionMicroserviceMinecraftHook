package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IClientStatusIncomingPacket extends IMinecraftIncomingPacket
{
	public Status getStatus();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IClientStatusIncomingPacket.class;
	}
	
    public static enum Status
    {
        PERFORM_RESPAWN,
        REQUEST_STATS,
        OPEN_INVENTORY_ACHIEVEMENT;
    }
}
