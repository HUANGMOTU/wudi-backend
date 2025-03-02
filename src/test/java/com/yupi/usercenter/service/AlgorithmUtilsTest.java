package com.yupi.usercenter.service;

import com.yupi.usercenter.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 算法工具类测试
 */
public class AlgorithmUtilsTest {



    @Test
    void testTags() {
        List<String> list = Arrays.asList("Java", "大一", "男");
        List<String> list1 = Arrays.asList("Java", "大一", "女");
        List<String> list2 = Arrays.asList("Python", "大二", "女");
        int score1 = AlgorithmUtils.minDistance(list,list1);
        int score2 = AlgorithmUtils.minDistance(list,list2);
        System.out.println(score1);
        System.out.println(score2);
    }

}
