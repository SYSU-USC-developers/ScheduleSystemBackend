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
    public Boolean submitST(String netid, String free_time, Boolean intention, Boolean accept_adjust) {
        return employeeSTDao.insertST(netid, free_time, intention, accept_adjust) > 0;
    }

    @Override
    public Boolean updateST(String netid, String free_time, Boolean intention, Boolean accept_adjust) {
        return employeeSTDao.updateST(netid, free_time, intention, accept_adjust) > 0;
    }
}
