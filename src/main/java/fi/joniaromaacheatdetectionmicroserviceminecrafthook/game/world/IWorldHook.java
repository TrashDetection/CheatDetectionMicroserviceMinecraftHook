package fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.world;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode;

public interface IWorldHook
{
	public IGamemode getGamemode(IGamemode.Type type);
}
