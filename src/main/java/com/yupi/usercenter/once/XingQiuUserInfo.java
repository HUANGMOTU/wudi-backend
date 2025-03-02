package com.yupi.usercenter.once;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class XingQiuUserInfo {
    @ExcelProperty("成员编号")
    private String planetCode;
    @ExcelProperty("成员昵称")
    private String username;
}