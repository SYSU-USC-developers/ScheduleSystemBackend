package ecnc.schedulesystembackend.service;

import ecnc.schedulesystembackend.bean.EmployeeST;
import org.apache.ibatis.annotations.Param;

public interface EmployeeSTService {
    // 查询班表
    EmployeeST getSTByNetid(String netid);

    // 提交班表（对于用户来说，提交班表和修改班表的行为逻辑一致）
    Boolean submitST(String netid,
                     String free_time,
                     Boolean intention,
                     Boolean acceptAdjust);
}
