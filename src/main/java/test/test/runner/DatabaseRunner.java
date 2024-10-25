package test.test.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

@Component
@Order(1)
@Slf4j
public class DatabaseRunner implements ApplicationRunner {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Autowired
    DataSource dataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("DataSource 구현객체는 {} ", dataSource.getClass().getName());

        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            log.info("DB Product Name = {}", metaData.getDatabaseProductName());
            log.info("DB URL = {}", metaData.getURL());
            log.info("DB Username = {}", metaData.getUserName());
        }

        try {
            InetAddress address = InetAddress.getByName("redis-master-cs");
            System.out.println("Redis Hostname: " + address.getHostName());
            System.out.println("Redis IP Address: " + address.getHostAddress());
            System.out.println("Configured Redis Host: " + redisHost);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("===> Arguments 정보 <===");
        args.getOptionNames().forEach(System.out::println);
    }
}