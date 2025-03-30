package net.aluminis.ultimine.model.listener;

import net.aluminis.inject.api.model.AbstractListener;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

public class PlayerBlockBreakListener extends AbstractListener<PlayerBlockBreakEvents.Before> {
    public PlayerBlockBreakListener() {
        super(PlayerBlockBreakEvents.BEFORE);
    }

    @Override
    public PlayerBlockBreakEvents.Before on() {
        return (world, player, blockPos, blockState, blockEntity) -> {
            //System.out.print(player.getName().toString() + " tried to break a " + blockState.getBlock().getName().getString());

            return true;
        };
    }
}
