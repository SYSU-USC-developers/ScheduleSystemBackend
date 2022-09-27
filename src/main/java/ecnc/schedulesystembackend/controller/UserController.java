package ecnc.schedulesystembackend.controller;

import ecnc.schedulesystembackend.bean.User;
import ecnc.schedulesystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired()
    UserService userService;

    @RequestMapping("/index")
    public Object index() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "部署成功");

        return map;
    }

    @RequestMapping("/adduser")
    public Object addUser (
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "age") String age,
            @RequestParam(value = "sex") String sex
    ) {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setAge(age);
        user.setSex(sex);

        int ret = userService.addUser(user);
        if (ret == 1) {
            map.put("code", 200);
            map.put("msg", "添加数据成功");
        } else {
            map.put("code", 100);
            map.put("msg", "添加数据失败");
        }

        return map;
    }
}
