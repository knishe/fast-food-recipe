package com.mycompany.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 */

@Component
@CacheDefaults(cacheName = "recipe")
public class RecipeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeService.class);

    @Component
    public  static class CachingSetup implements JCacheManagerCustomizer{

        @Override
        public void customize(CacheManager cacheManager) {
            cacheManager.createCache("recipe",new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy
                            .factoryOf(new Duration(TimeUnit.SECONDS,10)))
                    .setStoreByValue(false).setStatisticsEnabled(true));
        }
    }

    @CacheResult
    public Recipe getRecipe(int id){
        LOGGER.info("ssn " + id + " not found in cache. TimeStamp: {}", new Date());
        switch (id){
            case 101:
                return new Recipe(101,"Chicken");
            case 102:
                return new Recipe(102,"Sandwich");
            default:
                return new Recipe(100,"Burger");
        }
    }
}
