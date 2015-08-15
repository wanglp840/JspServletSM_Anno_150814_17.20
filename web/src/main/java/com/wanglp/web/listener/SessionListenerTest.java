package com.wanglp.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2015/4/21.
 */
public class SessionListenerTest implements HttpSessionListener{
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println(sdf.format(System.currentTimeMillis())+"新创建了一个session");
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println(sdf.format(System.currentTimeMillis())+"销毁了一个session");
    }
}
