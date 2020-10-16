package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IChangeGameStateOutgoingPacaket extends IMinecraftOutgoingPacket
{
	public State getState();
	
	public float getValue();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IChangeGameStateOutgoingPacaket.class;
	}
    
    @Override
	public default String asString()
	{
    	return String.format("Change Game State | State: %s | Value: %s", this.getState(), this.getValue());
	}
	
	public static enum State
	{
		CANT_SLEEP,
		START_RAINING,
		STOP_RAINING,
		SET_GAMEMODE,
		END_CREDITS,
		DEMO,
		ARROW_HIT,
		RAIN_STRENGTH,
		THUNDER_STRENGTH,
		GUARDIAN_CURSE
	}
}
