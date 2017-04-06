# fast-food-recipe
It is a webservice that fetches recipes by the id and stores the frequent accessed recipe within a cache

## How to run

```
mvn spring-boot:run
```

## What it does?

The following is the sample webservice to get the recipe as a JSON


Example:

localhost:8080/recipe?id=101

The following log results shows when the recipe loaded to the cache.

```
2017-04-06 22:07:16.688  INFO 8574 --- [nio-8080-exec-1] com.mycompany.recipe.RecipeService       : Recipe 101 not found in cache. TimeStamp: Thu Apr 06 22:07:16 IST 2017
2017-04-06 22:07:16.702  INFO 8574 --- [hcache [null]-0] com.mycompany.recipe.CacheEventLogger    : Event: CREATED Key: 101 old value: null new value: Recipe{id=101, description='Chicken'}
```