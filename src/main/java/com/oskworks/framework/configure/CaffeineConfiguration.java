package com.oskworks.framework.configure;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.Scheduler;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.service.IDeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//@EnableCaching
@Slf4j
@Configuration
public class CaffeineConfiguration {

    public static final int DEFAULT_MAXSIZE = 10000;
    public static final int DEFAULT_TTL = 600;

    /**
     * 定义cache名称、超时时长（秒）、最大容量
     * 每个cache缺省：10秒超时、最多缓存50000条数据，需要修改可以在构造方法的参数中指定。
     */
    public enum Caches {
        LOGIN_CACHE(600),          //有效期600秒
        listCustomers(7200, 1000),  //有效期2个小时 , 最大容量1000
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

        private int maxSize = DEFAULT_MAXSIZE;    //最大數量
        private int ttl = DEFAULT_TTL;        //过期时间（秒）

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

    @Bean
    public LoadingCache<String, Device> cache(IDeviceService deviceService) {

        return Caffeine.newBuilder()
                .expireAfterAccess(5, TimeUnit.MINUTES)
                .scheduler(Scheduler.forScheduledExecutorService(Executors.newScheduledThreadPool(1)))
                .removalListener((key, value, removalCause) -> {
                    deviceService.lambdaUpdate()
                            .eq(Device::getDeviceNo, key)
                            .set(Device::getDeviceOnlineState, Device.DeviceOnlineState.OFFLINE)
                            .set(Device::getChangeStateTime, LocalDateTime.now())
                            .update();
                    log.info("设备掉线：{}", key);
                })
//                .evictionListener((o, o2, removalCause) -> {
//                    System.out.println("ev-key:"+o +",val:"+o2 +",case"+removalCause.name());
//                })
                .build(key -> {
                    Device device = deviceService.lambdaQuery().eq(Device::getDeviceNo, key).one();

                    if (Objects.isNull(device)) {
                        return null;
                    }
                    device.setChangeStateTime(LocalDateTime.now());
                    device.setDeviceOnlineState(Device.DeviceOnlineState.ONLINE);
                    deviceService.updateById(device);
                    return device;
                });
    }
}
