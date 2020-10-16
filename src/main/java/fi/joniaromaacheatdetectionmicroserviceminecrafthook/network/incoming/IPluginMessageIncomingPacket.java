package fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.shared.IPluginMessagePacket;
import io.netty.util.CharsetUtil;
import lombok.Getter;

public interface IPluginMessageIncomingPacket extends IMinecraftIncomingPacket
{
	public String getChannel();
	public IPacketBuffer getData();
	public Object getDataObject();

    @Override
	public default Class<? extends IMinecraftIncomingPacket> getBaseType()
	{
		return IPluginMessageIncomingPacket.class;
	}

    @Override
	public default String asString()
	{
		Object dataObject = this.getDataObject();
		if (dataObject == null)
		{
			byte[] buffer = new byte[this.getData().getBuffer().writerIndex()];
			
			this.getData().getBuffer().getBytes(0, buffer);
			
			return String.format("Plugin Message | Channel: %s | Raw: %s", this.getChannel(), new String(buffer, CharsetUtil.UTF_8));
		}
		else
		{
			return String.format("Plugin Message | %s", dataObject);
		}
	}
    
    public static Object buildDataObject(String channel, IPacketBuffer data)
    {
    	switch(channel)
    	{
	    	case "td:debug":
	    	{
	    		int id = data.readVarInt();
	    		switch(id)
	    		{
	    			case 0:
	    				return new DebugEntityMove(data);
	    			case 1:
	    				return new DebugEntityOops(data);
	    			case 2:
	    				return new DebugEntityAttack(data);
	    			case 3:
	    				return new DebugSPPreUpdate(data);
	    			case 4:
	    				return new DebugSPUpdate(data);
	    			case 5:
	    				return new DebugSPMove(data);
	    			case 6:
	    				return new DebugSPMoveFlying(data);
	    			case 7:
	    				return new DebugSPMoveFlyingAdd(data);
	    		}
	    		
		    	break;
	    	}
    	}

    	return IPluginMessagePacket.buildDataObject(channel, data);
    }
	
	public static class DebugEntityMove
	{
		@Getter private final int entityId;
		
		@Getter private final double x;
		@Getter private final double y;
		@Getter private final double z;

		@Getter private final double serverX;
		@Getter private final double serverY;
		@Getter private final double serverZ;
		
		private DebugEntityMove(IPacketBuffer in)
		{
			this.entityId = in.readVarInt();
			
			this.x = in.readDouble();
			this.y = in.readDouble();
			this.z = in.readDouble();
			
			this.serverX = in.readDouble();
			this.serverY = in.readDouble();
			this.serverZ = in.readDouble();
		}
		
		@Override
		public String toString()
		{
			return String.format("Debug Entity Move | Entity Id: %d | X: %s | Y: %s | Z: %s | Server X: %s | Server Y: %s | Server Z: %s", this.entityId, this.x, this.y, this.z, this.serverX, this.serverY, this.serverZ);
		}
	}
	
	public static class DebugEntityOops
	{
		@Getter private final int entityId;
		
		@Getter private final double x;
		@Getter private final double y;
		@Getter private final double z;

		@Getter private final double serverX;
		@Getter private final double serverY;
		@Getter private final double serverZ;
		
		private DebugEntityOops(IPacketBuffer in)
		{
			this.entityId = in.readVarInt();
			
			this.x = in.readDouble();
			this.y = in.readDouble();
			this.z = in.readDouble();
			
			this.serverX = in.readDouble();
			this.serverY = in.readDouble();
			this.serverZ = in.readDouble();
		}
		
		@Override
		public String toString()
		{
			return String.format("Debug Entity Oops | Entity Id: %d | X: %s | Y: %s | Z: %s | Server X: %s | Server Y: %s | Server Z: %s", this.entityId, this.x, this.y, this.z, this.serverX, this.serverY, this.serverZ);
		}
	}
	
	public static class DebugEntityAttack
	{
		@Getter private final int entityId;
		
		@Getter private final double x;
		@Getter private final double y;
		@Getter private final double z;

		@Getter private final double serverX;
		@Getter private final double serverY;
		@Getter private final double serverZ;

		@Getter private final double playerX;
		@Getter private final double playerY;
		@Getter private final double playerZ;

		@Getter private final float playerPitch;
		@Getter private final float playerYaw;
		
		private DebugEntityAttack(IPacketBuffer in)
		{
			this.entityId = in.readVarInt();
			
			this.x = in.readDouble();
			this.y = in.readDouble();
			this.z = in.readDouble();
			
			this.serverX = in.readDouble();
			this.serverY = in.readDouble();
			this.serverZ = in.readDouble();
			
			this.playerX = in.readDouble();
			this.playerY = in.readDouble();
			this.playerZ = in.readDouble();
			
			this.playerPitch = in.readFloat();
			this.playerYaw = in.readFloat();
		}
		
		@Override
		public String toString()
		{
			return String.format("Debug Entity Attack | Entity Id: %d | X: %s | Y: %s | Z: %s | Server X: %s | Server Y: %s | Server Z: %s | Player X: %s | Player Y: %s | Player Z: %s | Yaw: %s | Pitch: %s", this.entityId, this.x, this.y, this.z, this.serverX, this.serverY, this.serverZ, this.playerX, this.playerY, this.playerZ, this.playerYaw, this.playerPitch);
		}
	}
	
	public static class DebugSPPreUpdate
	{
		@Getter private final int entityId;
		
		private DebugSPPreUpdate(IPacketBuffer in)
		{
			this.entityId = in.readVarInt();
		}
		
		@Override
		public String toString()
		{
			return String.format("SP Pre Update | Entity Id: %d", this.entityId);
		}
	}
	
	public static class DebugSPUpdate
	{
		@Getter private final int entityId;
		
		private DebugSPUpdate(IPacketBuffer in)
		{
			this.entityId = in.readVarInt();
		}
		
		@Override
		public String toString()
		{
			return String.format("SP Update | Entity Id: %d", this.entityId);
		}
	}

	public static class DebugSPMove
	{
		@Getter private final int entityId;
		
		@Getter private final double x;
		@Getter private final double y;
		@Getter private final double z;
		
		private DebugSPMove(IPacketBuffer in)
		{
			this.entityId = in.readVarInt();
			
			this.x = in.readDouble();
			this.y = in.readDouble();
			this.z = in.readDouble();
		}
		
		@Override
		public String toString()
		{
			return String.format("SP Move | Entity Id: %d | X: %s | Y: %s | Z: %s", this.entityId, this.x, this.y, this.z);
		}
	}
	
	public static class DebugSPMoveFlying
	{
		@Getter private final int entityId;
		
		@Getter private final float strafe;
		@Getter private final float forward;
		@Getter private final float friction;
		
		@Getter private final boolean sprinting;
		
		private DebugSPMoveFlying(IPacketBuffer in)
		{
			this.entityId = in.readVarInt();
			
			this.strafe = in.readFloat();
			this.forward = in.readFloat();
			this.friction = in.readFloat();
			
			this.sprinting = in.readBoolean();
		}
		
		@Override
		public String toString()
		{
			return String.format("SP Move Flying | Entity Id: %d | Strafe: %f | Forward: %f | Friction: %f | Sprinting: %b", this.entityId, this.strafe, this.forward, this.friction, this.sprinting);
		}
	}

	public static class DebugSPMoveFlyingAdd
	{
		@Getter private final int entityId;
		
		@Getter private final double x;
		@Getter private final double z;
		
		private DebugSPMoveFlyingAdd(IPacketBuffer in)
		{
			this.entityId = in.readVarInt();
			
			this.x = in.readDouble();
			this.z = in.readDouble();
		}
		
		@Override
		public String toString()
		{
			return String.format("SP Move Add | Entity Id: %d | X: %s | Z: %s", this.entityId, this.x, this.z);
		}
	}
}
