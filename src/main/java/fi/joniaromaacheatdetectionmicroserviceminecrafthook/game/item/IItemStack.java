package fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.item;

public interface IItemStack
{
	public int getItemId();
	public int getMetadata();
	
	public boolean isAir();
	
	public static IItemStack item(int itemId)
	{
		return new StupItemStack()
		{
			@Override
			public int getItemId()
			{
				return itemId;
			}
			
			@Override
			public boolean isAir()
			{
				return false;
			}
		};
	}
	
	public static IItemStack air()
	{
		return new StupItemStack()
		{
			@Override
			public boolean isAir()
			{
				return true;
			}
		};
	}
	
	static class StupItemStack implements IItemStack
	{
		@Override
		public int getItemId()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getMetadata()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isAir()
		{
			throw new UnsupportedOperationException();
		}
	}
}
