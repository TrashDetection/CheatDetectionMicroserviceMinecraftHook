package fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute;

public interface IAttributeInstance
{
	public void setBaseValue(double value);
	public void removeAllModifiers();
	
	public boolean hasModifier(IAttributeModifier modifier);
	
    public void removeModifier(IAttributeModifier modifier);
	public void applyModifier(IAttributeModifier modifier);
	
    public double getAttributeValue();
}
