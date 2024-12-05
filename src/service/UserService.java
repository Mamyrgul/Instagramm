package service;

import models.User;

public interface UserService {
    String addNewUser(User user);
    User userUpdateById(Long id,String nickName,String password,String photo);
    User searchByName(String nickName);
    void sortByAge(String ascOrDesk);
}
