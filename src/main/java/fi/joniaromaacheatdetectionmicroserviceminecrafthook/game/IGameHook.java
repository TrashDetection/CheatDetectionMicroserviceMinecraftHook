package fi.joniaromaacheatdetectionmicroserviceminecrafthook.game;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.IEntityHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.world.IWorldHook;

public interface IGameHook
{
	public IEntityHook getEntityHook();
	public IWorldHook getWorldHook();
}
