package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.shared.IPluginMessagePacket;
import io.netty.util.CharsetUtil;

public interface IPluginMessageOutgoingPacket extends IMinecraftOutgoingPacket
{
	public String getChannel();
	public IPacketBuffer getData();
	public Object getDataObject();
	
    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IPluginMessageOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		Object dataObject = this.getDataObject();
		if (dataObject == null)
		{
			byte[] buffer = new byte[this.getData().getBuffer().writerIndex()];
			
			this.getData().getBuffer().getBytes(0, buffer);
			
			return String.format("Plugin Message | Channel: %s | Raw: %s", this.getChannel(), new String(buffer, CharsetUtil.UTF_8));
		}
		else
		{
			return String.format("Plugin Message | %s", dataObject);
		}
	}
    
    public static Object buildDataObject(String channel, IPacketBuffer data)
    {
    	return IPluginMessagePacket.buildDataObject(channel, data);
    }
}
