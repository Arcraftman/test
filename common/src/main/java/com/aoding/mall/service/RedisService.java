package com.aoding.mall.service;

import java.util.List;

public interface RedisService {

    void set(String key , Object value , long time);

    void set(String key , Object value);

    Object get(String key);

    Boolean del(String key);

    Long del(List<String> keys);

    Boolean expire(String key , long time);

    Long getExpire(String key);

    Boolean hasKey(String key);

    Long incr(String key ,long delta);


}
