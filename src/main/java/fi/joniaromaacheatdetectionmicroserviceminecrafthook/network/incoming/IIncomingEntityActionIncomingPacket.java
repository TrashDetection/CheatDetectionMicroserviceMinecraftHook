package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IIncomingEntityActionIncomingPacket extends IMinecraftIncomingPacket
{
	public int getEntityId();
	public Action getAction();
	public int getAuxData();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IIncomingEntityActionIncomingPacket.class;
	}
    
    @Override
    public default String asString()
    {
    	return String.format("Entity Action | Entity Id: %d | Action: %s | Aux: %d", this.getEntityId(), this.getAction(), this.getAuxData());
    }
	
	public static enum Action
	{
        START_SNEAKING,
        STOP_SNEAKING,
        STOP_SLEEPING,
        START_SPRINTING,
        STOP_SPRINTING,
        RIDING_JUMP,
        OPEN_INVENTORY;
	}
	
	public static IIncomingEntityActionIncomingPacket newInstance(IIncomingEntityActionIncomingPacket.Action action)
	{
		return new StupIncomingEntityActionIncomingPacket()
		{
			@Override
			public Action getAction()
			{
				return action;
			}
		};
	}
	
	static class StupIncomingEntityActionIncomingPacket implements IIncomingEntityActionIncomingPacket
	{
		@Override
		public Action getAction()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getEntityId()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getAuxData()
		{
			throw new UnsupportedOperationException();
		}
	}
}
