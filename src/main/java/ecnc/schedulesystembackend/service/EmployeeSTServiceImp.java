package ecnc.schedulesystembackend.service;

import ecnc.schedulesystembackend.bean.EmployeeST;
import ecnc.schedulesystembackend.dao.EmployeeSTDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSTServiceImp implements EmployeeSTService {
    @Autowired
    EmployeeSTDao employeeSTDao;

    @Override
    public EmployeeST getSTByNetid(String netid) {
        return employeeSTDao.getSTByNetid(netid);
    }

    @Override
    public Boolean submitST(String netid, String free_time, Boolean intention, Boolean acceptAdjust) {
        if (getSTByNetid(netid) == null) {
            return employeeSTDao.insertST(netid, free_time, intention, acceptAdjust) > 0;
        } else {
            return employeeSTDao.updateST(netid, free_time, intention, acceptAdjust) > 0;
        }
    }
}
