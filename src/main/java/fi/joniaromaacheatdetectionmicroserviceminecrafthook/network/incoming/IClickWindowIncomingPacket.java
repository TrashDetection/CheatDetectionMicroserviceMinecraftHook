package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.item.IItemStack;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;

public interface IClickWindowIncomingPacket extends IMinecraftIncomingPacket
{
	public static final int PLAYER_INVENTORY_ID = 0;
	
	public byte getWindowId();
	public short getSlot();
	
	public Mode getMode();
	public byte getButton();
	
	public short getActionNumber();
	
	public IItemStack getItem();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IClickWindowIncomingPacket.class;
	}

    @Override
	public default String asString()
	{
		return String.format("Click Window | Window Id: %d | Slot: %d | Mode: %s | Button: %d | Action Number: %d | Item: %s", this.getWindowId(), this.getSlot(), this.getMode(), this.getButton(), this.getActionNumber(), this.getItem());
	}
	
	public static enum Mode
	{
		CLICK,
		SHIFT_CLICK,
		HOTBAR,
		MIDDLE_CLICK,
		DROP,
		DRAG,
		DOUBLE_CLICK
	}
}
