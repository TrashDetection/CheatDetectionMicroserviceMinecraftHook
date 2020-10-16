package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import java.util.Collection;
import java.util.stream.Collectors;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IWatchableObject;

public interface IEnittyMetadataOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	public Collection<IWatchableObject> getWatchedObjects();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IEnittyMetadataOutgoingPacket.class;
	}
	
	@Override
	public default String asString()
	{
		return String.format("Entity Metadata | Entity Id: %d | Objects: %s", this.getEntityId(), this.getWatchedObjects().stream().map((w) -> w.asString()).collect(Collectors.joining(", ")));
	}
}
