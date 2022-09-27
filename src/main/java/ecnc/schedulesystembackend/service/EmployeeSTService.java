package ecnc.schedulesystembackend.service;

import ecnc.schedulesystembackend.bean.EmployeeST;
import org.apache.ibatis.annotations.Param;

public interface EmployeeSTService {
    // 查询班表
    EmployeeST getSTByNetid(String netid);

    // 提交班表
    Boolean submitST(String netid,
                     String free_time,
                     Boolean intention,
                     Boolean accept_adjust);

    // 修改班表
    Boolean updateST(String netid,
                     String free_time,
                     Boolean intention,
                     Boolean accept_adjust);
}
