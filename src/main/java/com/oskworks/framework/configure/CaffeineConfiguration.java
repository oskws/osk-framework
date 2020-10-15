package com.oskworks.framework.configure;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CaffeineConfiguration {

    public static final int DEFAULT_MAXSIZE = 10000;
    public static final int DEFAULT_TTL = 600;
    /**
     * 定义cache名称、超时时长（秒）、最大容量
     * 每个cache缺省：10秒超时、最多缓存50000条数据，需要修改可以在构造方法的参数中指定。
     */
    public enum Caches{
        LOGIN_CACHE(600),          //有效期600秒
        listCustomers(7200,1000),  //有效期2个小时 , 最大容量1000
        ;
        Caches() {
        }
        Caches(int ttl) {
            this.ttl = ttl;
        }
        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }
        private int maxSize=DEFAULT_MAXSIZE;    //最大數量
        private int ttl=DEFAULT_TTL;        //过期时间（秒）
        public int getMaxSize() {
            return maxSize;
        }
        public int getTtl() {
            return ttl;
        }
    }

/*
    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager manager = new SimpleCacheManager();

        ArrayList<CaffeineCache> caches = new ArrayList<>();
        for (Caches c : Caches.values()) {
            caches.add(new CaffeineCache(c.name(),Caffeine.newBuilder()
                    .recordStats()
                    .expireAfterWrite(c.getTtl(),TimeUnit.SECONDS)
                    .maximumSize(c.getMaxSize()).build()));
        }

        manager.setCaches(caches);

        return manager;
    }

    @Bean
    public Cache cache() {
       return cacheManager().getCache(Caches.LOGIN_CACHE.name());
    }
*/

}
