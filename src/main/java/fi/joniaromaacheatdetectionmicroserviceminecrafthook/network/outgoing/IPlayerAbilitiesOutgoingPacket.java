package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IPlayerAbilitiesOutgoingPacket extends IMinecraftOutgoingPacket
{
	public boolean isInvulnerable();
	public boolean isFlying();
	public boolean isFlyingAllowed();
	public boolean isCreativeMode();
	
	public float getFlySpeed();
	public float getWalkSpeed();
	
    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IPlayerAbilitiesOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
		return String.format("Player Abilities | Invulnerable: %b | Flying: %b | Allow Flying: %b | Creative Mode: %b | Fly Speed: %f | Walk Speed: %f", this.isInvulnerable(), this.isFlying(), this.isFlyingAllowed(), this.isCreativeMode(), this.getWalkSpeed(), this.getFlySpeed());
	}
}
