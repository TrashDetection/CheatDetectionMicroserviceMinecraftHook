package fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils;

import java.util.Collection;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeModifier;

public interface IEntityPropertySnapshot
{
	public String getName();
	public double getInitialValue();
	
	public Collection<IAttributeModifier> getModifiers();
}
