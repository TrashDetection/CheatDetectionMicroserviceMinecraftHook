package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IEntityEffectOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	
	public byte getEffectId();
	public byte getAmplifier();
	
	public int getDuration();
	
    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IEntityEffectOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Entity Effect | Entity Id: %d | Effect Id: %d | Amplifier: %d | Duration: %d", this.getEntityId(), this.getEffectId(), this.getAmplifier(), this.getDuration());
	}
}
