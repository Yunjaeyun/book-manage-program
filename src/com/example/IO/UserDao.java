package com.example.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* 파일에서 List<User>정보를 저장하거나 읽어오는 기능
* */
public class UserDao {
    private String filename;

    public UserDao(String filename) {
        this.filename = filename;
    }

    //유저정보 저장 메서드
    public void saveUser(Iterator<User> iter){
        List<User> users=new ArrayList<>();
        while(iter.hasNext()){
            User user = iter.next();
            users.add(user);
        }
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(users);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    //유저정보 읽어오는 메서드
    public List<User> getUsers(){

        File file=new File(filename);
        if(!file.exists()){
            return new ArrayList<>();
        }
        List<User> list=null;
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename))){
            list = (List<User>)in.readObject();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

}
