package com.little;

/**
 * Created by peter on 16/3/1.
 */
public class StringTest {
    /**
     * 简单字符串拼接
     * @return
     */
    public String stringAdd(){
        String first = "I'm string 1";
        String second = "and i'm string 2.";
        return first + second;
    }

    /**
     *速度最快，但不是线程安全的。多线程访问慎用
     * @return
     */
    public String stringBuilderAdd(){
        StringBuilder added = new StringBuilder();
        added.append("I'm 10000 length string 1");
        added.append("and i'm string 2");
        return added.toString();
    }

    /**
     * 线程安全
     * @return
     */
    public String stringBufferAdd(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("I'm 10000 length string 1");
        buffer.append("and i'm string 2");
        return buffer.toString();
    }

    public String stringReplace(){
        String origin = "A should be replace with The B.";
        origin = origin.replace('A','B');
        origin = origin.replace("B ","The replaced A");
        origin = origin.replaceAll("^The","The Regex");
        return origin;
    }
}
