package com.cai.demo9;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //创建文件
        File file = new File("D://mac");
        file.mkdirs();
        File file2 = new File(file,"aaa.txt");
        file2.createNewFile();


        findMp4(file);


    }
    public static boolean findMp4(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()&&file1.toPath().endsWith(".mp4"));{
                return true;
            }
        }
        return false;
    }

    public static boolean test2(File file){
        File[] files1 = file.listFiles();
        if(files1!=null){
            for (File file1 : files1) {
                if(file1.isFile()){
                    String name = file1.getName();
                    if(name.endsWith("mp4")){
                        System.out.println("yes");
                    }
                }
                else{
                    test2(file1);
                }
            }
            return false;
        }
        return false;
    }
    public static void test3(File file){
        File[] subFilesArray = file.listFiles();    //若当前文件夹为空则直接删除
        if(subFilesArray==null){
            file.delete();
        }
        for (File subFile : subFilesArray) {
            if(subFile.isFile()&&subFile.listFiles()==null){     //如果文件夹有文件或为空则删除
                subFile.delete();
            }else{
                test3(subFile);
            }
        }


    }
}
