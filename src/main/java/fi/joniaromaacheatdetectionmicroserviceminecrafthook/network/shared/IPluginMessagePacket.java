package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.shared;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import lombok.Getter;

public interface IPluginMessagePacket
{
    public static Object buildDataObject(String channel, IPacketBuffer data)
    {
    	switch(channel)
    	{
	    	case "FML|HS":
	    	{
	    		byte id = data.readByte();
	    		switch(id)
	    		{
	    			case 0:
	    				return new ForgeHandshake.ServerHello(data);
	    			case 1:
	    				return new ForgeHandshake.ClientHello(data);
	    			case 2:
	    				return new ForgeHandshake.ModList(data);
	    			case 3:
	    				return new ForgeHandshake.RegistryData(data);
	    			case -1:
	    				return new ForgeHandshake.HandshakeAck(data);
	    			case -2:
	    				return new ForgeHandshake.HandshakeReset(data);
	    		}
	    		break;
	    	}
	    	case "FORGE":
	    	{
	    		byte id = data.readByte();
	    		switch(id)
	    		{
	    			case 1:
	    				return new ForgeCodec.DimensionRegisterMessage(data);
	    			case 2:
	    				return new ForgeCodec.FluidIdMapMessage(data);
	    		}
	    		break;
	    	}
    	}
    	
    	return null;
    }
    
    public static class ForgeHandshake
    {
    	public static class ServerHello
    	{
    		@Getter private final byte protocolVersion;
    		@Getter private int overrideDimension;
    		
			public ServerHello(IPacketBuffer data)
			{
				this.protocolVersion = data.readByte();
				
				if (this.protocolVersion > 1)
				{
					this.overrideDimension = data.readInt();
				}
			}
			
			@Override
			public String toString()
			{
				return String.format("Forge Server Hello | Protocol Version: %d | Override Dimension: %d", this.protocolVersion, this.overrideDimension);
			}
    	}
    	
    	public static class ClientHello
    	{
    		@Getter private final byte protocolVersion;
    		
			public ClientHello(IPacketBuffer data)
			{
				this.protocolVersion = data.readByte();
			}
			
			@Override
			public String toString()
			{
				return String.format("Forge Client Hello | Protocol Version: %d", this.protocolVersion);
			}
    	}
    	
    	public static class ModList
    	{
    		private Map<String, String> mods;
    		
			public ModList(IPacketBuffer data)
			{
				int count = data.readVarInt();
				
				this.mods = new HashMap<>(count);
				
				for(int i = 0; i < count; i++)
				{
					this.mods.put(data.readString(), data.readString());
				}
			}
			
			@Override
			public String toString()
			{
				return String.format("Forge Mod List | Mods: %s", this.mods);
			}
    	}
    	
    	public static class RegistryData
    	{
    		@Getter private final boolean hasMore;
    		@Getter private final String name;
    		
    		@Getter private final Map<String, Integer> ids;
    		@Getter private final Set<String> substitutions;
    		@Getter private final Set<String> dummied;
    		
			public RegistryData(IPacketBuffer data)
			{
				this.hasMore = data.readBoolean();
				this.name = data.readString();
				
				int idsCount = data.readVarInt();
				
				this.ids = new HashMap<>(idsCount);
				for(int i = 0; i < idsCount; i++)
				{
					this.ids.put(data.readString(), data.readVarInt());
				}
				
				int substitutionsCount = data.readVarInt();
				
				this.substitutions = new HashSet<>(substitutionsCount);
				for(int i = 0; i < substitutionsCount; i++)
				{
					this.substitutions.add(data.readString());
				}
				
				if (!data.getBuffer().isReadable())
				{
					this.dummied = Collections.emptySet();
					
					return;
				}

				int dummiedCount = data.readVarInt();
				
				this.dummied = new HashSet<>(dummiedCount);
				for(int i = 0; i < dummiedCount; i++)
				{
					this.dummied.add(data.readString());
				}
			}
			
			@Override
			public String toString()
			{
				return String.format("Forge Registry Data | Has More: %b | Name: %s | Ids: %s | Substitutions: %s | Dummied: %s", this.hasMore, this.name, this.ids, this.substitutions, this.dummied);
			}
    	}
    	
    	public static class HandshakeAck
    	{
    		private final byte phase;
    		
			public HandshakeAck(IPacketBuffer data)
			{
				this.phase = data.readByte();
			}
			
			@Override
			public String toString()
			{
				return String.format("Forge Handshake Ack | Phase: %d", this.phase);
			}
    	}
    	
    	public static class HandshakeReset
    	{
			public HandshakeReset(IPacketBuffer data)
			{
				
			}
			
			@Override
			public String toString()
			{
				return "Forge Handshake Reset";
			}
    	}
    }
    
    public static class ForgeCodec
    {
    	public static class DimensionRegisterMessage
    	{
    		public DimensionRegisterMessage(IPacketBuffer data)
    		{
    			
    		}
    	}
    	
    	public static class FluidIdMapMessage
    	{
    		public FluidIdMapMessage(IPacketBuffer data)
    		{
    			
    		}
    	}
    }
}
