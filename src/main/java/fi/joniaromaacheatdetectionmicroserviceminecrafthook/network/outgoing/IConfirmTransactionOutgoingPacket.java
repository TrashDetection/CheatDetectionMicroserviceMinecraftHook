package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IClickWindowIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IConfirmTransactionIncomingPacket;

public interface IConfirmTransactionOutgoingPacket extends IMinecraftOutgoingPacket
{
	public byte getWindowId();
	
	public short getActionNumber();

    @Override
	public default Class<? extends IMinecraftOutgoingPacket> getBaseType()
	{
		return IConfirmTransactionOutgoingPacket.class;
	}
    
    @Override
	public default String asString()
	{
    	return String.format("Confirm Transaction | Window Id: %d | Action Number: %d", this.getWindowId(), this.getActionNumber());
	}

	public static IConfirmTransactionOutgoingPacket newPreConfirmInstance()
	{
		return new StupConfirmTransactionOutgoingPacket()
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
	
	public static IConfirmTransactionOutgoingPacket newConfirmInstance()
	{
		return new StupConfirmTransactionOutgoingPacket()
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
	
	static class StupConfirmTransactionOutgoingPacket implements IConfirmTransactionOutgoingPacket
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
