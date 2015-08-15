# JspServletSpringMVC_150814_09-24


工程说明:        add－time:150815 11:00


  跳过bean单独配置，直接使用注入和扫包方法：

1.不用在application中配置处理controller映射 不用定义控制器，只要如下内容即可：
<!--注解驱动 扫包-->
<mvc:annotation-driven />

<context:component-scan base-package="com.wanglp.web" />
<context:component-scan base-package="com.wanglp.service" />
<context:component-scan base-package="com.wanglp.common"/>

<bean id = "viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
    <property name="prefix" value="/WEB-INF/views/"/>
    <property name="suffix" value=".jsp"/>
    <property name="order" value="1"></property>
</bean>



2.提出URL常量类，用配置requestMapping,不再使用xx.do再使用方法名匹配，而是每个请求都配置一个url


3.controller 中使用@Controller  @RequestMapping @Pathvariable @.....
  service中使用@Service 


4.controller不用继承其他，方法返回类型String， model参数传入

以前：LoginController extends MultiActionController
public ModelAndView toLoginPage(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException{
      return new ModelAndView("login/login");
}
现在：
public Sting xx（Model model｛
    return "/login/login”;
｝


5.controller下使用注入使用service方法，前端参数接收直接使用实体，注意与jsp中属性值与实体一致


6.方法中可以传入request（属性值） response参数


异 close 码


