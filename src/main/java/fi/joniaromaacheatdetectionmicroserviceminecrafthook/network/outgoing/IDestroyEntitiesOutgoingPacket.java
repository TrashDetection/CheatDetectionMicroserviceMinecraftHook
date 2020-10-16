package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import java.util.Collection;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IDestroyEntitiesOutgoingPacket extends IMinecraftOutgoingPacket
{
	public Collection<Integer> getEntityIds();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IDestroyEntitiesOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Destroy Entities | Entities: %s", this.getEntityIds());
	}
}
