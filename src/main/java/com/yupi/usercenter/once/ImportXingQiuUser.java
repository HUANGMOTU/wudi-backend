package com.yupi.usercenter.once;

import com.alibaba.excel.EasyExcel;

import java.util.List;

/**
 * 导入数据库
 */
public class ImportXingQiuUser {
    public static void main(String[] args) {
        String fileName = "D:\\JavaProject\\user-center-backend\\src\\main\\resources\\Book.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        List<XingQiuUserInfo> totalDataList = EasyExcel.read(fileName).head(XingQiuUserInfo.class).sheet().doReadSync();
        for (XingQiuUserInfo data : totalDataList) {
            System.out.println(data.getPlanetCode()+" " +data.getUsername());
        }
    }
}
