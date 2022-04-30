package com.test;

        import com.pojo.User;
        import com.service.UserService;
        import org.junit.Test;

        import java.util.List;

public class userServiceTest {
    public UserService test = new UserService();
//    @Test
//    public void login() {
//        if(test.login(new User("jeff","362143"))!=null){
//            System.out.println("success");
//        }else {
//            System.out.println("fail");
//        }
//    }

    @Test
    public void getUserInfo() {
        List<User> users = test.getAllUserInfo();
        System.out.println(users);
    }

}
