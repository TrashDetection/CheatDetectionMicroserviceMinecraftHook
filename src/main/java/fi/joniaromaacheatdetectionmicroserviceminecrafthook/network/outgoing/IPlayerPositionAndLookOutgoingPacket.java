package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IPlayerPositionAndLookOutgoingPacket extends IMinecraftOutgoingPacket
{
	public double getX();
	public double getY();
	public double getZ();
	
	public float getYaw();
	public float getPitch();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IPlayerPositionAndLookOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
		return String.format("Player Teleport | X: %s | Y: %s | Z: %s | Yaw: %s | Pitch: %s", this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
	}
    
	public static IMinecraftOutgoingPacket newInstance(double x, double y, double z)
	{
		return new StupPlayerPositionAndLookOutgoingPacket()
		{
			@Override
			public double getX()
			{
				return x;
			}

			@Override
			public double getY()
			{
				return y;
			}

			@Override
			public double getZ()
			{
				return z;
			}
		};
	}
	
	static class StupPlayerPositionAndLookOutgoingPacket implements IPlayerPositionAndLookOutgoingPacket
	{
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

		@Override
		public float getYaw()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public float getPitch()
		{
			throw new UnsupportedOperationException();
		}
	}
}
