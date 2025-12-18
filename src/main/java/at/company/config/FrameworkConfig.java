package at.company.config;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config.properties")

public interface FrameworkConfig extends Config {

    @Key("baseurl.login")
    String loginUrl();

    String browser();
}
