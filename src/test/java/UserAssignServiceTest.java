
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.shiwu.service.UserServiceA;

public class UserAssignServiceTest extends BaseJunit4Test {

	@Autowired
    private UserServiceA userService;
	
	@Test // 标明是测试方法
	@Transactional // 标明此方法需使用事务
	@Rollback(false) // 标明使用完此方法后事务不回滚,true时为回滚
	public void insert() {
//		User user1 = new User();
//		user1.setId(2);
//		user1.setUserName("Jack");
//		user1.setAge(20);
//		user1.setPassword("123");
//		userService.updateUser(user1);
//		
//		User user2 = new User();
//		user2.setUserName("Tom");
//		user2.setAge(18);
//		user2.setPassword("123456");
//        userService.addUser(user2);
		userService.testUser();
	}

}