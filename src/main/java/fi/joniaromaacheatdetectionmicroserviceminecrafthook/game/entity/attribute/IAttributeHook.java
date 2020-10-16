package fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute;

public interface IAttributeHook
{
	public IAttributeMap createAttributeMap();
	
	public IAttribute getSharedMovementSpeedAttribute();
}
