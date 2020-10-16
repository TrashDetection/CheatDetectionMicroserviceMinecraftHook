package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IBulkChunkOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getCount();
	
	public int getChunkX(int i);
	public int getChunkZ(int i);
	
	public int[] getXPositions();
	public int[] getZPositions();
	
	public default long getChunkPair(int i)
	{
        return (long)this.getChunkX(i) & 4294967295L | ((long)this.getChunkZ(i) & 4294967295L) << 32;
	}

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IBulkChunkOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
    	int count = this.getCount();
    	
    	int[] xPos = this.getXPositions();
    	int[] zPos = this.getZPositions();
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < count; i++)
    	{
    		if (i > 0)
    		{
    			sb.append(", ");
    		}
    		
    		sb.append('(');
    		sb.append(xPos[i]);
    		sb.append(", ");
    		sb.append(zPos[i]);
    		sb.append(')');
    	}
    	
    	return String.format("Bulk Chunk | Pairs: %s", sb.toString());
	}
}
