package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IVectorPos;

public interface IUseEntityIncomingPacket extends IMinecraftIncomingPacket
{
	public int getEntityId();
	
	public Action getAction();
	
	public IVectorPos getPosition();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IUseEntityIncomingPacket.class;
	}
    
    @Override
    public default String asString()
    {
    	if (this.getAction() == IUseEntityIncomingPacket.Action.INTERACT_AT)
    	{
    		return String.format("Use Entity | Entity Id: %d | Action: %s | Position: %s", this.getEntityId(), this.getAction(), this.getPosition());
    	}
    	else
    	{
    		return String.format("Use Entity | Entity Id: %d | Action: %s", this.getEntityId(), this.getAction());
    	}
    }
	
	public static enum Action
	{
        INTERACT,
        ATTACK,
        INTERACT_AT;
	}
}
