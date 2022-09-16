
#### Iryna Podoprygora
### caching in Spring

source:  https://www.baeldung.com/spring-cache-tutorial
https://www.youtube.com/watch?v=xNwxpInjHto

#### @Cacheable
@Cacheable use in service method which return some value, that needed to be cached.
As a parameter  used name of that value. For example @Cacheable("customers").

#### @CacheEvict
if we do not need to store all cache for some requests, we can use 
@CacheEvict(value = "nameOfCacheEntry", allEntries=true)
For example we need to delete entry. We do not need to store this entry in cache.

#### @CachePut
The method will always be executed and the result cached.
If we want to change some data and out fresh data in cache




