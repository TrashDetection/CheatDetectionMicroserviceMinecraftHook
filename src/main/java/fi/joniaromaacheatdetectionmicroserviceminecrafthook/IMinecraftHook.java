package fi.joniaromaacheatdetectionmicroserviceminecrafthook;

import java.util.Arrays;
import java.util.List;

import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.IGameHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.IEntityHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttribute;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeInstance;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeMap;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.entity.attribute.IAttributeModifier;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.item.IItemStack;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.game.world.IWorldHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IMinecraftPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.INetworkHook;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.IPacketBuffer;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IAnimationIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IBlockPlaceIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IClickWindowIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IClientStatusIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.ICloseWindowIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IConfirmTransactionIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IHeldItemChangeIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IIncomingEntityActionIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IKeepAliveIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IPlayerAbilitiesIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IPlayerDiggingIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IPlayerIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IPluginMessageIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.incoming.IUseEntityIncomingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IAnimationOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IBulkChunkOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.ICameraOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IChangeGameStateOutgoingPacaket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IChunkOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.ICloseWindowOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IConfirmTransactionOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IDestroyEntitiesOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEnittyMetadataOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityAttachOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityEffectOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityPropertiesOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityStatusOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityTeleportOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IEntityVelocityOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IHeldItemChangeOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IJoinOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IKeepAliveOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IOpenWindowOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IPlayerAbilitiesOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IPlayerPositionAndLookOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IPluginMessageOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IRespawnOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.ISpawnPlayerOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IUpdateHealthOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.outgoing.IUseBedOutgoingPacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.network.shared.IPluginMessagePacket;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.shared.SharedMinecraftHooks;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IBlockPos;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IEntityPropertySnapshot;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IFacing;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IGamemode;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IPos;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IVectorPos;
import fi.joniaromaacheatdetectionmicroserviceminecrafthook.utils.IWatchableObject;
import io.netty.buffer.AbstractByteBufAllocator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCounted;

public interface IMinecraftHook
{
	public String getVersion();
	public int getProtocolVersion();
	
	public INetworkHook getNetworkHook();
	public IGameHook getGameHook();
	
	public static List<Class<?>> getClasses()
	{
		return Arrays.asList(
			//Game.Entity.Attribute
			IAttribute.class,
			IAttributeHook.class,
			IAttributeInstance.class,
			IAttributeMap.class,
			IAttributeModifier.class,
				IAttributeModifier.Modifier.class, //Inner class
			
			//Game.Entity
			IEntityHook.class,
				
			//Game.Item
			IItemStack.class,
			
			//Game.World
			IWorldHook.class,
			
			//Game
			IGameHook.class,
			
			//Network.Incoming
			IAnimationIncomingPacket.class,
			IBlockPlaceIncomingPacket.class,
			IClickWindowIncomingPacket.class,
				IClickWindowIncomingPacket.Mode.class, //Inner class
			IClientStatusIncomingPacket.class,
				IClientStatusIncomingPacket.Status.class, //Inner class
			ICloseWindowIncomingPacket.class,
			IConfirmTransactionIncomingPacket.class,
			IHeldItemChangeIncomingPacket.class,
			IIncomingEntityActionIncomingPacket.class,
				IIncomingEntityActionIncomingPacket.Action.class, //Inner class
			IKeepAliveIncomingPacket.class,
			IPlayerDiggingIncomingPacket.class,
				IPlayerDiggingIncomingPacket.Action.class, //Inner class
			IPlayerAbilitiesIncomingPacket.class,
			IPlayerIncomingPacket.class,
			IPluginMessageIncomingPacket.class,
				IPluginMessageIncomingPacket.DebugEntityMove.class, //Inner class
				IPluginMessageIncomingPacket.DebugEntityOops.class, //Inner class
				IPluginMessageIncomingPacket.DebugEntityAttack.class, //Inner class
				IPluginMessageIncomingPacket.DebugSPPreUpdate.class, //Inner class
				IPluginMessageIncomingPacket.DebugSPUpdate.class, //Inner class
				IPluginMessageIncomingPacket.DebugSPMove.class, //Inner class
				IPluginMessageIncomingPacket.DebugSPMoveFlying.class, //Inner class
				IPluginMessageIncomingPacket.DebugSPMoveFlyingAdd.class, //Inner class
			IUseEntityIncomingPacket.class,
				IUseEntityIncomingPacket.Action.class, //Inner class
			
			//Network.Outgoing
			IAnimationOutgoingPacket.class,
				IAnimationOutgoingPacket.Animation.class, //Inner class
			IBulkChunkOutgoingPacket.class,
			ICameraOutgoingPacket.class,
			IChangeGameStateOutgoingPacaket.class,
				IChangeGameStateOutgoingPacaket.State.class, //Inner class
			IChunkOutgoingPacket.class,
			ICloseWindowOutgoingPacket.class,
			IConfirmTransactionOutgoingPacket.class,
			IDestroyEntitiesOutgoingPacket.class,
			IEnittyMetadataOutgoingPacket.class,
			IEntityAttachOutgoingPacket.class,
			IEntityEffectOutgoingPacket.class,
			IEntityOutgoingPacket.class,
			IEntityPropertiesOutgoingPacket.class,
			IEntityStatusOutgoingPacket.class,
			IEntityTeleportOutgoingPacket.class,
			IEntityVelocityOutgoingPacket.class,
			IHeldItemChangeOutgoingPacket.class,
			IJoinOutgoingPacket.class,
			IKeepAliveOutgoingPacket.class,
			IOpenWindowOutgoingPacket.class,
			IPlayerAbilitiesOutgoingPacket.class,
			IPlayerPositionAndLookOutgoingPacket.class,
			IPluginMessageOutgoingPacket.class,
			IRespawnOutgoingPacket.class,
			ISpawnPlayerOutgoingPacket.class,
			IUpdateHealthOutgoingPacket.class,
			IUseBedOutgoingPacket.class,
			
			//Network.Shared
			IPluginMessagePacket.class,
			
			//Minecraft
			IMinecraftIncomingPacket.class,
			IMinecraftOutgoingPacket.class,
			IMinecraftPacket.class,
			INetworkHook.class,
			IPacketBuffer.class,
				ByteBuf.class, //IPacketBuffer requires
				ReferenceCounted.class, //IPacketBuffer requires
				ByteBufAllocator.class, //IPacketBuffer requires
				AbstractByteBufAllocator.class, //IPacketBuffer requires
			
			//Shared
			SharedMinecraftHooks.class,
			
			//Utils
			IBlockPos.class,
			IEntityPropertySnapshot.class,
			IFacing.class,
			IGamemode.class,
				IGamemode.Type.class, //Inner class
			IPos.class,
			IVectorPos.class,
			IWatchableObject.class,
			
			//Default
			IMinecraftHook.class
		);
	}
}
