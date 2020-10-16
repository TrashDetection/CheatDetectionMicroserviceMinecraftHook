package fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute;

import java.util.UUID;

public interface IAttributeModifier
{
	public UUID getUniqueId();
	public double getAmount();
	public Modifier getModifier();
	
	public static enum Modifier
	{
		ADDITIVE,
		MULTIPLICATIVE_ADDITIVE,
		MULTIPLICATIVE_CURRENT,
	}
}
