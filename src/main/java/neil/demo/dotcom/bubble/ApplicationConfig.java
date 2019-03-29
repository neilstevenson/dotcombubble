package neil.demo.dotcom.bubble;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.ClasspathYamlConfig;
import com.hazelcast.config.Config;

@Configuration
public class ApplicationConfig {

	@Bean
    public Config config() {
		return new ClasspathYamlConfig("application.yml");
    }

}
