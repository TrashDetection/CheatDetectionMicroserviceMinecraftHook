package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network;

import io.netty.buffer.ByteBuf;

public interface IPacketBuffer
{
	public byte readByte();
	
	public boolean readBoolean();
	
	public int readVarInt();
	public int readInt();
	
	public float readFloat();
	public double readDouble();
	
	public String readString(int maxLength);
	public default String readString()
	{
		final int MAX = Integer.MAX_VALUE / 4;
		
		return this.readString(MAX);
	}
	
	public void setBuffer(ByteBuf buffer);
	
	public ByteBuf getBuffer();
}
