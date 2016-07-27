# com.trip-boot

基于spring boot搭建的微服务基础平台。

1. 集成mybatis，通用mapper，分页插件
2. 集成druid连接池，web监控，读写分离
3. 集成jetbrick-template模板引擎
4. 集成redis缓存, 分布式session
5. 集成swagger rest文档生成
6. 集成shiro权限管理
7. 全局异常拦截

- trip-boot：项目根，父级pom
- trip-common：提供工具类，公共方法
- trip-core：提供统一组件，统一数据库持久化(redis，mybatis，mongo，消息队列等)
- trip-api-*：模块api
- trip-service-*：模块服务实现
- trip-web：web应用层
- trip-geteway：api路由网关
- trip-admin：JVM监控