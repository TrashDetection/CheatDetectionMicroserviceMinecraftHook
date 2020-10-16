package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface ISpawnPlayerOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();

	public int getServerX();
	public int getServerY();
	public int getServerZ();
	
	public double getX();
	public double getY();
	public double getZ();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return ISpawnPlayerOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
    	return String.format("Spawn Player | Entity Id: %d | X: %s | Y: %s | Z: %s", this.getEntityId(), this.getX(), this.getY(), this.getZ());
	}
}
