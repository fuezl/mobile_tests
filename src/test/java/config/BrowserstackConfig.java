package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/browserstack.properties"})

public interface BrowserstackConfig extends Config {
    @DefaultValue("")
    @Key("browserstackUser")
    String browserstackUser();

    @DefaultValue("")
    @Key("browserstackKey")
    String browserstackKey();

    @DefaultValue("")
    @Key("appUrl")
    String appUrl();

    @DefaultValue("")
    @Key("device")
    String device();

    @DefaultValue("")
    @Key("osVersion")
    String osVersion();

    @DefaultValue("")
    @Key("project")
    String project();

    @DefaultValue("")
    @Key("build")
    String build();

    @DefaultValue("")
    @Key("name")
    String name();
}