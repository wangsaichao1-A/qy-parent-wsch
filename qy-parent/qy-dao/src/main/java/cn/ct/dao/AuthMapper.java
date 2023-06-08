package cn.ct.dao;

import cn.ct.model.dto.SysUserDto;
import org.apache.ibatis.annotations.Param;

public interface AuthMapper {

    public SysUserDto doLogin(String account, String password) throws Exception;
}
