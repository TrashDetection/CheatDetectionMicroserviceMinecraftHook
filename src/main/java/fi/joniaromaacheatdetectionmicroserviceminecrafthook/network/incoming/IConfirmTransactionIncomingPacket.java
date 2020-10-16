package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IConfirmTransactionIncomingPacket extends IMinecraftIncomingPacket
{
	public static final short CONFIRM_TRANSACTION_PREV_ID = -5;
	public static final short CONFIRM_TRANSACTION_ID = -3;
	
	public byte getWindowId();
	
	public short getActionNumber();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IConfirmTransactionIncomingPacket.class;
	}
    
    @Override
	public default String asString()
	{
    	return String.format("Confirm Transaction | Window Id: %d | Action Number: %d", this.getWindowId(), this.getActionNumber());
	}
	
	public static IConfirmTransactionIncomingPacket newPreConfirmInstance()
	{
		return new StupConfirmTransactionIncomingPacket()
		{
			@Override
			public byte getWindowId()
			{
				return IClickWindowIncomingPacket.PLAYER_INVENTORY_ID;
			}

			@Override
			public short getActionNumber()
			{
				return IConfirmTransactionIncomingPacket.CONFIRM_TRANSACTION_PREV_ID;
			}
		};
	}
	
	public static IConfirmTransactionIncomingPacket newConfirmInstance()
	{
		return new StupConfirmTransactionIncomingPacket()
		{
			@Override
			public byte getWindowId()
			{
				return IClickWindowIncomingPacket.PLAYER_INVENTORY_ID;
			}

			@Override
			public short getActionNumber()
			{
				return IConfirmTransactionIncomingPacket.CONFIRM_TRANSACTION_ID;
			}
		};
	}
	
	static class StupConfirmTransactionIncomingPacket implements IConfirmTransactionIncomingPacket
	{
		@Override
		public byte getWindowId()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public short getActionNumber()
		{
			throw new UnsupportedOperationException();
		}
	}
}
