package com.zhouxu.example;

import com.alibaba.fastjson.JSONArray;
import com.zhouxu.example.dao.TutorMapper;
import com.zhouxu.example.pojo.Tutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhouxu on 2017/9/12 22:49.
 * Spring整合Junit单元测试
 */

@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class TutorServiceImplTest {

//    1.Spring整合Junit单元测试,第一种方式实现依赖注入
//    @Resource(name = "tutorMapper")

//    2.Spring整合Junit单元测试,第二种方式实现依赖注入
//    @Autowired
//    @Qualifier(value = "tutorMapper")


//    @Resource的作用与@Autowired配合@Qualifier注解联用的作用一样,这里使用第二种方式实现依赖注入

//    这里@Qualifier(value = "tutorMapper")中的value属性值是Mapper接口的类名,首字母小写
//    因为在上面所加载的配置文件applicationContext-dao.xml中,做了相应的配置,配置了Mapper接口的扫描,

    /*<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">

        <!-- 扫描包路径,如果需要扫描多个包,中间使用半角逗号隔开 -->
        <property name="basePackage" value="com.zhouxu.example.dao"/>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    </bean>*/


    /** MapperScannerConfigurer扫描的作用总结:
     *
       1.扫描指定包下的所有Mapper接口,相当于加上@Mapper注解,并且可以扫描Mapper接口,整合MyBatis可以实现依赖注入
       2.mapper批量扫描,从指定包中扫描出Mapper接口,自动创建代理对象,并且在spring容器中注册,并且自动扫描出来的mapper的bean
       的id为mapper的类名(注意,首字母小写)
       3.当使用mapperxml文件做为Mapper接口的映射文件时,如果满足mapper接口与mapper的配置文件同名,并且在同一个类路径下,
       此时,不需要手动加载mapperxml映射文件,MapperScannerConfigurer自动加载mapperxml配置文件,但是如果是Maven项目的话,
       Maven默认的打包方式不会把Mapper接口和mapperxml映射文件编译到同一个类路径下,需要在pom.xml文件中添加指定文件的打包方式,并且
      把Mapper接口和mapperxml映射文件放在同一个路径下(注意不是同一个类路径下),此时为了做到Mapper接口和mapperxml映射文件分离,
      不再使用这种手动加载mapperxml映射文件,而是使用mapperLocations属性直接指定mapperxml映射文件的位置,从而手动加载mapperxml配置文件

    * */


    @Autowired
    @Qualifier(value = "tutorMapper")
    private TutorMapper tutorMapper;


    @Test
    public void test() {

        /*Tutor tutor = tutorMapper.findTutorByIdPro(11);
        System.out.println(tutor);*/

        /*Tutor tutor = new Tutor(6, "hehe", "123.com");
        tutorMapper.insertTutorPro(tutor);*/

        /*Tutor tutor = new Tutor("haha", "456.com");
        tutorMapper.insertTutorPro(tutor);*/

        /*Tutor tutor = tutorMapper.findTutorByIdPro(8);
        tutor.setEmail("666.com");
        tutor.setName("ppp");
        tutorMapper.updateTutorByIdPro(tutor);*/

//        tutorMapper.deleteTutorByIdPro(8);

       /* Tutor tutor = tutorMapper.findTutorByIdMap(7);
        System.out.println(tutor);*/

        /*Tutor tutor = new Tutor("haha", "456.com");
        tutorMapper.insertTutorKey(tutor);*/

        /*Tutor tutor = tutorMapper.findTutorByIdPro(14);
        tutor.setEmail("666.com");
        tutor.setName("ppp");
        tutorMapper.updateTutorByIdPro(tutor);*/

//        tutorMapper.deleteTutorById(5);



        String s = "[{\n" +
                "    \"tutorId\": 1,\n" +
                "    \"name\": \"哈哈\",\n" +
                "    \"email\": \"163.com\"\n" +
                "},{\n" +
                "    \"tutorId\": 1,\n" +
                "    \"name\": \"666\",\n" +
                "    \"email\": \"163.com\"\n" +
                "},{\n" +
                "    \"tutorId\": 1,\n" +
                "    \"name\": \"666\",\n" +
                "    \"email\": \"163.com\"\n" +
                "}]";


        List<Tutor> list = JSONArray.parseArray(s, Tutor.class);

        System.out.println("list.size() " + list.size() + "list    " + list);

    }

}
