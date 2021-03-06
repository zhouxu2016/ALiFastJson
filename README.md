## 高性能JSON框架之FastJson的简单使用 ##

## 1.前言 ##

### 1.1.FastJson的介绍: ###
JSON协议使用方便，越来越流行,JSON的处理器有很多,这里我介绍一下FastJson,FastJson是阿里的开源框架,被不少企业使用,是一个极其优秀的Json框架,Github地址: [FastJson](https://github.com/alibaba/fastjson)
 
### 1.2.FastJson的特点: ###
1.FastJson数度快,无论序列化和反序列化,都是当之无愧的fast  
2.功能强大(支持普通JDK类包括任意Java Bean Class、Collection、Map、Date或enum)  
3.零依赖(没有依赖其它任何类库)  

### 1.3.FastJson的简单说明: ###
FastJson对于json格式字符串的解析主要用到了一下三个类：  
1.JSON：fastJson的解析器，用于JSON格式字符串与JSON对象及javaBean之间的转换  
2.JSONObject：fastJson提供的json对象    
3.JSONArray：fastJson提供json数组对象  

>**还在迷茫和彷徨吗,快上车,老司机带你飞!**

## 2.FastJson的用法 ##
首先定义三个json格式的字符串  

	//json字符串-简单对象型
	private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

	//json字符串-数组类型
	private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

	//复杂格式json字符串
	private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

### 2.1.JSON格式字符串与JSON对象之间的转换 ###
#### 2.1.1.json字符串-简单对象型与JSONObject之间的转换 ####
    
    /**
     * json字符串-简单对象型到JSONObject的转换
     */
    @Test
    public void testJSONStrToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

        System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                + jsonObject.getInteger("studentAge"));

    }


    /**
     * JSONObject到json字符串-简单对象型的转换
     */
    @Test
    public void testJSONObjectToJSONStr() {
    
       //已知JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
      // 第一种方式
        String jsonString = JSONObject.toJSONString(jsonObject);

      // 第二种方式
      //String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);

    }

#### 2.1.2.json字符串(数组类型)与JSONArray之间的转换 ####

    /**
     * json字符串-数组类型到JSONArray的转换
     */
    @Test
    public void testJSONStrToJSONArray() {

        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);

        //遍历方式1
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));
        }

        //遍历方式2
        for (Object obj : jsonArray) {

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));
        }
    }

    /**
     * JSONArray到json字符串-数组类型的转换
     */
    @Test
    public void testJSONArrayToJSONStr() {

     //已知JSONArray,目标要转换为json字符串
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
     //第一种方式
        String jsonString = JSONArray.toJSONString(jsonArray);

    // 第二种方式
     //String jsonString = jsonArray.toJSONString(jsonArray);
       System.out.println(jsonString);
    }


#### 2.1.3.复杂json格式字符串与JSONObject之间的转换 ####

    /**
     * 复杂json格式字符串到JSONObject的转换
     */
    @Test
    public void testComplexJSONStrToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");

        System.out.println("teacherName:  " + teacherName + "   teacherAge:  " + teacherAge);

        JSONObject jsonObjectcourse = jsonObject.getJSONObject("course");
 		//获取JSONObject中的数据
        String courseName = jsonObjectcourse.getString("courseName");
        Integer code = jsonObjectcourse.getInteger("code");

        System.out.println("courseName:  " + courseName + "   code:  " + code);

        JSONArray jsonArraystudents = jsonObject.getJSONArray("students");

		//遍历JSONArray
        for (Object object : jsonArraystudents) {

            JSONObject jsonObjectone = (JSONObject) object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");

            System.out.println("studentName:  " + studentName + "   studentAge:  " + studentAge);
        }

    }

    /**
     * 复杂JSONObject到json格式字符串的转换
     */
    @Test
    public void testJSONObjectToComplexJSONStr() {

		//复杂JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

		//第一种方式
		//String jsonString = JSONObject.toJSONString(jsonObject);

		//第二种方式
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);

    }

### 2.2.JSON格式字符串与javaBean之间的转换 ###

#### 2.2.1.json字符串-简单对象型与javaBean之间的转换 ####

    /**
     * json字符串-简单对象到JavaBean之间的转换
     */
    @Test
    public void testJSONStrToJavaBeanObj() {

		//第一种方式
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

        String studentName = jsonObject.getString("studentName");
        Integer studentAge = jsonObject.getInteger("studentAge");

		//Student student = new Student(studentName, studentAge);

		//第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
		//Student student = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});

		//第三种方式,使用Gson的思想
        Student student = JSONObject.parseObject(JSON_OBJ_STR, Student.class);

        System.out.println(student);

    }

    /**
     * JavaBean到json字符串-简单对象的转换
     */
    @Test
    public void testJavaBeanObjToJSONStr() {

        Student student = new Student("lily", 12);
        String jsonString = JSONObject.toJSONString(student);
        System.out.println(jsonString);
    }

#### 2.2.2.json字符串-数组类型与javaBean之间的转换 ####

    /**
     * json字符串-数组类型到JavaBean_List的转换
     */
    @Test
    public void testJSONStrToJavaBeanList() {

		//第一种方式
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);

		//遍历JSONArray
        List<Student> students = new ArrayList<Student>();
        Student student = null;
        for (Object object : jsonArray) {

            JSONObject jsonObjectone = (JSONObject) object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");

            student = new Student(studentName,studentAge);
            students.add(student);
        }

        System.out.println("students:  " + students);


		//第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        List<Student> studentList = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        System.out.println("studentList:  " + studentList);

		//第三种方式,使用Gson的思想
        List<Student> studentList1 = JSONArray.parseArray(JSON_ARRAY_STR, Student.class);
        System.out.println("studentList1:  " + studentList1);

    }


    /**
     * JavaBean_List到json字符串-数组类型的转换
     */
    @Test
    public void testJavaBeanListToJSONStr() {

        Student student = new Student("lily", 12);
        Student studenttwo = new Student("lucy", 15);

        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(studenttwo);

        String jsonString = JSONArray.toJSONString(students);
        System.out.println(jsonString);

    }

#### 2.2.3.复杂json格式字符串与与javaBean之间的转换 ####

    /**
     * 复杂json格式字符串到JavaBean_obj的转换
     */
    @Test
    public void testComplexJSONStrToJavaBean(){

		//第一种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        Teacher teacher = JSONObject.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
        System.out.println(teacher);

		//第二种方式,使用Gson思想
        Teacher teacher1 = JSONObject.parseObject(COMPLEX_JSON_STR, Teacher.class);
        System.out.println(teacher1);

    }

    /**
     * 复杂JavaBean_obj到json格式字符串的转换
     */
    @Test
    public void testJavaBeanToComplexJSONStr(){

		//已知复杂JavaBean_obj
        Teacher teacher = JSONObject.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
        String jsonString = JSONObject.toJSONString(teacher);
        System.out.println(jsonString);

    }

### 2.3.javaBean与json对象间的之间的转换 ###

#### 2.3.1.简单javaBean与json对象之间的转换 ####

    /**
     * 简单JavaBean_obj到json对象的转换
     */
    @Test
    public void testJavaBeanToJSONObject(){

		//已知简单JavaBean_obj
        Student student = new Student("lily", 12);

		//方式一
        String jsonString = JSONObject.toJSONString(student);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        System.out.println(jsonObject);

		//方式二
        JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(student);
        System.out.println(jsonObject1);
    }

    /**
     * 简单json对象到JavaBean_obj的转换
     */
    @Test
    public void testJSONObjectToJavaBean(){

		//已知简单json对象
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

		//第一种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        Student student = JSONObject.parseObject(jsonObject.toJSONString(), new TypeReference<Student>() {});
        System.out.println(student);

		//第二种方式,使用Gson的思想
        Student student1 = JSONObject.parseObject(jsonObject.toJSONString(), Student.class);
        System.out.println(student1);
    }

#### 2.3.2.JavaList与JsonArray之间的转换 ####

    /**
     * JavaList到JsonArray的转换
     */
    @Test
    public void testJavaListToJsonArray() {

		//已知JavaList
        Student student = new Student("lily", 12);
        Student studenttwo = new Student("lucy", 15);

        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(studenttwo);

		//方式一
        String jsonString = JSONArray.toJSONString(students);
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        System.out.println(jsonArray);

		//方式二
        JSONArray jsonArray1 = (JSONArray) JSONArray.toJSON(students);
        System.out.println(jsonArray1);
    }

    /**
     * JsonArray到JavaList的转换
     */
    @Test
    public void testJsonArrayToJavaList() {

		//已知JsonArray
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);

		//第一种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        ArrayList<Student> students = JSONArray.parseObject(jsonArray.toJSONString(),
                new TypeReference<ArrayList<Student>>() {});

        System.out.println(students);

		//第二种方式,使用Gson的思想
        List<Student> students1 = JSONArray.parseArray(jsonArray.toJSONString(), Student.class);
        System.out.println(students1);
    }

### 2.3.3.复杂JavaBean_obj与json对象之间的转换 ###

    /**
     * 复杂JavaBean_obj到json对象的转换
     */
    @Test
    public void testComplexJavaBeanToJSONObject() {

		//已知复杂JavaBean_obj
        Student student = new Student("lily", 12);
        Student studenttwo = new Student("lucy", 15);

        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(studenttwo);
        Course course = new Course("english", 1270);

        Teacher teacher = new Teacher("crystall", 27, course, students);

		//方式一
        String jsonString = JSONObject.toJSONString(teacher);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        System.out.println(jsonObject);

		//方式二
        JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(teacher);
        System.out.println(jsonObject1);

    }


    /**
     * 复杂json对象到JavaBean_obj的转换
     */
    @Test
    public void testComplexJSONObjectToJavaBean() {

		//已知复杂json对象
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

		//第一种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        Teacher teacher = JSONObject.parseObject(jsonObject.toJSONString(), new TypeReference<Teacher>() {});
        System.out.println(teacher);

		//第二种方式,使用Gson的思想
        Teacher teacher1 = JSONObject.parseObject(jsonObject.toJSONString(), Teacher.class);
        System.out.println(teacher1);

    }

## 3.源码 ##

本篇博客的源码都在我的Github上,[FastJsonDemo](https://github.com/zhouxu2016/ALiFastJson),欢迎大家Fork and Star!

## 4.总结 ##
好啦,FastJson的基本用法就介绍完了,送人玫瑰,手留余香,学习使我快乐,分享让大家快乐,欢迎大家点赞收藏噢!

