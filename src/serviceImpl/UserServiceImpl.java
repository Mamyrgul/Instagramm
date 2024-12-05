package serviceImpl;

import models.User;
import service.UserService;
import serviceDao.UserDao;
import serviceDaoImpl.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public String addNewUser(User user) {
        return userDao.addNewUser(user);
    }

    @Override
    public User userUpdateById(Long id, String nickName, String password, String photo) {
        return userDao.userUpdateById(id,nickName,password,photo);
    }

    @Override
    public User searchByName(String nickName) {
        return userDao.searchByName(nickName);
    }

    @Override
    public void sortByAge(String ascOrDesk) {
    userDao.sortByAge(ascOrDesk);
    }
}
