package cn.ct.service.impl;

import cn.ct.common.result.Result;
import cn.ct.dao.AuthMapper;
import cn.ct.model.dto.SysMenuDto;
import cn.ct.model.dto.SysRoleDto;
import cn.ct.model.dto.SysUserDto;
import cn.ct.service.AuthService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
@Component
public class AuthServiceImpl implements AuthService {
   /* @Resource
    private AuthMapper authMapper;
    @Override
    public SysUserDto doLogin(String account, String password) throws Exception {
        return authMapper.doLogin(account,password);
    }*/

    @Override
    public Result<List<SysMenuDto>> getMenusList(Long userId) throws Exception {
        return null;
    }

    @Override
    public Result<List<SysRoleDto>> getRolesList() throws Exception {
        return null;
    }
}
