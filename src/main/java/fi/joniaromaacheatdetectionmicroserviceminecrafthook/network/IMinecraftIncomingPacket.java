package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network;

public interface IMinecraftIncomingPacket extends IMinecraftPacket
{
    @Override
	public Class<? extends IMinecraftIncomingPacket> getBaseType();
}
