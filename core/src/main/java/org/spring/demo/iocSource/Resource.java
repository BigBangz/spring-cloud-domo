package org.spring.demo.iocSource;

import java.util.Objects;

/**
 * @author bigbangz.github.io
 * @date 2024/4/3 15:50
 */
public class Resource {
    private String path;
    private String name;

    public Resource(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(path, resource.path) &&
                Objects.equals(name, resource.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, name);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
