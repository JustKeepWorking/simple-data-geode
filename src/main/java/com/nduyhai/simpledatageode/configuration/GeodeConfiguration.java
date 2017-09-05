package com.nduyhai.simpledatageode.configuration;

import com.nduyhai.simpledatageode.domain.Book;
import org.apache.geode.cache.GemFireCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;

@Configuration

public class GeodeConfiguration {

    @Autowired
    private GemfireConfiguration configuration;

    @Bean
    public CacheFactoryBean gemfireCache() throws Exception {

        CacheFactoryBean cacheFactory = new CacheFactoryBean();

        cacheFactory.setProperties(this.configuration.getGemfire());

        return cacheFactory;
    }

    @Bean
    public ReplicatedRegionFactoryBean<Integer, Book> bookRegion(GemFireCache gemFireCache) {
        ReplicatedRegionFactoryBean<Integer, Book> books = new ReplicatedRegionFactoryBean<>();

        books.setCache(gemFireCache);
        books.setName("book");
        books.setClose(true);
        books.setPersistent(false);
        return books;
    }
}
