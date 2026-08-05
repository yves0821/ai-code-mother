package edu.fdzc.aicodemother.config;

import dev.langchain4j.community.store.memory.chat.redis.RedisChatMemoryStore;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.data.redis")
@Data
public class RedisChatMemoryStoreConfig {

    private String host;

    private int port;

    private String password;

    private long ttl;

    @Bean
    public RedisChatMemoryStore redisChatMemoryStore() {

        // 添加日志查看配置值
        System.out.println("=== Redis Config Debug ===");
        System.out.println("host: " + host);
        System.out.println("port: " + port);
        System.out.println("password: " + password);
        System.out.println("password is null: " + (password == null));
        System.out.println("password is empty: " + "".equals(password));
        System.out.println("ttl: " + ttl);

        return RedisChatMemoryStore.builder()
                .host(host)
                .port(port)
                .user("default")
                .password(password)
                .ttl(ttl)
                .build();
    }

}
