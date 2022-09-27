package ecnc.schedulesystembackend.controller;

import ecnc.schedulesystembackend.bean.EmployeeST;
import ecnc.schedulesystembackend.service.EmployeeSTService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            ret.put("free_time", employeeST.getFree_time());
            ret.put("intention", employeeST.getIntention());
            ret.put("accept_adjust", employeeST.getAccept_adjust());

            return ret;
        }
    }

    @PostMapping("/est")
    public Object submitST(@RequestBody EmployeeST employeeST) {
        Boolean ret_value = employeeSTService.submitST(employeeST.getNetid(),
                                                        employeeST.getFree_time(),
                                                        employeeST.getIntention(),
                                                        employeeST.getAccept_adjust());
        Map<String, Object> ret = new HashMap<>();

        if (ret_value == false) {
            ret.put("msg", "submit failed");
            return ret;
        } else {
            ret.put("msg", "submit succeed");
            return ret;
        }
    }

    @PutMapping("/est/{netid}")
    public Object submitST(@PathVariable String netid, @RequestBody EmployeeST employeeST) {
        Boolean ret_value = employeeSTService.updateST(employeeST.getNetid(),
                                                        employeeST.getFree_time(),
                                                        employeeST.getIntention(),
                                                        employeeST.getAccept_adjust());
        Map<String, Object> ret = new HashMap<>();

        if (ret_value == false) {
            ret.put("msg", "update failed");
            return ret;
        } else {
            ret.put("msg", "update succeed");
            return ret;
        }
    }
}
