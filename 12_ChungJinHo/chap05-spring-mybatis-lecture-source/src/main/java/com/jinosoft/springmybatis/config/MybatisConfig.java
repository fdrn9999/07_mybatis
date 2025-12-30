package com.jinosoft.springmybatis.config;

import com.jinosoft.springmybatis.section01.factorybean.MenuMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Bean 등록 + 내부 메서드 모두 실행행서 설정 등록
public class MybatisConfig {
  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Value("${spring.datasource.jdbc-url}")
  private String jdbcUrl;

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;

  @Bean
  public HikariDataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setJdbcUrl(jdbcUrl);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    /* 커넥션 풀 설정 */

    /* 커넥션 획득 대기 시간 */
    dataSource.setConnectionTimeout(30000);

    dataSource.setMaximumPoolSize(5);

    dataSource.setIdleTimeout(600000);

    dataSource.setMaxLifetime(1800000);

    return dataSource;
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {

    org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
    configuration.getTypeAliasRegistry().registerAliases("com.jinosoft.springmybatis.section01.factorybean");
    configuration.addMapper(MenuMapper.class);
    configuration.setMapUnderscoreToCamelCase(true);

    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource());
    sqlSessionFactoryBean.setConfiguration(configuration);

    return sqlSessionFactoryBean.getObject();

  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate() throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory());
  }
}
