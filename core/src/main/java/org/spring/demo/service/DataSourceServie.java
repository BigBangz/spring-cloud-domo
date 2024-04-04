package org.spring.demo.service;

import org.spring.demo.annotation.MetricTime;
import org.spring.demo.annotation.MyComponentScan;
import org.spring.demo.util.ReaderFile;
import org.spring.demo.entity.DataSourcBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 多数据源模拟类
 */
@Component
public class DataSourceServie {

    private ReaderFile readerFile;

    private DataSourcBean dataSourcOne;

    private DataSourcBean dataSourcTwo;

    public DataSourceServie(ReaderFile readerFile,
                            @Qualifier("one") DataSourcBean dataSourcOne,
                            @Qualifier("two") DataSourcBean dataSourcTwo){
        this.readerFile = readerFile;
        this.dataSourcOne = dataSourcOne;
        this.dataSourcTwo = dataSourcTwo;
    }

    @Value("#{readerFile.sourceOne}")
    private String source;

    @MetricTime("getDataSourceServie")
    public void getDataSourceServie() {
        System.out.println(dataSourcOne.getUsername() + readerFile.getDateSourceName().get(0) + source);
        System.out.println(dataSourcTwo.getUsername() + readerFile.getDateSourceName().get(1));
    }
}
