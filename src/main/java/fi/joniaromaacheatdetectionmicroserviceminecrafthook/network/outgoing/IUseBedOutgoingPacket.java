package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IBlockPos;

public interface IUseBedOutgoingPacket extends IMinecraftOutgoingPacket
{
	public int getEntityId();
	
	public IBlockPos getPosition();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IUseBedOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
    	return String.format("Use Bed | Entity Id: %d | Block Pos: %s", this.getEntityId(), this.getPosition());
	}
}
