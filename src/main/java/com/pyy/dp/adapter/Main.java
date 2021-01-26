package com.pyy.dp.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Adapter 适配器/转换器 模式：
 * 1、ODBC 转换成 JDBC 中间的 Bridge 其实 Adapter
 * 2、new BufferedReader(里面的转换是 Adapter)
 *
 * 误区：常见的Adapter类反而不是Adapter
 * WindowAdapter---不是
 * KeyAdapter---不是
 *
 * @author PeiYY
 * @date 2021/1/26 23:06
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("c:/test.text");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();
    }
}
