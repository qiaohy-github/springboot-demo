package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工 Mapper 接口
 *
 * @author qiaohy
 * @since 2021-11-11
 */
//@Mapper  在接口类上添加了@Mapper，在运行时会生成相应的接口实现类,如果想要每个接口都要变成实现类，
            //那么需要在每个接口类上加上@Mapper注解，比较麻烦，解决这个问题在启动类上加上@MapperScan
/**
 * @Mapper 是mybatis自身带的注解。在spring程序中，mybatis需要找到对应的mapper，在编译时生成动态代理类，与数据库进行交互，这时需要用到@Mapper注解
 *
 *但是有时候当我们有很多mapper接口时，就需要写很多@Mappe注解，这样很麻烦，有一种简便的配置化方法便是在启动类上使用@MapperScan注解。
 *这样可以自动扫描包路径下所有的mapper接口，从而不用再在接口上添加任何注解。
 */

//@Repository
/**
 * @Repository 是 Spring 的注解, 在 spring 项目中,用于声明一个 Bean。@Repository单独使用没用。可以这样理解，注解放在接口上本来就没有意义，
 * spring中在mapper接口上写一个@Repository注解，只是为了标识，要想真正是这个接口被扫描，必须使用@MapperScannerConfigurer
 *
 *<!-- 配置 Mapper 扫描器 -->
 * <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
 *  <property name="basePackage" value="com.shenlei.mapper"/>
 * </bean>
 *
 */

/**
 * SpringBoot中使用@Repository 与 @Mapper的区别
 *       @Mapper 一定要有，否则 Mybatis 找不到 mapper。
 *       @Repository 可有可无，可以消去依赖注入的报错信息。
 *       @MapperScan 可以替代 @Mapper。
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

}
