package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IEntityOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	
	public int getServerX();
	public int getServerY();
	public int getServerZ();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IEntityOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Entity | Entity Id: %d | X: %s | Y: %s | Z: %s", this.getEntityId(), this.getServerX(), this.getServerY(), this.getServerZ());
	}
	
	public static IEntityOutgoingPacket newInstance(int entityId, int serverX, int serverY, int serverZ)
	{
		return new StupEntityOutgoingPacket()
		{
			@Override
			public int getEntityId()
			{
				return entityId;
			}

			@Override
			public int getServerX()
			{
				return serverX;
			}

			@Override
			public int getServerY()
			{
				return serverY;
			}

			@Override
			public int getServerZ()
			{
				return serverZ;
			}
		};
	}
	
	static class StupEntityOutgoingPacket implements IEntityOutgoingPacket
	{
		@Override
		public int getEntityId()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getServerX()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getServerY()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getServerZ()
		{
			throw new UnsupportedOperationException();
		}
	}
}
