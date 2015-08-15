package com.wanglp.service.course.iml;

import com.wanglp.service.course.CourseService;
import com.wanglp.common.entity.Course;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/19.
 */

@Service("courseService")
public class CourseServiceIml implements CourseService {


    public Course queryCourseById(int courseId, Connection connection) {
        ResultSet resultSet = null;
        Course course = new Course();
        try {
            String sql = "SELECT* FROM t_course cou WHERE cou.`id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, courseId);
            ps.execute();
            resultSet = ps.getResultSet();

            while (resultSet.next()) {
                String courseName = resultSet.getString(3);
                Integer userId = Integer.parseInt(resultSet.getString(2));

                course.setCourseName(courseName);
                course.setUserId(userId);
            }
            course.setCourseId(courseId);

        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }
        return course;
    }

    public void editCourseByCourseId(int courseId,String courseName, Connection connection) {
        try {
            String sql = "UPDATE t_course SET t_course.course_name=?  WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(2,courseId);
            ps.setString(1,courseName);
            Boolean result = ps.execute();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }
    }

    public void deleteCourseByCourseId(int courseId, Connection connection) {
        try {
            String sql = "DELETE FROM t_course WHERE t_course.`id` =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,courseId);
            Boolean result = ps.execute();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }
    }

    public void addByCourseNameAndUserId(String courseName, int userId,Connection connection) {
        try {
            String sql = "INSERT INTO t_course(user_id,course_name) VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setString(2,courseName);
            Boolean result = ps.execute();
        }catch (SQLException e){
            System.out.println(e.getErrorCode());;
        }
    }

    public List<Course> getCourseListByUserId(int userId,Connection connection) {
        ResultSet resultSet = null;

        ArrayList<Course> list = new ArrayList<Course>();
        try {
            String sql = "SELECT * FROM t_course course WHERE course.`user_id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            Boolean result = ps.execute();
            if (result!=false){
                resultSet=ps.getResultSet();
            }
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
        try {
            while (resultSet.next()){
                String courseName= resultSet.getString(3);
                int courseId = resultSet.getInt(1);
                Course course = new Course();
                course.setCourseId(courseId);
                course.setCourseName(courseName);
                course.setUserId(userId);
                list.add(course);
            }
        }catch (SQLException e){
            System.out.print(e);
        }

        return list;
    }
}
