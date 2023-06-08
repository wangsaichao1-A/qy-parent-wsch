package cn.ct.service.impl;
import cn.ct.common.result.Result;
import cn.ct.dao.DepartmentMapper;
import cn.ct.model.dto.DepartmentDto;
import cn.ct.model.pojo.Department;
import cn.ct.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public Result<List<DepartmentDto>> getDepartmentList() throws Exception {
        return null;
    }
}
