package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;

public interface IEntityAttachOutgoingPacket extends IMinecraftOutgoingPacket
{
	public static final int DISMOUNT_VEHICLE_ID = -1;
	
	public int getEntityId();
	public int getVehicleId();
	
	public boolean isLeashed();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IEntityAttachOutgoingPacket.class;
	}
    
	@Override
	public default String asString()
	{
		return String.format("Entity Attach | Entity Id: %d | Vehicle Id: %d | Leashed: %b", this.getEntityId(), this.getVehicleId(), this.isLeashed());
	}
}
