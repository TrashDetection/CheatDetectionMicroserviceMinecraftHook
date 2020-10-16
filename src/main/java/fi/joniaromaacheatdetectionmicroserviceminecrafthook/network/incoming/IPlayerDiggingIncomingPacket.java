package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IFacing;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IPos;

public interface IPlayerDiggingIncomingPacket extends IMinecraftIncomingPacket
{
	public IPos getPosition();
	public IFacing getFacing();
	public Action getAction();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IPlayerDiggingIncomingPacket.class;
	}
	
    @Override
    public default String asString()
    {
    	return String.format("Digging | Pos: %s | Facing: %s | Action: %s", this.getPosition(), this.getFacing(), this.getAction());
    }
    
    public static enum Action
    {
        START_DESTROY_BLOCK,
        ABORT_DESTROY_BLOCK,
        STOP_DESTROY_BLOCK,
        DROP_ALL_ITEMS,
        DROP_ITEM,
        RELEASE_USE_ITEM;
    }
    
    public static IPlayerDiggingIncomingPacket action(IPlayerDiggingIncomingPacket.Action action)
    {
    	return new StupPlayerDiggingIncomingPacket()
		{
    		@Override
    		public Action getAction()
    		{
    			return action;
    		}
		};
    }
    
    static class StupPlayerDiggingIncomingPacket implements IPlayerDiggingIncomingPacket
    {
		@Override
		public IPos getPosition()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public IFacing getFacing()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public Action getAction()
		{
			throw new UnsupportedOperationException();
		}
    }
}
