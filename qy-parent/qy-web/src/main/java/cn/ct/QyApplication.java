package cn.ct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.ct.dao")
@EnableTransactionManagement
public class QyApplication {

    public static void main(String[] args) {
        SpringApplication.run(QyApplication.class, args);
    }

}
