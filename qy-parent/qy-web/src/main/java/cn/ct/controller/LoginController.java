package cn.ct.controller;
import cn.ct.common.result.Result;
import cn.ct.common.util.PasswordUtils;
import cn.ct.common.util.RedisUtils;
import cn.ct.dao.AuthMapper;
import cn.ct.model.dto.SysUserDto;
import cn.ct.service.SysUsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.util.Password;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
@RequestMapping("/api")
@Controller
public class LoginController {

    @Resource
    private SysUsersService sysUsersService;
    @Resource
    private AuthMapper authMapper;

    @Resource
    private RedisUtils redisUtils;
   @Resource
    private ObjectMapper objectMapper;

    @RequestMapping("/")
    public String toLogin() {

        return "login";
    }

    @RequestMapping("/doLogin")
    public String toLogin(String account ,String password, Model model, HttpServletResponse response, HttpSession session) throws Exception {
        Result<SysUserDto> result = sysUsersService.accountExit(account);
        SysUserDto userDto = result.getData();

       if (userDto != null){
            if (PasswordUtils.match(password, userDto.getPassword())){
               model.addAttribute("serSession",userDto);
               session.setAttribute("userSession",userDto);
                return "main";
            }else {

            }
       }else {
           return "login";
       }
        return "login";
    }

}
