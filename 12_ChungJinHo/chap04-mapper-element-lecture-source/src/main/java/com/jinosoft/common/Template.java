package com.jinosoft.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class for creating and managing SqlSession instances.
 * SqlSession 인스턴스를 생성하고 관리하는 유틸리티 클래스입니다.
 */
public class Template {
  // SqlSessionFactory는 어플리케이션 생명주기 동안 하나만 존재해야 하므로 static으로 선언합니다.
  private static SqlSessionFactory sqlSessionFactory;

  /**
   * SqlSession 객체를 반환하는 메소드입니다.
   * 첫 호출 시 SqlSessionFactory를 생성하고, 이후에는 생성된 팩토리에서 세션을 엽니다.
   * 
   * @return SqlSession 인스턴스
   */
  public static SqlSession getSqlSession() {
    if (sqlSessionFactory == null) {
      String resource = "config/mybatis-config.xml";
      try {
        // mybatis-config.xml 설정 파일을 읽어옵니다.
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // SqlSessionFactoryBuilder를 사용하여 SqlSessionFactory를 생성합니다.
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    // SqlSession을 생성하여 반환합니다. false는 AutoCommit을 비활성화함을 의미합니다.
    return sqlSessionFactory.openSession(false);
  }
}