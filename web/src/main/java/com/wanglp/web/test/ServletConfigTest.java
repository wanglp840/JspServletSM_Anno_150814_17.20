package com.wanglp.web.test; /**
 * @Author: Administrator
 * @Time: 2015/4/1.
 */

import javax.servlet.ServletConfig;


public class ServletConfigTest{
    public void getConfig(ServletConfig config){
        System.out.print(config.getServletContext().getAttribute("testParam"));
    }

}
