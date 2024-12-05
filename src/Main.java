import dataBase.Counter;
import dataBase.DataBase;
import enums.Gender;
import models.User;
import serviceImpl.UserServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     /*   1. Instagram программасын тузунуз
        2. 6 жаны пакет тузунуз - model, service, dao, database, enums, exception.
        3. enum Gender (MALE,FEMALE)
        4. User деген класс болсун. Свойствалары: (nickName, password, age, photo, Gender gender)
        5. Методтор:
        - String addNewUser(User user) //добавить новый user
                - User userUpdateById(Long id,String nickName,String password,String photo) //изменить name, password, и photo
                - User searchByName(String nickName)// искать по name
                - User sortByAge(asc,desc) stream//сортировка по возрасту (по возрастанию и убыванию)
                - User filter(asc desc по age) stream //фильтрация по age(например старше >20 лет или младше <20 лет)*/

        UserServiceImpl userService = new UserServiceImpl();

        while (true){

            Scanner scannerInt = new Scanner(System.in);
            Scanner scannerStr= new Scanner(System.in);
            Scanner scannerLong= new Scanner(System.in);
        try {
            System.out.println("1.Create user");
            System.out.println("2.Update user");
            System.out.println("3.Search by name");
            System.out.println("4.Sort by age");
            int choice= scannerInt.nextInt();
            switch (choice){
                case 1:{
                    Long id = Counter.userId;
                    System.out.println("Write nickName: ");
                    String name= scannerStr.nextLine();
                    System.out.println("Enter password: ");
                    String password= scannerStr.nextLine();
                    System.out.println("Enter age: ");
                    int age= scannerInt.nextInt();
                    System.out.println("Write comment under photo: ");
                    String photo = scannerStr.nextLine();
                    System.out.println("MALE or FEMALE");
                    String gender = scannerStr.next();
                    Gender gender1 = Gender.valueOf(gender);
                    User user = new User(id,name,password,age,photo,gender1);
//                    user.setNickName(scannerStr.nextLine());
                    System.out.println(userService.addNewUser(user));
                    break;
                }
                    case 2: {
                        try {
                            System.out.println("Enter user ID to update: ");
                            Long id = scannerLong.nextLong();

                            System.out.println("Enter new nickname: ");
                            String nickName = scannerStr.nextLine();

                            System.out.println("Enter new password: ");
                            String password = scannerStr.nextLine();

                            System.out.println("Enter new comment under photo : ");
                            String photo = scannerStr.nextLine();

                            System.out.println(userService.userUpdateById(id, nickName, password, photo));

                        }catch (Exception e){
                            System.out.println("Error "+e.getMessage());
                        }
                        break;
                    }
                case 3:{
                    System.out.println("Enter nickname to search: ");
                    String name = scannerStr.nextLine();
                    System.out.println(userService.searchByName(name));
                    break;
                }
                case 4:{
                    System.out.println("Which type do you want to search 'asc' or 'desc': ");
                    String sort = scannerStr.nextLine();
                    userService.sortByAge(sort);
                    break;
                }


            }
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
        }
    }
}