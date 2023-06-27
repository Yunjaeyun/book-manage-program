package com.example.IO;

import java.util.Iterator;

public interface UserService {
//    회원정보를 등록한다.
    public void addUser(User user);

//    회원정보를 수정한다.user.getEmail()에 해당하는 회원정보를 수정한다.
    public boolean updateUser(User user);

    //    회원정보를 삭제한다.
    public boolean deleteUser(String email);

//    모든 회원정보를 반환한다.
    public Iterator<User> getUsers();

    //
    public boolean exists(String email);
}
