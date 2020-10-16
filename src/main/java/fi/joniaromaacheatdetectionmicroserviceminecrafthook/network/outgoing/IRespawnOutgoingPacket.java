package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode;

public interface IRespawnOutgoingPacket extends IMinecraftOutgoingPacket
{
	public IGamemode getGamemode();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IRespawnOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Respawn | Gamemode: %s", this.getGamemode());
	}
	
	public static IRespawnOutgoingPacket newInstance(IGamemode.Type type)
	{
		return new StupRespawnOutgoingPacket()
		{
			@Override
			public IGamemode getGamemode()
			{
				return type.getStupGamemode();
			}
		};
	}
	
	static class StupRespawnOutgoingPacket implements IRespawnOutgoingPacket
	{
		@Override
		public IGamemode getGamemode()
		{
			throw new UnsupportedOperationException();
		}
	}
}
