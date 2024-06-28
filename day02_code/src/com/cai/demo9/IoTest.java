package com.cai.demo9;

import java.io.*;

public class IoTest {
    public static void main(String[] args) {

    }
    public static void test1() throws IOException {
        FileReader fileReader = new FileReader("D:\\mac");
        FileWriter fileWriter = new FileWriter("C:\\a\\a.txt");
        char[] chars = new char[2];
        int len;
        while((len=fileReader.read(chars))!=-1){
            fileWriter.write(new String(chars,0,len));
            System.out.println(new String(chars,0,len));    //读取数据，解码，强转合并了，直接输出字符串
        }
        fileWriter.close();
        fileReader.close();
    }

    public static void test4() throws IOException {
        FileReader fileReader = new FileReader("D:\\mac");
        FileWriter fileWriter = new FileWriter("C:\\a\\a.txt");
        int ch = 0;
        
        while ((ch = fileReader.read()) != -1) {
            fileWriter.write(ch);      //***         //字符流一次输出一个字符  //fileWriter.write()可以填char和string类型
            System.out.println((char)ch);
        }
        fileWriter.close();
        fileReader.close();

    }

    public static void test3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\mac");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\m\\a.txt");
        int b;
        while ((b = fileInputStream.read()) !=-1){
            fileOutputStream.write(b);               //字节流一次只能输出一个字节
        }

        fileOutputStream.close();
        fileInputStream.close();

    }

    public static void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\mac");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\m\\a.txt");
        byte[] bytes = new byte[1024*1024*5];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) !=-1){
            fileOutputStream.write(bytes,0,len);
        }

        fileOutputStream.close();
        fileInputStream.close();

    }

    public static void test5(File file1, File file2) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        int b=0;
        while((b=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(b);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();

    }

    public static void test6(File file1, File file2) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        int len=0;
        byte[] bytes = new byte[1024];
        while((len=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,len);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();

    }



    //对字符流有特有的方法
    public static  void test7(File file1, File file2) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));

        String line;
        while((line = bufferedReader.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            System.out.println(line);
        }
        bufferedReader.close();
        bufferedWriter.close();


    }
    public static void test8(File file) throws IOException, ClassNotFoundException {
        Student stu = new Student("zhangsan",18);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        //序列化
        objectOutputStream.writeObject(stu);
        objectOutputStream.close();

        //反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        System.out.println(objectInputStream.readObject());

    }


}
