package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import java.util.Collection;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IEntityPropertySnapshot;

public interface IEntityPropertiesOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	public Collection<IEntityPropertySnapshot> getProperties();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IEntityPropertiesOutgoingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Entity Properties | Entity Id: %d", this.getEntityId());
	}
}
