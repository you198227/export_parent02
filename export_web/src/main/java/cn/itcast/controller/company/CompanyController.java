package cn.itcast.controller.company;


import cn.itcast.controller.BaseController;
import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public String fun01() {

        //查询
        List<Company> companies = companyService.findAll();
        //将结果存放到域中，在页面上使用el表达式取出
        request.setAttribute("list", companies);
        //实现跳转页面
        return "company/company-list";
    }

    //添加页面
    @RequestMapping("/toAdd")
    public String fun02() {

        //这个方法直接转发到添加页面
        return "company/company-add";
    }

    //保存方法
    @RequestMapping("/edit")
    public String fun03(Company company) {

        //判断id是否为空
        if (StringUtils.isEmpty(company.getId())) {

            //因为数据表中没有id列，需要自己添加
            company.setId(UUID.randomUUID().toString());
            //调用service的保存方法
            companyService.save(company);

        } else {

            //如果id不为空
            companyService.update(company);
        }
        //保存or修改完成之后，使用重定向转发到数据列表页面
        return "redirect:list.do";
    }

    @RequestMapping("/toUpdate")
    public String fun04(String id) {

        //调用service查询id
        Company company = companyService.findById(id);

        //将得到的结果存放到域中
        request.setAttribute("company", company);
        //转发到添加列表页面，修改和保存使用一个页面
        return "company/company-add";
    }

    //根据id删除
    @RequestMapping("/delete")
    public String fun05(String id) {

        companyService.deleteById(id);

        //直接重定向到列表页面
        return "redirect:list.do";
    }

}
