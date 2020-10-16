package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IEntityVelocityOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	
	public short getVelocityX();
	public short getVelocityY();
	public short getVelocityZ();
	
    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IEntityVelocityOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
    	return String.format("Entity Velocity | Entity Id: %d | Velocty X: %s | Velocty Y: %s | Velocty Z: %s", this.getEntityId(), this.getVelocityX(), this.getVelocityY(), this.getVelocityZ());
	}
}
