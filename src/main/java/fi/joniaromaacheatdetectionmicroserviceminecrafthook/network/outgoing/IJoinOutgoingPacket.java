package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode;

public interface IJoinOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	
	public IGamemode getGamemode();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IJoinOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Join | Entity Id: %d | Gamemode: %s", this.getEntityId(), this.getGamemode());
	}
	
	public static IJoinOutgoingPacket newInstance(IGamemode.Type type)
	{
		return new StupJoinOutgoingPacket()
		{
			@Override
			public int getEntityId()
			{
				return 0;
			}

			@Override
			public IGamemode getGamemode()
			{
				return type.getStupGamemode();
			}
		};
	}
	
	static class StupJoinOutgoingPacket implements IJoinOutgoingPacket
	{
		@Override
		public int getEntityId()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public IGamemode getGamemode()
		{
			throw new UnsupportedOperationException();
		}
	}
}
