package com.zhouxu.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhouxu.example.pojo.Tutor;
import com.zhouxu.example.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouxu on 2017/9/12 23:07.
 */

@Controller
//@RestController
public class TutorController {


    @Autowired
    private TutorService tutorService;

//    @RequestMapping(value = "/test",produces="text/html;charset=UTF-8")
    @RequestMapping(value = "/test")
    @ResponseBody
    public Tutor test () {

        Tutor tutor = tutorService.findTutorById(1);

        String s = JSONObject.toJSONString(tutor);

//        返回jsonString
//        String tutorJsonString = JSONObject.toJSONString(tutor);
        /*List<Tutor> list = new ArrayList<Tutor>();

        Tutor tutor1 = new Tutor(2, "呵呵", "123.com");
        list.add(tutor);
        list.add(tutor1);*/

        /*
        list.add(tutor);
        list.add(tutor);
        list.add(tutor);*/

//        返回jsonObject
//        JSONObject jsonObject = (JSONObject) JSON.toJSON(tutor);

//        JSONArray jsonArray = (JSONArray) JSON.toJSON(list);

//        JSONArray jsonArray = (JSONArray) JSON.toJSON(list);


//        List<Tutor> list = JSONArray.parseArray(s, Tutor.class);

//        List<Tutor> list = JSONArray.parseArray(s, Tutor.class);

        return tutor;


        /*

        List<Tutor> list = new ArrayList<>();
//        System.out.println(tutorById);


//     javaBean与json对象间的转换使用：JSON.toJSON(obj)，然后使用强制类型转换，JSONObject或者JSONArray

        JSONObject o = (JSONObject) JSON.toJSON(tutor);
//        JSONArray o = (JSONArray) JSON.toJSON(list);


//        1.根据Object返回JsonString(json格式的字符串)
        String tutorJsonString = JSONObject.toJSONString(tutor);
        String listJsonString = JSONObject.toJSONString(list);


//        2.根据Object返回JsonObject
        JSONObject jsonObject = (JSONObject) JSON.toJSON(tutor);
        JSONArray jsonArray = (JSONArray) JSON.toJSON(list);

*/



  /*
//        将javaBean转化为jsonString
        String tutorJson = JSONObject.toJSONString(tutorById);


//       客户端拿到json格式的String字符串,然后解析

//         1.如何将json格式的String字符串转化为JsonObject
//         2.怎样使用原始的Json思想去解析json串


//          ----------------------如果传过来的是json格式的String字符串-----------------------------

//        1.如果传过来的是json格式的String字符串,第一种方式,使用原始json方式进行解析

//        调用JSONObject.parseObject()方法,把json格式的字符串做为形参,将jsonString 转化为 JsonObject
        JSONObject jsonObject = JSONObject.parseObject(tutorJson);
        String nameString = jsonObject.getString("name");


//          2.如果传过来的是json格式的String字符串,第二种方式
//          JSONObject.parseObject(jsonString, Object.class),用Gson的思想去解析
        Object object = JSONObject.parseObject(tutorJson, Object.class);



//        ----------------------如果传过来的是JsonObject-----------------------------

//        1.如果传过来的是JsonObject,第一种方式,使用原始json方式进行解析
        String name = jsonObject.getString("name");

//        2.如果传过来的是JsonObject,第二种方式,先将JsonObject转化为JsonString,
//        然后JSONObject.parseObject(jsonString, Object.class),用Gson的思想去解析
        String jsonString = jsonObject.toJSONString();
        Object o = JSONObject.parseObject(jsonString, Object.class);



//        ----------------------将javaBean转化为JsonObject-----------------------------

        String tutorJsonString = JSONObject.toJSONString(tutorById);
        JSONObject jsonObject1 = JSONObject.parseObject(tutorJsonString);
        String name1 = jsonObject1.getString("name");

        String s = jsonObject1.toJSONString();
        Object o1 = JSONObject.parseObject(s, Object.class);

        Object o2 = JSONObject.parseObject(tutorJsonString, Object.class);

*/


    }

}
