package fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeModifier;

public interface IEntityHook
{
	public IAttributeHook getAttributeHook();
	
	public IAttributeModifier getSprintingSpeedBoostModifier();
}
