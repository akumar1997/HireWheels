package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.RoleDAO;
import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dao.VehicleCategoryDAO;
import com.upgrad.hirewheels.services.initService;
import com.upgrad.hirewheels.services.initServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		initService initService= context.getBean(initService.class);
		initService.start();


//		UserDAO usersDAO = (UserDAO) context.getBean(UserDAO.class);
//		RoleDAO roleDAO = (RoleDAO) context.getBean(RoleDAO.class);
//


//		Role user = new Role();
//		user.setRoleId(1);
//		user.setRoleName("USER");
//		user = roleDAO.save(user);
//
//		Role admin = new Role();
//		admin.setRoleId(2);
//		admin.setRoleName("ADMIN");
//		admin = roleDAO.save(admin);

		//TODO 3.3: Checking the UserDao Interface
//
//		In the main() method, use UserDao to insert five users into the database.

//		Users user1 = new Users();
//		user1.setFirstName("Hari");
//		user1.setLastName("Prasad");
//		user1.setEmail("hari@gmail.com");
//		user1.setPassword("78945");
//		user1.setMobileNo("9874563210");
//		user1.setWallet(1000);
//		user1.setRole(admin);
//
//		user1 = usersDAO.save(user1);
//
//
//		Users user2 = new Users();
//		user2.setFirstName("Kavi");
//		user2.setLastName("Pramad");
//		user2.setEmail("kavii@gmail.com");
//		user2.setPassword("789an45");
//		user2.setMobileNo("9874563740");
//		user2.setWallet(7000);
//		user2.setRole(user);
//
//
//
////
//		Users user3 = new Users();
//		user3.setFirstName("Xavi");
//		user3.setLastName("Hernandez");
//		user3.setEmail("xavi@gmail.com");
//		user3.setPassword("xavi06");
//		user3.setMobileNo("7696986450");
//		user3.setWallet(2000);
//		user3.setRole(user);
//
//		Users user4 = new Users();
//		user4.setFirstName("Andres");
//		user4.setLastName("Iniesta");
//		user4.setEmail("iniesta8@gmail.com");
//		user4.setPassword("iniesta08");
//		user4.setMobileNo("9977552410");
//		user4.setWallet(8000);
//		user4.setRole(user);
//
//		Users user5 = new Users();
//		user5.setFirstName("Lionel");
//		user5.setLastName("Pessi");
//		user5.setEmail("pessi@gmail.com");
//		user5.setPassword("dribble8945");
//		user5.setMobileNo("8874563210");
//		user5.setWallet(60000);
//		user5.setRole(user);
//
//		user1 = usersDAO.save(user1);
//		user2 = usersDAO.save(user2);
//		user3 = usersDAO.save(user3);
//		user4 = usersDAO.save(user4);
//		user5 = usersDAO.save(user5);
//
////		Check whether the data corresponding to the users got recorded in the database.
//		System.out.println("*************Checking all users*************");
//		usersDAO.findById(user1.getUserId());
//		usersDAO.findById(user2.getUserId());
//		usersDAO.findById(user3.getUserId());
//		usersDAO.findById(user4.getUserId());
//		usersDAO.findById(user5.getUserId());
//
////		Fetch all the users using the UserDao interface and print the user details on the console.
//		System.out.println("*************Finding all users*************");
//		usersDAO.findAll().forEach(System.out::println);
//
//
////		Make a paginated request to fetch a page with two users using the UserDao interface and print the user details on the console.
//
//		System.out.println("*************Making Paginated request of 2 users *************");
//		Page<Users> page0 = usersDAO.findAll(PageRequest.of(0,2));
//		page0.stream().forEach(System.out::println);
//
////		Make use of custom query methods to fetch the users using the UserDao interface and print the user details on the console.
//		System.out.println("*************Using custom queries*************");
//		System.out.println(usersDAO.findByEmail("iniesta8@gmail.com"));
//		System.out.println(usersDAO.findByFirstName("Xavi"));
//		System.out.println(usersDAO.findByFirstNameOrLastName("Hari","Prasad"));
//		System.out.println(usersDAO.findByMobileNo("8874563210"));
//
//		System.out.println("*************Printing user details corresponding to user role *************");
//		roleDAO.findById(user.getRoleId())
//				.ifPresent(role-> role.getUsers().forEach(System.out::println));


//		System.out.println("*************Printing user details corresponding to admin role *************");
//		roleDAO.findById(admin.getRoleId()).ifPresent(role -> role.getUsers().forEach(System.out::println));

//		TODO 5.3: Testing the Values of Tables: In the main() method, get the bean of 'initService’
//		 and call its start() method to pre-populate the tables of the ‘HireWheels’ database.
	}
		public void initService(){

			initService initService=new initServiceImpl();
			initService.start();

		}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
//


//
//}
	}
