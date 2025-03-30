package net.aluminis.ultimine.module;

import com.google.inject.Provides;
import net.aluminis.inject.api.annotation.ModId;
import net.aluminis.inject.api.model.AbstractModule;

public class DependencyModule extends AbstractModule {

    @Provides
    @ModId
    public String provideModId() {
        return "aluminis-ultimine";
    }
}
