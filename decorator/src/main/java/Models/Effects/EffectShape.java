package Models.Effects;

import javafx.scene.effect.*;
import java.util.EnumMap;
public class EffectShape {
    private final EnumMap<EffectEnum, Effect> effectEnumMap;

    public EffectShape() {
        effectEnumMap = new EnumMap<>(EffectEnum.class);
        initializeEffects();
    }

    private void initializeEffects() {
        // 1. Эффект "Нет эффекта"
        effectEnumMap.put(EffectEnum.NONE, null);

        // 2. Внешняя тень (DropShadow)
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(javafx.scene.paint.Color.rgb(0, 0, 0, 0.6));
        effectEnumMap.put(EffectEnum.DROP_SHADOW, dropShadow);

        // 3. Размытие (Blur)
        BoxBlur blur = new BoxBlur();
        blur.setWidth(5);
        blur.setHeight(5);
        blur.setIterations(3);
        effectEnumMap.put(EffectEnum.BLUR, blur);

        // 4. Внутренняя тень (InnerShadow)
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setRadius(10);
        innerShadow.setOffsetX(3);
        innerShadow.setOffsetY(3);
        innerShadow.setColor(javafx.scene.paint.Color.rgb(0, 0, 0, 0.7));
        effectEnumMap.put(EffectEnum.INNER_SHADOW, innerShadow);
    }

    public Effect getEffect(EffectEnum effectType) {
        return effectEnumMap.get(effectType);
    }

    public EnumMap<EffectEnum, Effect> getAllEffects() {
        return new EnumMap<>(effectEnumMap);
    }
}