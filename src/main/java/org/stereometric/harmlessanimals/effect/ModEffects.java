package org.stereometric.harmlessanimals.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> PAIN = registerStatusEffect("pain",
            new PainEffect(StatusEffectCategory.HARMFUL, 0x0)
                    .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED,
                            Identifier.of(HarmlessAnimals.MOD_ID, "pain_particle"), -0.2f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(HarmlessAnimals.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        HarmlessAnimals.LOGGER.info("Registering StatusEffects for" +  HarmlessAnimals.MOD_ID);
    }
}
