package org.huluo.springsourcecodestudy;

import org.springframework.util.StreamUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SpringStreamUtilsApiTest {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("D:/Users/Administrator/Desktop/SPRING技术内幕：深入解析SPRING架构与设计原理.pdf");

        OutputStream fileOutputStream = new FileOutputStream("行内人称66666.pdf");
        StreamUtils.copy(inputStream, fileOutputStream);

        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();
    }
}
