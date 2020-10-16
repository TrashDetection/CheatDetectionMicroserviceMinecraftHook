package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network;

public interface IMinecraftOutgoingPacket extends IMinecraftPacket
{
    @Override
	public Class<? extends IMinecraftOutgoingPacket> getBaseType();
}
