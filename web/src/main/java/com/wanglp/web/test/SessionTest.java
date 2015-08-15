package com.wanglp.web.test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/21.
 */
public class SessionTest {
    public void SessionTest(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession(false);
        /*session.invalidate();
        session=request.getSession();*/
        /*session.setMaxInactiveInterval(20);*/
        session.setAttribute("sessionIdTest",521);
        //创建时间
        long creationTime = 0;
        try {
            creationTime = session.getCreationTime();
        }catch (Exception e){
            System.out.print(e);
        }
        //时间格式
        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        //前面的creationTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Date dt = new Date(creationTime * 1000);
        String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
        System.out.println(sDateTime);
        System.out.println(sdf.format(System.currentTimeMillis()));


        //--------cookie 1test
        Cookie cookie = new Cookie("userName","wanglp840");
        /*cookie.setMaxAge(1*60);*/
        response.addCookie(cookie);
    }
}
