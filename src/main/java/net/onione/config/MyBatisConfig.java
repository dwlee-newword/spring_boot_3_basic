package net.onione.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Bean(name = "hcSqlSessionFactory")
    public SqlSessionFactory hcSqlSessionFactory(DataSource dataSource) throws Exception {
        return createSqlSessionFactory(dataSource, "classpath:mapper/hc/*.xml");
    }
    @Bean
    public SqlSessionTemplate hcSqlSessionTemplate(@Qualifier("hcSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "mcSqlSessionFactory")
    public SqlSessionFactory mcSqlSessionFactory(DataSource dataSource) throws Exception {
        return createSqlSessionFactory(dataSource, "classpath:mapper/mc/*.xml");
    }
    @Bean
    public SqlSessionTemplate mcSqlSessionTemplate(@Qualifier("mcSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * SqlSessionFactory 생성 메소드
     *
     * @param dataSource - DataSource 가 추가될 경우 주입해줘야함
     * @param mapperLocation - 매퍼 디렉토리 설정 classpath:mapper/{prefix}/*.xml
     * */
    private SqlSessionFactory createSqlSessionFactory(DataSource dataSource, String mapperLocation) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));

        org.apache.ibatis.session.Configuration mybatisConfig = new org.apache.ibatis.session.Configuration();
        mybatisConfig.setMapUnderscoreToCamelCase(true); // map-underscore-to-camel-case 설정 추가
        sessionFactory.setConfiguration(mybatisConfig);

        return sessionFactory.getObject();
    }

    @Bean
    public MapperScannerConfigurer hcMapperScannerConfigurer() {
        return createMapperScannerConfigurer("net.onione.data.mapper.hc", "hcSqlSessionFactory", "hc");
    }

    @Bean
    public MapperScannerConfigurer mcMapperScannerConfigurer() {
        return createMapperScannerConfigurer("net.onione.data.mapper.mc", "mcSqlSessionFactory", "mc");
    }

    /**
     * MapperScannerConfigurer 생성 메소드
     *
     * @param basePackage - 스캔할 Mapper 인터페이스 패키지
     * @param sqlSessionFactoryBeanName - SqlSessionFactoryBean 을 이름으로 찾아서 스캔한 Mapper 인터페이스에 세팅
     * @param prefix - Mapper 인터페이스의 이름에 접두사를 추가하여 빈 이름 충돌 방지
     * */
    private MapperScannerConfigurer createMapperScannerConfigurer(String basePackage, String sqlSessionFactoryBeanName, String prefix) {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage(basePackage);
        scannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
        scannerConfigurer.setNameGenerator((beanDefinition, registry) -> prefix + beanDefinition.getBeanClassName());
        return scannerConfigurer;
    }

}
