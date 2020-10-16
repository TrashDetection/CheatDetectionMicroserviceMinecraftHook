package fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils;

public interface IGamemode
{
	public boolean isSurvivalOrAdventure();
	public boolean isCreative();
	public boolean isSpectator();

	public static enum Type
	{
		SURVIVAL,
		CREATIVE,
		ADVENTURE,
		SPECTATOR;
		
		private static final Type[] VALUES = Type.values();
		
		private final IGamemode gamemode;
		
		private Type()
		{
			this.gamemode = new StupGamemode(this);
		}

		public IGamemode getStupGamemode()
		{
			return this.gamemode;
		}
		
		public static Type valueOf(int value)
		{
			return Type.VALUES[value];
		}
	}
	
	static class StupGamemode implements IGamemode
	{
		private final IGamemode.Type type;
		
		public StupGamemode(IGamemode.Type type)
		{
			this.type = type;
		}
		
		@Override
		public boolean isSurvivalOrAdventure()
		{
			return this.type == IGamemode.Type.SURVIVAL || this.type == IGamemode.Type.ADVENTURE;
		}

		@Override
		public boolean isCreative()
		{
			return this.type == IGamemode.Type.CREATIVE;
		}

		@Override
		public boolean isSpectator()
		{
			return this.type == IGamemode.Type.SPECTATOR;
		}
	}
}
