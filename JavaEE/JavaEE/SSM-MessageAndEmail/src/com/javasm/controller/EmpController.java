package com.javasm.controller;

import com.javasm.constants.DataModelStatus;
import com.javasm.entity.DataModel;
import com.javasm.entity.Dep;
import com.javasm.entity.Emp;
import com.javasm.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-16:22
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Resource
    private EmpService empService;

    @GetMapping("/getDep")
    @ResponseBody
    public DataModel getEmpDep(Integer empId){
        DataModel<Emp> model = new DataModel<>();
        Emp empDep = empService.getEmpDep(empId);
        if(empDep == null){
            model.setCode(DataModelStatus.FIND_EMP_DEP_EMPTY.getCode());
            model.setMsg(DataModelStatus.FIND_EMP_DEP_EMPTY.getMsg());
        }
        model.setData(empDep);
        return model;
    }
}