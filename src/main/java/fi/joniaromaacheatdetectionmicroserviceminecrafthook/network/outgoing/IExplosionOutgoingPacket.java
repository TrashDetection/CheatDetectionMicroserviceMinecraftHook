package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IExplosionOutgoingPacket extends IMinecraftOutgoingPacket
{
	public float getVelocityX();
	public float getVelocityY();
	public float getVelocityZ();
	
    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IExplosionOutgoingPacket.class;
	}
}
