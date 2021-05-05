Spring分为两个容器:
    SpringContext //JavaSE
    SpringWebContext //JavaEE 与Spring上下文是被包含的关系

Spring核心注解:
    @Controller : 标记当前类为Handler(处理器),交给SpringMVC管理
    @Service : 标记当前类为业务类,交给Spring管理
    @Repository : 标记当前为数据访问类,交给Spring管理
    @Component : 标记当前类为组件类,交给Spring管理
    @Configuration : 标记当前类为配置类,交给Spring管理
    @RequestMapping : 给当前类(handler)或方法(method)添加映射路径(HandlerMapping)
        - @RequestParam() 可以手动映射当前参数在请求域中的名称
                    name  : 请求域中的名称
                    required : 是否必填,若请求域中没有该参数,则报错
                    defaultValue : 默认值
        - @DateTimeFormat(pattern) 格式化时间,可以在入参参数或者对象的成员属性上定义.解决SpringMVC无法自动字符串转时间的问题
            开注解需要mvc注解扫描支持. 需要在核心配置文件中开启
            <!--开启MVC注解扫描-->
            <mvc:annotation-driven></mvc:annotation-driven>
        - @RequestMapping(path = "/getUser",method = {RequestMethod.POST})
            -- 通过path来设置请求路径,同时可以通过method来限制当前handlerMethod的请求方式,可以支持多种请求方式. 默认是不限定

        - @PostMapping("/path") - 相当于@RequestMapping(path="",method={RequestMethod.POST}) 添加操作
        - @GetMapping("/path") - 相当于@RequestMapping(path="",method={RequestMethod.GET}) 查询操作
        - @DeleteMapping("/path") - 相当于@RequestMapping(path="",method={RequestMethod.DELETE}) 删除操作
        - @PutMapping("/path") - 相当于@RequestMapping(path="",method={RequestMethod.PUT}) 编辑操作



SpringMVC数据响应核心对象
    Model : 数据模型对象. 当在Handler的方法中的返回值为String 入参参数列表中加入了Model时,Spring的HandlerAdapter在调用Method时,会自动将Model传递进来.
            SpringMVC在调用完HandlerMethod时,会将Method中的参数包装到Request的Attribute中响应回前端.将返回的String包装到View对象中. 也就是ModelAndView对象
    ModelAndView : 数据和视图模型对象.
            当在Handler的方法中声明返回值为ModelAndView时,可以通过它的setViewName("视图名称")来设置跳转的视图
                                                         通过addObject来向Request请求域中保存需要传递的参数.
SpringMVC获取内置对象
    当需要在HandlerMethod中操作request,response,session时,只需要在方法入参列表中传入即可操作.
        HttpServletRequest HttpServletResponse HttpSession
    @SessionAttribute("参数名") session和获取也可以直接在参数列表中通过注解来获取.前提是Session中必须得有指定的参数.

SpringMVC的转发和重定向
    返回String或者设置视图名时,默认是转发.
    同时也可以设置视图名为 forward:视图名/地址  设置转发
                          redirect:视图名/地址  设置重定向