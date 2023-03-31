package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        Car car = new Car("qasqai", 10);
        Car car1 = new Car("accord", 2);
        Car car2 = new Car("lancher", 3);
        Car car3 = new Car("Xtrail", 32);
        Car car4 = new Car("lancher", 1);

        User user = new User("Игорь", "Гунов", "user1@mail.ru");
        User user1 = new User("Рахман", "Кичибеков", "user2@mail.ru");
        User user2 = new User("Николай", "Королев", "user3@mail.ru");
        User user3 = new User("Денис", "Грачев", "user4@mail.ru");
        User user4 = new User("Алекс", "Булгаков", "user5@mail.ru");

        user.setcar(car);
        user1.setcar(car1);
        user2.setcar(car2);
        user3.setcar(car3);
        user4.setcar(car4);

        userService.add(user);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> list = userService.getListUsers();
        List<Car> list2 = carService.getListCars();

        System.out.println("---------------------------------------");
        System.out.println(list.get(2).toString());
        System.out.println("---------------------------------------");
        System.out.println(list2.get(2).toString());
        System.out.println("---------------------------------------");
        System.out.println(userService.getUserByCar("lancher", 3).toString());
        System.out.println("---------------------------------------");

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.getListUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
        context.close();
    }
}
