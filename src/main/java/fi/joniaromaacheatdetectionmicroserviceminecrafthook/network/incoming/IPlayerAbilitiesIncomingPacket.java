package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IPlayerAbilitiesIncomingPacket extends IMinecraftIncomingPacket
{
	public boolean isFlying();
	public boolean isFlyingAllowed();
	
	public float getFlySpeed();
	public float getWalkSpeed();
	
    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IPlayerAbilitiesIncomingPacket.class;
	}
}
