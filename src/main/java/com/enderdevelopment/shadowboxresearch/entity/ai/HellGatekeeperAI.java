package com.enderdevelopment.shadowboxresearch.entity.ai;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import com.enderdevelopment.shadowboxresearch.entity.HellGatekeeperEntity;

import java.util.EnumSet;

public class HellGatekeeperAI extends Goal {
    private final HellGatekeeperEntity entity;
    private Player targetPlayer;

    public HellGatekeeperAI(HellGatekeeperEntity entity) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        this.targetPlayer = this.entity.level.getNearestPlayer(this.entity, 16.0D);
        return this.targetPlayer != null;
    }

    @Override
    public void start() {
        this.entity.getNavigation().moveTo(this.targetPlayer, 1.0D);
    }

    @Override
    public void tick() {
        if (this.targetPlayer != null) {
            this.entity.getLookControl().setLookAt(this.targetPlayer, 30.0F, 30.0F);
            if (this.entity.distanceToSqr(this.targetPlayer) < 2.0D) {
                this.entity.getNavigation().stop();
            } else {
                this.entity.getNavigation().moveTo(this.targetPlayer, 1.0D);
            }
        }
    }
}