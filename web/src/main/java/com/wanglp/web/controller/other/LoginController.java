package com.wanglp.web.controller.other;

import com.wanglp.common.entity.Course;
import com.wanglp.common.entity.User;
import com.wanglp.common.utils.URLConstants;
import com.wanglp.service.course.CourseService;
import com.wanglp.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther wanglp
 * @Time 15/8/15 上午9:49
 * @Email wanglp840@nenu.edu.cn
 */

@Controller
@RequestMapping(value = URLConstants.INDEX_URL)
public class LoginController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    /**
     * 进入登录页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin(Model model) {
        return "/login/login";
    }


    /**
     * 登录
     * @param request
     * @return
     */
    @RequestMapping(value = "do/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, User user, Model model){

        Connection connection = (Connection)request.getSession().getServletContext().getAttribute("connection");

        //判断用户是否存在,返回user实体  不存在页面返回错误信息
        user = userService.queryUserByNamePwd(user.getUserName(), user.getPassword(), connection);
        if (user.getId() <= 0 ){
            model.addAttribute("loginErrInfo","login error，name or password not right");
            return "/login/login";
        }

        //根据用户Id获取他的课程信息
        List<Course> list = new ArrayList<Course>();
        list = courseService.getCourseListByUserId(user.getId(),connection);

        //返回用户的课程信息,jsp页面处理
        model.addAttribute("user", user);
        model.addAttribute("courseList", list);
        return "/vip/info/user_info";
    }


    /**
     * 到注册页面
     * @param model
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String toRegister(Model model){
        return "login/register";
    }

    /**
     * 注册
     * @param request
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "do/register", method = RequestMethod.POST)
    public String doRegister(HttpServletRequest request, User user, Model model){

        //获取数据库链接
        Connection connection = (Connection)request.getSession().getServletContext().getAttribute("connection");
        //注册用户
        userService.add(user.getUserName(), user.getPassword(), connection);

        model.addAttribute("loginSucStr","register success");
        return "login/register";
    }


}
