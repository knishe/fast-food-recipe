package com.mycompany.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Component
    public static class CachingSetup implements JCacheManagerCustomizer {

        @Override
        public void customize(CacheManager cacheManager) {
            cacheManager.createCache("recipe", new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy
                            .factoryOf(new Duration(TimeUnit.SECONDS, 10)))
                    .setStoreByValue(false).setStatisticsEnabled(true));
        }
    }

    @CacheResult
    public Recipe getRecipe(String recipeCode) {
        LOGGER.info("Recipe {} not found in cache. TimeStamp: {}", recipeCode, new Date());
        return recipeRepository.findByRecipeCode(recipeCode);
    }
}
