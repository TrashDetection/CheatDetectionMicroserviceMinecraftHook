package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IEntityTeleportOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	
	public int getServerX();
	public int getServerY();
	public int getServerZ();
	
	public double getX();
	public double getY();
	public double getZ();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IEntityTeleportOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Entity Teleport | Entity Id: %d | X: %s | Y: %s | Z: %s", this.getEntityId(), this.getX(), this.getY(), this.getZ());
	}
	
	public static IEntityTeleportOutgoingPacket newInstance(int entityId, int serverX, int serverY, int serverZ)
	{
		return new StupEntityTeleportOutgoingPacket()
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
	
	static class StupEntityTeleportOutgoingPacket implements IEntityTeleportOutgoingPacket
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
		
		@Override
		public double getX()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public double getY()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public double getZ()
		{
			throw new UnsupportedOperationException();
		}
	}
}
