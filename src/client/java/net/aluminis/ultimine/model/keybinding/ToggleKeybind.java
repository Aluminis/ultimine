package net.aluminis.ultimine.model.keybinding;

import com.google.inject.Inject;
import net.aluminis.inject.api.annotation.ModId;
import net.aluminis.inject.api.model.AbstractKeybind;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;
import org.slf4j.LoggerFactory;

public class ToggleKeybind extends AbstractKeybind {

    private String modId;

    @Inject
    public ToggleKeybind(@ModId String modId) {
        super("keybind." + modId + ".toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_GRAVE_ACCENT, "category." + modId);
        this.modId = modId;
    }

    @Override
    public void on(MinecraftClient client) {
        assert client.player != null;
        assert client.crosshairTarget != null;
        if (client.crosshairTarget.getType() == HitResult.Type.BLOCK) {
            assert client.world != null;

            BlockPos blockPosition = ((BlockHitResult) client.crosshairTarget).getBlockPos();
            Block block = client.world.getBlockState(blockPosition).getBlock();

            client.world.breakBlock(blockPosition, true);
            LoggerFactory.getLogger(modId).info("Selected block: {} at x={} y={} z={}", block.getName().getContent(), blockPosition.getX(), blockPosition.getY(), blockPosition.getZ());
        }
    }
}
