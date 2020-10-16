package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network;

import java.io.IOException;

public interface IMinecraftPacket
{
	public default void readPacket(IPacketBuffer buffer) throws IOException
	{
		throw new UnsupportedOperationException(this.getClass().toString());
	}

    public default boolean isAsync()
    {
    	return false;
    }

	public default Class<? extends IMinecraftPacket> getBaseType()
	{
		throw new UnsupportedOperationException(this.getClass().toString());
	}
	
	public default String asString()
	{
		return this.getClass().toString();
	}
}
