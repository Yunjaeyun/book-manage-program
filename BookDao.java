package com.example.myIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*파일에서 List<Book> 읽어오는 기능*/
public class BookDao {
    private String filename;

    public BookDao(String filename) {
        this.filename = filename;
    }
    //저장하기
    public void saveBooks(List<Book> list){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(list);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    //읽어오기
    public List<Book> getBooks(){
//        File file=new File(filename);
//        if(!file.exists()){
            return new ArrayList<>();
//        }
//
//        List<Book> list=null;
//        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename))){
//            list = (List<Book>) in.readObject();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return list;
    }


}
