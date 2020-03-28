package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class MyException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView view = new ModelAndView();
        //第一个参数是要在页面上用el表达式取值的名称，第二个是获取发生异常的信息
        view.addObject("errorMsg", ex.getMessage());

        //失败之后要跳转的页面
        view.setViewName("error");
        //将页面返回
        return view;
    }

}
