package com.yupi.usercenter.once;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;

import java.io.File;
import java.util.List;

/**
 * 导入
 */
public class ImportExcel {

    public static void main(String[] args) {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\JavaProject\\user-center-backend\\src\\main\\resources\\Book.xlsx";

        test1(fileName);
//        test2(fileName);
    }

    public static void test1(String fileName) {
        EasyExcel.read(fileName, XingQiuUserInfo.class, new XingQiuUserInfoListener()).sheet().doRead();
    }

//    public static void test2(String fileName) {
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        List<XingQiuUserInfo> totalDataList = EasyExcel.read(fileName).head(XingQiuUserInfo.class).sheet().doReadSync();
//        for (XingQiuUserInfo data : totalDataList) {
//            System.out.println(data.getPlanetCode()+" " +data.getUsername());
//        }
//    }
}
