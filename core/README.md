# Spring IOC 
## AOP
## Bean校驗

| HTTP 方法 | 路径 | 描述 | 是否默认启用 |  
| ----| ---- | ---- | ---- |   
| GET | /auditevents | 生成已触发的任何审核事件的报告。 | 否 |
| GET | /beans | 描述 Spring 应用程序上下文中的所有 bean。 | 否 |
| GET | /conditions | 对于在应用程序上下文中创建的 bean，自动配置条件校验通过或失败的报告。 | 否 |
| GET | /configprops | 描述所有配置属性以及当前值。 | 否 |
| GET, POST, DELETE | /env | 生成 Spring 应用程序可用的所有属性源及其属性的报告。 | 否 |
| GET | /env/{toMatch} | 描述单个环境属性的值。 | 否 |
| GET | /health | 返回应用程序的聚合运行状况和（可能）外部相关应用程序的运行状况。 | 是 |
| GET | /heapdump | 下载堆转储信息。 | 否 |
| GET | /httptrace | 生成最近 100 个请求的跟踪记录。 | 否 |
| GET | /info | 返回开发人员自定义的应用程序信息。 | 是 |
| GET | /loggers | 生成应用程序中包的列表，及其配置的有效日志级别。 | 否 |
| GET, POST | /loggers/{name} | 返回某个 logger 的有效日志记录级别，并可以通过 POST 请求设置日志级别。 | 否 |
| GET | /mappings | 生成关于所有 HTTP 映射及其相应处理方法的报告。 | 否 |
| GET | /metrics | 返回所有度量指标类别的列表。 | 否 |
| GET | /metrics/{name} | 返回某度量的多维值的集合。 | 否 |
| GET | /scheduledtasks | 列出所有计划任务 | 否 |
| GET | /threaddump | 返回所有应用程序线程的报告。 | 否 |