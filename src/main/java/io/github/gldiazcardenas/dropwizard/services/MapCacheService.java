package io.github.gldiazcardenas.dropwizard.services;

import com.hazelcast.core.HazelcastInstance;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
public class MapCacheService {

    private final Map<String, String> cache;

    @Inject
    public MapCacheService(HazelcastInstance instance) {
        this.cache = instance.getMap("cache");
    }


    public String get(String key) {
        return cache.get(key);
    }

    public String put(String key, String value) {
        return cache.put(key, value);
    }

}
