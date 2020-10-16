package fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute;

public interface IAttributeMap
{
	public IAttributeInstance registerAttribute(IAttribute attribute);
	
	public IAttributeInstance getAttributeInstance(IAttribute attribute);
	public IAttributeInstance getAttributeInstanceByName(String name);
}
