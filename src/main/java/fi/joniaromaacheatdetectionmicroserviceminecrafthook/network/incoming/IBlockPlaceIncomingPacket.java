package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.item.IItemStack;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IBlockPos;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IFacing;

public interface IBlockPlaceIncomingPacket extends IMinecraftIncomingPacket
{
	public IBlockPos getPosition();
	public IFacing getFacing();
	
	public IItemStack getItem();
	
	public float getFacingX();
	public float getFacingY();
	public float getFacingZ();
	
	public boolean isInteract();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IBlockPlaceIncomingPacket.class;
	}
    
    @Override
    public default String asString()
    {
    	if (!this.isInteract())
    	{
    		return String.format("Block Place | Pos: %s | Facing: %s | Facing X: %f | Facing Y: %f | Facing Z: %f | Item: %s", this.getPosition(), this.getFacing(), this.getFacingX(), this.getFacingY(), this.getFacingZ(), this.getItem());
    	}
    	else
    	{
    		return String.format("Item Interact | Pos: %s | Facing X: %f | Facing Y: %f | Facing Z: %f | Item: %s", this.getPosition(), this.getFacingX(), this.getFacingY(), this.getFacingZ(), this.getItem());
    	}
	}
    
    public static IBlockPlaceIncomingPacket interact(IItemStack item)
    {
    	return new StupBlockPlaceIncomingPacket()
		{
			@Override
			public IItemStack getItem()
			{
				return item;
			}
			
			@Override
			public boolean isInteract()
			{
				return true;
			}
		};
    }
    
    static class StupBlockPlaceIncomingPacket implements IBlockPlaceIncomingPacket
	{
		@Override
		public IBlockPos getPosition()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public IFacing getFacing()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public IItemStack getItem()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public float getFacingX()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public float getFacingY()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public float getFacingZ()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isInteract()
		{
			throw new UnsupportedOperationException();
		}
	}
}
