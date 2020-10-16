package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IPlayerIncomingPacket extends IMinecraftIncomingPacket
{
	public double getX();
	public double getY();
	public double getZ();
	
	public float getYaw();
	public float getPitch();

	public boolean isOnGround();
	public boolean isMoving();
	public boolean isRotating();
	
	public default int getChunkX()
	{
		return (int)this.getX() >> 4;
	}
	
	public default int getChunkZ()
	{
		return (int)this.getZ() >> 4;
	}

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IPlayerIncomingPacket.class;
	}

    @Override
	public default String asString()
	{
		if (this.isMoving() && this.isRotating())
		{
			return String.format("Player | On Ground: %b | X: %s | Y: %s | Z: %s | Yaw: %s | Pitch: %s", this.isOnGround(), this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
		}
		else if (this.isMoving())
		{
			return String.format("Player | On Ground: %b | X: %s | Y: %s | Z: %s", this.isOnGround(), this.getX(), this.getY(), this.getZ());
		}
		else if (this.isRotating())
		{
			return String.format("Player | On Ground: %b | Yaw: %s | Pitch: %s", this.isOnGround(), this.getYaw(), this.getPitch());
		}
		else
		{
			return String.format("Player | On Ground: %b", this.isOnGround());
		}
	}
	
    public static IPlayerIncomingPacket ground()
	{
    	return new StupPlayerIncomingPacket()
		{
			@Override
			public boolean isOnGround()
			{
				return true;
			}

			@Override
			public boolean isMoving()
			{
				return false;
			}

			@Override
			public boolean isRotating()
			{
				return false;
			}
		};
	}
    
	public static IPlayerIncomingPacket ground(double x, double y, double z)
	{
		return new StupPlayerIncomingPacket()
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
			
			@Override
			public boolean isOnGround()
			{
				return true;
			}

			@Override
			public boolean isMoving()
			{
				return true;
			}

			@Override
			public boolean isRotating()
			{
				return false;
			}
		};
	}
    
	public static IPlayerIncomingPacket fly(double x, double y, double z)
	{
		return new StupPlayerIncomingPacket()
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
			
			@Override
			public boolean isOnGround()
			{
				return false;
			}

			@Override
			public boolean isMoving()
			{
				return true;
			}

			@Override
			public boolean isRotating()
			{
				return false;
			}
		};
	}
	
	static class StupPlayerIncomingPacket implements IPlayerIncomingPacket
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
		public boolean isMoving()
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

		@Override
		public boolean isRotating()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isOnGround()
		{
			throw new UnsupportedOperationException();
		}
	}
}
