package com.javasm.controller;

import com.javasm.constants.DataModelStatus;
import com.javasm.entity.DataModel;
import com.javasm.entity.Dep;
import com.javasm.entity.Emp;
import com.javasm.service.DepService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-16:23
 * @Since:jdk1.8
 * @Description:TODO
 */
@Controller
@RequestMapping("/dep")
public class DepController {
    @Resource
    private DepService depService;

    @GetMapping("/getEmp")
    @ResponseBody
    public DataModel getDepEmps(Integer depId) {
        DataModel<List> model = new DataModel<>();
        List<Emp> list = depService.getDepEmps(depId);
        if (list.size() == 0 || list == null) {
            model.setCode(DataModelStatus.FIND_DEP_EMPS_EMPTY.getCode());
            model.setMsg(DataModelStatus.FIND_DEP_EMPS_EMPTY.getMsg());
        }
        model.setData(list);
        return model;
    }
}