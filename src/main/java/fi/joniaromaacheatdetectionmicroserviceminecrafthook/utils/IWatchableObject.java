package fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils;

public interface IWatchableObject
{
	public int getDataValueId();
    public Object getWatchedObject();
    
    public default String asString()
    {
    	return String.format("%d=%s", this.getDataValueId(), this.getWatchedObject());
    }
}
