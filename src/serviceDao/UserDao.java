package serviceDao;

import models.User;

public interface UserDao {
    String addNewUser(User user);
    User userUpdateById(Long id,String nickName,String password,String photo);
    User searchByName(String nickName);
    void sortByAge(String ascOrDesk);
}
