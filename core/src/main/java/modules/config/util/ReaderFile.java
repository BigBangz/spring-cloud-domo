package modules.config.util;

import com.alibaba.fastjson.JSON;
import modules.config.annotation.MetricTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用Resource读取文件
 */
@Component
public class ReaderFile {
    @Value("classpath:/application.yml")
    private Resource yamlResource;

    @Value("classpath:/config/dateSource.json")
    private Resource dateResource;

    private String yamlSource;

    private String dateSource;

    @Value("${source}")
    private String sourceOne;

    private String sourceTwo;

    public String getSourceOne() {
        return sourceOne;
    }

    public String getSourceTwo() {
        return sourceTwo;
    }

    @PostConstruct
    public void init() throws IOException {
        try (var reader = new BufferedReader(
                new InputStreamReader(yamlResource.getInputStream(), StandardCharsets.UTF_8))) {
            this.yamlSource = reader.lines().collect(Collectors.joining("\n"));
        }
        try (var reader = new BufferedReader(
                new InputStreamReader(dateResource.getInputStream(), StandardCharsets.UTF_8))) {
            this.dateSource = reader.lines().collect(Collectors.joining("\n"));
        }
        System.out.println(sourceOne);
    }

    public List<String> getDateSourceName() {
        return JSON.parseObject(this.dateSource, List.class);
    }
}
