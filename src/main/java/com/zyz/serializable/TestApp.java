package com.zyz.serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 13:55 2019/4/8
 */
public class TestApp {

    @Test
    public void test() throws JsonProcessingException {
        TestBean aa = new TestBean("aa", 1);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aa);
        System.out.println(jsonString);
    }

    @Test
    public void test1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"name\":\"aa\",\"age\":1}";
        TestBean testBean = mapper.readValue(json, TestBean.class);
    }

}
