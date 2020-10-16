package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IChunkOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getChunkX();
	public int getChunkZ();
	
	public boolean isFullChunk();
	
	public int getExtractedDataLength();
	
	public default long getChunkPair()
	{
        return (long)this.getChunkX() & 4294967295L | ((long)this.getChunkZ() & 4294967295L) << 32;
	}

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IChunkOutgoingPacket.class;
	}
    
    @Override
    public default String asString()
    {
    	return String.format("Chunk | X: %d | Z: %d | Full: %b | Data Length: %d", this.getChunkX(), this.getChunkZ(), this.isFullChunk(), this.getExtractedDataLength());
    }
    
	public static IChunkOutgoingPacket chunkUnload(int x, int z)
	{
		return new StupChunkOutgoingPacket()
		{
			@Override
			public int getChunkX()
			{
				return x;
			}

			@Override
			public int getChunkZ()
			{
				return z;
			}

			@Override
			public boolean isFullChunk()
			{
				return true;
			}

			@Override
			public int getExtractedDataLength()
			{
				return 0;
			}
		};
	}
	
	static class StupChunkOutgoingPacket implements IChunkOutgoingPacket
	{
		@Override
		public int getChunkX()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getChunkZ()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isFullChunk()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getExtractedDataLength()
		{
			throw new UnsupportedOperationException();
		}
	}
}
