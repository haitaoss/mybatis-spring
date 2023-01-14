package org.mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;
import java.util.Properties;

/**
 * @author haitao.chen
 * email haitaoss@aliyun.com
 * date 2023-01-12 21:51
 *
 */
@MapperScan(basePackages = "", annotationClass = Annotation.class, markerInterface = Class.class)
public class Test {

    @Bean
    public PropertyResourceConfigurer propertyResourceConfigurer() {
        System.out.println("配置");
        PropertyResourceConfigurer propertyResourceConfigurer = new PropertyResourceConfigurer() {
            @Override
            protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
                System.out.println(props);
            }
        };
        // propertyResourceConfigurer.setLocations();
        return propertyResourceConfigurer;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // sqlSessionFactoryBean.setConfigLocation();
        return sqlSessionFactoryBean;
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
    }
}
