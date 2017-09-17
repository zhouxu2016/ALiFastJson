package com.zhouxu.example.dao.provider;


import com.zhouxu.example.pojo.Tutor;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by zhouxu on 2017/9/12 22:33.
 */

/*
* Provider注解提供了2个必填的属性type和method,
* type配置的是一个包含method属性指定方法的类,这个类必须有空参构造器,
* 且method方法返回值必须为String类型.
*/

public class TutorDynaSqlProvider {


//    这里的形参类型只能使用三种类型
//         1.Integer,Long,Double等包装类型
//         2.引用类型(自定义实体类)
//         3.Map集合类型

    /** 查询数据
     * @param tutorId
     * @return
     */
    public String findTutorByIdSql(final Integer tutorId) {

        System.out.println("tutorId===" + tutorId);
        return new SQL() {

            {
                SELECT("tutor_id as tutorId,name,email");
                FROM("tutors");
                WHERE("tutor_id = #{tutorId}");

            }

        }.toString();

    }


    /*public String findTutorByIdSql(final Map<String,Integer> map) {

        Integer tutorId = map.get("tutorId");

        System.out.println("tutorId===" + tutorId);
        return new SQL() {

            {
                SELECT("tutor_id as tutorId,name,email");
                FROM("tutors");
                WHERE("tutor_id = #{tutorId}");
            }

        }.toString();


    }*/



    /*public String findTutorByIdSql(final Map<String,Object> map) {

//        这里取数据有2中方式:
//              1.跟@Param注解中的value属性的值完全一致(大小写必须完全一致)
//              2.使用param1做为Map集合的key去取值,
//        Integer tutorId = map.get("param1");

        Integer tutorId = (Integer) map.get("tutorId");
        System.out.println("tutorId===" + tutorId);

        String name = (String) map.get("name");

        System.out.println("name==" + name);


        return new SQL() {

            {
                SELECT("tutor_id as tutorId,name,email");
                FROM("tutors");
                WHERE("tutor_id = #{tutorId}");
            }

        }.toString();



    }*/





    /*public String findTutorByIdSql(final Map<String,Object> map) {

//        这里取数据有2中方式:
//              1.跟@Param注解中的value属性的值完全一致(大小写必须完全一致)
//              2.使用param1做为Map集合的key去取值,
//        Integer tutorId = map.get("param1");
*//*
        Integer tutorId = (Integer) map.get("param1");
        System.out.println("tutorId===" + tutorId);

        String name = (String) map.get("param2");

        System.out.println("name==" + name);*//*

        Integer tutorId = (Integer) map.get("tutorId");
        System.out.println("tutorId===" + tutorId);

        return new SQL() {

//            Parameter 'tutorId' not found. Available parameters are [arg1, arg0, param1, param2]
            {
                SELECT("tutor_id as tutorId,name,email");
                FROM("tutors");
                WHERE("tutor_id = #{tutorId}");
            }

        }.toString();


    }*/


    /*
    public String insertTutor(final Tutor tutor) {

        System.out.println("tutor===" + tutor);
        return new SQL() {

            {
                INSERT_INTO("tutors");
                if(tutor.getTutorId() != null) {
                    VALUES("tutor_id", "#{tutorId}");
                }
                if(tutor.getName() != null) {

                    VALUES("name", "#{name}");
                }

                if(tutor.getEmail() != null) {

                    VALUES("email", "#{email}");
                }

            }

        }.toString();

    }*/


    /** 插入数据
     * @param tutor
     * @return
     */
    public String insertTutor(final Tutor tutor) {

        System.out.println("tutor===" + tutor);
        return new SQL() {

            {
                INSERT_INTO("tutors");
                if(tutor.getName() != null) {

                    VALUES("name", "#{name}");
                }

                if(tutor.getEmail() != null) {

                    VALUES("email", "#{email}");
                }

            }

        }.toString();

    }


    /** 修改数据
     * @param tutor
     * @return
     */
    public String updateTutor(final Tutor tutor) {

        System.out.println("tutor===" + tutor);
        return new SQL() {

            {
                UPDATE("tutors");
                if(tutor.getName() != null) {

                    SET("name = #{name}");
                }

                if(tutor.getEmail() != null) {

                    SET("email = #{email}");
                }

                WHERE("TUTOR_ID = #{tutorId}");
            }

        }.toString();

    }


    /** 删除数据
     * @param tutorId
     * @return
     */
    /*public String deleteTutor(final Integer tutorId) {

        System.out.println("tutorId===" + tutorId);
        return new SQL() {

            {
                DELETE_FROM("tutors");

//                if(tutorId != null) {

                    WHERE("TUTOR_ID = #{tutorId}");
//                }
            }
        }.toString();

    }*/



    /** 删除数据
     * @param map
     * @return
     */
    public String deleteTutor(final Map<String,Integer> map) {

        System.out.println("tutorId===" + map.get("tutorId"));
        return new SQL() {

            {
                DELETE_FROM("tutors");

//                if(tutorId != null) {

                WHERE("TUTOR_ID = #{tutorId}");
//                }
            }
        }.toString();

    }

}
