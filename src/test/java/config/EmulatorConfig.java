package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/emulator.properties"})

public interface EmulatorConfig extends Config {

    @DefaultValue("")
    @Key("platformName")
    String platformName();

    @DefaultValue("")
    @Key("deviceName")
    String deviceName();

    @DefaultValue("")
    @Key("version")
    String version();

    @DefaultValue("")
    @Key("locale")
    String locale();

    @DefaultValue("")
    @Key("language")
    String language();

    @DefaultValue("")
    @Key("appPackage")
    String appPackage();

    @DefaultValue("")
    @Key("appActivity")
    String appActivity();
}