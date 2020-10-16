package fi.joniaromaacheatdetectionmicroserviceminecrafthook.shared;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.IMinecraftHook;

public class SharedMinecraftHooks
{
	private static final Map<String, IMinecraftHook> hooksByVersion = new HashMap<>();
	private static final Map<Integer, IMinecraftHook> hooksByProtocol = new HashMap<>();
	
	public static void init()
	{
		
	}
	
	public static void add(IMinecraftHook hook)
	{
		SharedMinecraftHooks.hooksByVersion.put(hook.getVersion(), hook);
		SharedMinecraftHooks.hooksByProtocol.put(hook.getProtocolVersion(), hook);
	}
	
	public static IMinecraftHook getHook(String version)
	{
		return SharedMinecraftHooks.hooksByVersion.get(version);
	}
	
	public static IMinecraftHook getHook(int protocolVersion)
	{
		return SharedMinecraftHooks.hooksByProtocol.get(protocolVersion);
	}
	
	public static Collection<IMinecraftHook> getHooks()
	{
		return SharedMinecraftHooks.hooksByVersion.values();
	}
}
