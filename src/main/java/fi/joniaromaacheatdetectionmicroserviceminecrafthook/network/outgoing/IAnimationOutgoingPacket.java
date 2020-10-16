package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IAnimationOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	public Animation getAnimation();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IAnimationOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
    	return String.format("Animation | Entity Id: %d | Animation: %s", this.getEntityId(), this.getAnimation());
	}
	
	public static enum Animation
	{
		SWING,
		HURT,
		WAKE_UP,
		CONSUME,
		CRITICAL,
		MAGIC_CRITICAL
	}
}
