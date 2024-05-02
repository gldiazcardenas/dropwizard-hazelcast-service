package io.github.gldiazcardenas.dropwizard;

import com.google.inject.AbstractModule;
import com.hazelcast.config.ClasspathYamlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import io.github.gldiazcardenas.dropwizard.resources.HelloWorldResource;
import io.github.gldiazcardenas.dropwizard.resources.MapCacheResource;
import jakarta.inject.Singleton;

public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HelloWorldResource.class).in(Singleton.class);

        ClasspathYamlConfig hazelcastConfig = new ClasspathYamlConfig("configuration.yml");
        HazelcastInstance hazelcastInstance = Hazelcast.getOrCreateHazelcastInstance(hazelcastConfig);
        bind(HazelcastInstance.class).toInstance(hazelcastInstance);

        bind(MapCacheResource.class).in(Singleton.class);
    }

}
