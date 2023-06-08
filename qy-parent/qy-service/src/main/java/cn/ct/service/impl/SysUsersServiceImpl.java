package cn.ct.service.impl;
import cn.ct.common.result.Result;
import cn.ct.common.util.Constants;
import cn.ct.common.util.EmptyUtils;
import cn.ct.common.util.PasswordUtils;
import cn.ct.dao.SysUsersMapper;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.SysUserDto;
import cn.ct.model.pojo.SysUsers;
import cn.ct.model.req.SysUserReq;
import cn.ct.service.SysUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class SysUsersServiceImpl implements SysUsersService {

    @Resource
    private SysUsersMapper sysUsersMapper;



    @Override
    public Result handleUser(Long id) throws Exception {
        return null;
    }

    @Override
    public Result<List<SysUserDto>> getDoctorList(Long departmentId) throws Exception {
        return null;
    }

    @Override
    public Page<SysUserDto> list(SysUserReq sysUserReq) throws Exception {
        return null;
    }

    @Override
    public Result addUser(SysUserReq sysUserReq, MultipartFile file) throws Exception {
        return null;
    }

    @Override
    public Result accountExit(String account) throws Exception {

        SysUserDto userByAccount = sysUsersMapper.getUserByAccount(account);
        Result<SysUserDto> result = new Result<>();
        result.setData(userByAccount);
        return result;
    }

    @Override
    public String getHeadUrl(Long userId) {
        return null;
    }
}
