package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network;

import java.util.Map;

public interface INetworkHook
{
	public IPacketBuffer createEmptyBuffer();
	
	public Map<Integer, Class<? extends IMinecraftPacket>> getIncomingPlayPackets();
	public Map<Integer, Class<? extends IMinecraftPacket>> getOutgoingPlayPackets();
}
