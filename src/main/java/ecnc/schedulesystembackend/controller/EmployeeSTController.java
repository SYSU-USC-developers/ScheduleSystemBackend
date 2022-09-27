package ecnc.schedulesystembackend.controller;

import ecnc.schedulesystembackend.bean.EmployeeST;
import ecnc.schedulesystembackend.service.EmployeeSTService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeSTController {
    @Autowired
    EmployeeSTService employeeSTService;

    @GetMapping("/est/{netid}")
    public Object getSTByNetid(@PathVariable String netid) {
        EmployeeST employeeST = employeeSTService.getSTByNetid(netid);
        Map<String, Object> ret = new HashMap<>();

        if (employeeST == null) {
            ret.put("msg", "not found");
            return ret;
        } else {
            ret.put("netid", employeeST.getNetid());
            return ret;
        }
    }
}
