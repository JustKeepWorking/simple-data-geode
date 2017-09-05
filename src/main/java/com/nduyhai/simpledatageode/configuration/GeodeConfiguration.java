package com.nduyhai.simpledatageode.configuration;

import com.nduyhai.simpledatageode.SimpleDataGeodeApplication;
import com.nduyhai.simpledatageode.domain.Book;
import org.apache.geode.cache.GemFireCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;

import java.util.Properties;
import java.util.UUID;

@Configuration
public class GeodeConfiguration {

    private String applicationName() {
        return String.join("-", SimpleDataGeodeApplication.class.getSimpleName(), UUID.randomUUID().toString());
    }

    @Bean
    public Properties gemfireProperties() {

        Properties gemfireProperties = new Properties();

        gemfireProperties.setProperty("name", this.applicationName());
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");

        return gemfireProperties;
    }

    @Bean
    @Autowired
    public CacheFactoryBean gemfireCache(@Qualifier("gemfireProperties") Properties gemfireProperties) throws Exception {

        CacheFactoryBean cacheFactory = new CacheFactoryBean();

        cacheFactory.setProperties(gemfireProperties);

        return cacheFactory;
    }

    @Bean
    public ReplicatedRegionFactoryBean<Integer, Book> bookRegion(GemFireCache gemFireCache) {
        ReplicatedRegionFactoryBean<Integer, Book> books = new ReplicatedRegionFactoryBean<>();

        books.setCache(gemFireCache);
        books.setClose(true);
        books.setPersistent(false);
        return books;
    }
}
