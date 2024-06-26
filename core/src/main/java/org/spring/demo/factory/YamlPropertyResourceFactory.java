package org.spring.demo.factory;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

/**
 * @PropertySource注解支持读取 YMAL文件
 */
public class YamlPropertyResourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource encodedResource) throws IOException {
        String resourceName = Optional.ofNullable(name).orElse(encodedResource.getResource().getFilename());
        if (resourceName.endsWith(".yml") || resourceName.endsWith(".yaml")) {//yaml资源文件
            List<PropertySource<?>> yamlSources = new YamlPropertySourceLoader().load(resourceName, encodedResource.getResource());
            return yamlSources.get(0);
        } else {//返回空的Properties
            return new PropertiesPropertySource(resourceName, new Properties());
        }
    }
}