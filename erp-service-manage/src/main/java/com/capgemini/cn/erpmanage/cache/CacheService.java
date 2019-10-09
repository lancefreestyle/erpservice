package com.capgemini.cn.erpmanage.cache;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@ConditionalOnClass(value = {RedisProperties.class, StringRedisTemplate.class, RedisTemplate.class})
public class CacheService {
    private StringRedisTemplate stringRedisTemplate;
    private Gson gson;

    @Autowired
    public CacheService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.gson = new Gson();
    }

    public boolean cacheObject(final String cachekey, Object cacheObject, long timeout,TimeUnit timeUnit) {
        Assert.notNull(cachekey, "缓存项目标识不能为Null！");
        Assert.notNull(cacheObject, "需要缓存的对象值不能为Null！");
        boolean result = false;
        try {
            final String jsonValue = gson.toJson(cacheObject);
            this.stringRedisTemplate.opsForValue().set(cachekey, jsonValue, timeout, timeUnit);
            result = true;
        } catch (Exception e) {
            log.error("向缓存中存储用户信息时出错！", e);
        }
        return result;
    }


    public boolean cacheObject(final String cachekey, String cacheObject, long timeout,TimeUnit timeUnit) {
        Assert.notNull(cachekey, "缓存项目标识不能为Null！");
        Assert.notNull(cacheObject, "需要缓存的对象值不能为Null！");
        boolean result = false;
        try {
            this.stringRedisTemplate.opsForValue().set(cachekey, cacheObject, timeout, timeUnit);
            result = true;
        } catch (Exception e) {
            log.error("向缓存中存储用户信息时出错！", e);
        }
        return result;
    }

    public <T> T getObject(final String cachekey, Class<T> returnType) {
    	Assert.notNull(cachekey, "缓存项目标识不能为Null！");
        Assert.notNull(returnType, "返回对象类型不能为Null！");
        T result = null;
        try {
            final String cacheValue = this.stringRedisTemplate.opsForValue().get(cachekey);
            if (!StringUtils.isEmpty(cacheValue)) {

                result = gson.fromJson(cacheValue, returnType);
            }
        } catch (Exception e) {
            log.error("从缓存中读取用户信息时出错！", e);
        }
        return result;
    }

    public String getObject(final String cachekey) {
        Assert.notNull(cachekey, "缓存项目标识不能为Null！");
        String result = null;
        try {
            result = this.stringRedisTemplate.opsForValue().get(cachekey);
        } catch (Exception e) {
            log.error("从缓存中读取用户信息时出错！", e);
        }
        return result;
    }


    public void deleteObject(final String cachekey) {
        this.stringRedisTemplate.delete(cachekey);
    }

    public  int decrement(String key, int delta) {
        Long value = stringRedisTemplate.opsForValue().increment(key, -delta);
        return value.intValue();
    }

    public  int increment(String key, int delta) {
        Long value = stringRedisTemplate.opsForValue().increment(key, delta);
        return value.intValue();
    }

}
