package com.cai.demo9;

import java.io.*;
import java.util.Arrays;

public class FileZongHeTest {
    public static void main(String[] args) {

    }
    public  static void copyFile(File startFile, File endFile) throws IOException {
        endFile.mkdir();

        File[] listFiles = startFile.listFiles();

        for (File listFile : listFiles) {
            if(listFile.isFile()|| listFile.listFiles()==null){
                //字节流复制文件
                FileInputStream fileInputStream = new FileInputStream(startFile);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(endFile,listFile.getName()));  //关键点
                byte[] bytes = new byte[1024*1024*5];
                int len = 0;
                while ((len=fileInputStream.read(bytes))!=-1){
                    fileOutputStream.write(bytes,0,len);
                }
                fileInputStream.close();
                fileOutputStream.close();

            }else{
                copyFile(listFile,new File(endFile,listFile.getName()));       //listFile是文件夹且有数据的情况，将文件拷贝到另一个地方并保留原结构
            }
        }
    }
    public static void jiami(File file1,File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        int b =0;
        while ((b = fileInputStream.read())!=-1){
            b++;
            fileOutputStream.write((char)b);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
    public static void jiemi(File file1,File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        int b =0;
        while ((b = fileInputStream.read())!=-1){
            b--;
            fileOutputStream.write((char)b);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void sortTest(File file1,File file2) throws IOException {
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);

//        int b = 0;
        StringBuilder sb = new StringBuilder();
//
//        while ((b=fileReader.read())!=-1){
//            sb.append((char)b);
//        }
//        String[] strs = sb.toString().split("-");
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (String str : strs) {
//            arrayList.add(Integer.parseInt(str));
//        }
//        Collections.sort(arrayList);

//        for (int i = 0; i < arrayList.size(); i++) {
//            fileWriter.write(arrayList.get(i));
//            if(i!=arrayList.size()-1){
//                fileWriter.write("-");
//            }
//
//        }
        Integer[] array = Arrays.stream(sb.toString().split("-")).map(Integer::parseInt)
                .sorted().toArray(Integer[]::new);
        String replace_str = Arrays.toString(array).replace(", ", "-");
        String replace_str2 = replace_str.substring(1,replace_str.length()-1);
        fileWriter.write(replace_str2);


        fileReader.close();
        fileWriter.close();
    }

}
