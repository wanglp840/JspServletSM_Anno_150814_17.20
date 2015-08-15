package com.wanglp.web.controller.vip;

import com.wanglp.service.course.CourseService;
import com.wanglp.common.entity.Course;
import com.wanglp.common.entity.User;
import com.wanglp.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.wanglp.common.utils.URLConstants;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther wanglp
 * @Time 15/8/15 上午11:49
 * @Email wanglp840@nenu.edu.cn
 */
@Controller
@RequestMapping(URLConstants.VIP_COURSE_URL)
public class UserInfoController{

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;


    /**
     * 到新增课程页
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "new/{userId}", method = RequestMethod.GET)
    public String toAdd(@PathVariable("userId") Integer userId, Model model){
        model.addAttribute("userId", userId);  //页面有显示
        return "vip/course/course_add";
    }

    /**
     * 新增课程 处理
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "new/{userId}", method = RequestMethod.POST)
    public String add(@PathVariable("userId") Integer userId,
                      @RequestParam String courseName, HttpServletRequest request, Model model){

        //获取数据库连接
        Connection connection = (Connection)request.getSession().getServletContext().getAttribute("connection");

        //新增课程
        courseService.addByCourseNameAndUserId(courseName, userId, connection);

        //获取新增后该用户的课程列表
        List<Course> list = new ArrayList<Course>();
        list = courseService.getCourseListByUserId(userId, connection);

        User user = userService.queryUserById(userId, connection);
        model.addAttribute("user", user);
        model.addAttribute("courseList",list);

        return "vip/info/user_info";
    }


    /**
     * 到课程编辑 界面
     * @param courseId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "edit/{courseId}", method = RequestMethod.GET)
    public String toEditPage(@PathVariable Integer courseId, HttpServletRequest request, Model model){
        //获取数据库连接
        Connection connection = (Connection)request.getSession().getServletContext().getAttribute("connection");

        Course course = courseService.queryCourseById(courseId,connection);
        User user = userService.queryUserById(course.getUserId(), connection);

        model.addAttribute("user", user);
        model.addAttribute("course", course);

        return "vip/course/course_edit";
    }


    /**
     * 编辑课程提交
     * @param courseId
     * @param courseName
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "edit/{courseId}", method = RequestMethod.POST)
    public String doEdit(@PathVariable Integer courseId,
                         @RequestParam String courseName, HttpServletRequest request, Model model){

        Connection connection = (Connection)request.getSession().getServletContext().getAttribute("connection");

        Integer userId = courseService.queryCourseById(courseId, connection).getUserId();
        //修改课程信息
        courseService.editCourseByCourseId(courseId, courseName, connection);

        //获取修改后的课程列表
        List<Course> list = new ArrayList<Course>();
        list = courseService.getCourseListByUserId(userId,connection);

        User user = userService.queryUserById(userId, connection);

        model.addAttribute("user", user);
        model.addAttribute("courseList", list);
        return "vip/info/user_info";
    }


    /**
     * 删除课程
     * @param courseId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "del/{courseId}", method = RequestMethod.GET)
    public String del(@PathVariable Integer courseId, HttpServletRequest request, Model model){

        Connection connection = (Connection)request.getSession().getServletContext().getAttribute("connection");

        //查询出user  不能放在下一句的后面  因为用到courseId 删除了就没有了
        User user = userService.queryUserById(courseService.queryCourseById(courseId,connection).getUserId(),connection);
        //删除
        courseService.deleteCourseByCourseId(courseId, connection);

        //获取删除后其余课程信息
        List<Course> list = new ArrayList<Course>();
        list = courseService.getCourseListByUserId(user.getId(),connection);

        model.addAttribute("user", user);
        model.addAttribute("courseList",list);
        return "vip/info/user_info";
    }
}
