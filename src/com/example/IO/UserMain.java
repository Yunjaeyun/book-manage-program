package com.example.IO;

import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserUI userUI=new UserUI();
        UserDao userDao=new UserDao("/temp/users.dat");
        UserService userService=new UserServiceInMemory(userDao.getUsers());

        while(true){
            int menuId= userUI.menu();
            if(menuId==5){
                userDao.saveUser(userService.getUsers());
                System.out.println("종료합니다");
                break;
            } else if (menuId==1) {
                User user = userUI.regUser();
                userService.addUser(user);
                System.out.println("등록되었습니다");

            } else if (menuId==2) {
                userUI.printUsersList(userService.getUsers());

            } else if (menuId==3) {
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);

                if(isFindEmail){
                    User updateUser = userUI.inputUser(email);
                    userService.updateUser(updateUser);
                    System.out.println("수정되었습니다");
                }else { //수정할 유저정보가 없는 경우
                    System.out.println("수정할 회원 정보가 없습니다.");
                }

            } else if (menuId == 4) {
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);
                if(isFindEmail){
                    userService.deleteUser(email);
                    System.out.println("삭제되었습니다");
                }else { //삭제할 유저정보가 없는 경우
                    System.out.println("삭제할 회원 정보가 없습니다.");
                }
            }
        }
    }
}
