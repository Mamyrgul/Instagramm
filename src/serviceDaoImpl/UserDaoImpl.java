package serviceDaoImpl;

import dataBase.DataBase;
import models.User;
import serviceDao.UserDao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public String addNewUser(User user) {
        DataBase.users.add(user);
        return "Successfully added";
    }

    @Override
    public User userUpdateById(Long id, String nickName, String password, String photo) {
        for (User user : DataBase.users) {
            if (user.getId().equals(id)) {
                user.setNickName(nickName);
                user.setPassword(password);
                user.setPhoto(photo);
                System.out.println(" success updated");
                return user;
            }
        }
        return null;
    }

    @Override
    public User searchByName(String nickName) {
        for (User user : DataBase.users) {
            if (user.getNickName().equalsIgnoreCase(nickName)) {
                return user;
            } else {
                System.out.println("Not found nickName " + nickName);
            }
        }
        return null;
    }

    @Override
    public void sortByAge(String ascOrDesc) {
        for (User user : DataBase.users) {
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                DataBase.users.sort(Comparator.comparingInt(User::getAge));
                System.out.println(user.getAge());
                System.out.println("Users sorted by age");
            } else if (ascOrDesc.equalsIgnoreCase("desc")) {
                DataBase.users.sort(Comparator.comparingInt(User::getAge).reversed());
                System.out.println(user.getAge());
                System.out.println("Users sorted by reversed");
            } else {
                System.out.println("Invalid input. Write only 'asc' or 'desc'.");
            }
        }
    }
}