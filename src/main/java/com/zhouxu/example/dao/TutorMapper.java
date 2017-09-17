package com.zhouxu.example.dao;

import com.zhouxu.example.dao.provider.TutorDynaSqlProvider;
import com.zhouxu.example.pojo.Tutor;
import org.apache.ibatis.annotations.*;

/**
 * Created by zhouxu on 2017/9/12 22:32.
 */

//@Mapper
@SuppressWarnings("all")
public interface TutorMapper {

//    @SelectProvider(type = TutorDynaSqlProvider.class,method = "findTutorByIdSql")
//
 /*   @Select("select tutor_id as tutorId,name,email from tutors where tutor_id = #{tutorId}")
    public Tutor findTutorById(int tutorId);
*/

   /* @SelectProvider(type = TutorDynaSqlProvider.class,method = "findTutorByIdSql")
    public Tutor findTutorByIdPro(Integer tutorId);*/


    /*@SelectProvider(type = TutorDynaSqlProvider.class,method = "findTutorByIdSql")
    public Tutor findTutorByIdPro(@Param("tutorId") Integer tutorId);*/


//    这个地方如果使用@Param注解,那么注解中的value属性的值后面会最为SqlProvider中的#{}中的参数名称
//    实际上是@把Param注解中的value属性的值做为key,参数值做为value,封装到Map集合中,然后传递到SqlProvider中对应方法的参数中
//    然后在SqlProvider中通过对应方法的参数Map集合进行接收参数,在执行sql语句的时候,通过#{}取值,
//    #{}取值,大括号里面就是Map集合的key,也就是@Param注解中value属性的值,也可以使用param1,param2


    /*@SelectProvider(type = TutorDynaSqlProvider.class,method = "findTutorByIdSql")
    public Tutor findTutorByIdPro(@Param("tutorId") Integer tutorId, @Param("name") String name);*/


    /*@SelectProvider(tmype = TutorDynaSqlProvider.class, method = "findTutorByIdSql")
    public Tutor findTutorByIdPro(Integer tutorId, String name);*/

    /*@SelectProvider(type = TutorDynaSqlProvider.class,method = "findTutorByIdSql")
    public Tutor findTutorByIdPro(@Param("tutorId") int tutorId);*/

//    当只有一个参数时,需要将数据封装为Map集合,必须使用@Param注解
    /*@SelectProvider(type = TutorDynaSqlProvider.class,method = "findTutorByIdSql")
    public Tutor findTutorByIdPro(@Param("tutorId") Integer tutorId);*/

    /*@InsertProvider(type = TutorDynaSqlProvider.class, method = "insertTutor")
    public int insertTutorPro(Tutor tutor);*/


    @Results(id = "tutorResultMap",value = {

            @Result(property = "tutorId", column = "TUTOR_ID", id = true),
            @Result(property = "name", column = "NAME"),
            @Result(property = "email", column = "EMAIL"),

    })
    @Select("select * from tutors where tutor_id = #{tutorId}")
    public Tutor findTutorById(@Param("tutorId") Integer tutorId);


    @ResultMap(value = "tutorResultMap")
    @Select("select * from tutors where tutor_id = #{tutorId}")
    public Tutor findTutorByIdMap(@Param("tutorId") Integer tutorId);


//    返回自增主键
    @Insert("insert into tutors(name,email) values(#{name},#{email})")
    @Options(useGeneratedKeys = true,keyColumn = "TUTOR_ID")
    public int insertTutor(Tutor tutor);


//    返回非自增主键
    @Insert("insert into tutors(name,email) values(#{name},#{email})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "tutorId", keyColumn = "TUTOR_ID", resultType = Integer.class, before = false)
    public int insertTutorKey(Tutor tutor);


    @Update("update tutors set name = #{name} and email = #{email} where TUTOR_ID = #{tutorId}")
    public int updateTutorById(Tutor tutor);


    @Delete("delete from tutors where TUTOR_ID = #{tutorId}")
    public int deleteTutorById(@Param("tutorId") Integer tutorId);


    @SelectProvider(type = TutorDynaSqlProvider.class,method = "findTutorByIdSql")
    public Tutor findTutorByIdPro(Integer tutorId);


//    数据库主键设置为自增,插入数据时不需要维护,@Options注解,useGeneratedKeys表示是否使用自增主键
//    keyProperty表示与主键对应在实体类中的属性名称,默认值为id,keyColumn为表中主键的字段名称
    @InsertProvider(type = TutorDynaSqlProvider.class, method = "insertTutor")
    @Options(useGeneratedKeys = true,keyColumn = "TUTOR_ID") //@Options(useGeneratedKeys = true,keyProperty = "tutorId")
    public int insertTutorPro(Tutor tutor);


    @UpdateProvider(type = TutorDynaSqlProvider.class,method = "updateTutor")
    public int updateTutorByIdPro(Tutor tutor);


    @DeleteProvider(type = TutorDynaSqlProvider.class,method = "deleteTutor")
    public int deleteTutorByIdPro(@Param("tutorId") Integer tutorId);


}
