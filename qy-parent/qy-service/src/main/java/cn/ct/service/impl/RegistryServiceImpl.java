package cn.ct.service.impl;
import cn.ct.common.result.Result;
import cn.ct.common.util.Constants;
import cn.ct.common.util.EmptyUtils;
import cn.ct.dao.RegistryMapper;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.RegistryDto;
import cn.ct.model.pojo.Registry;
import cn.ct.model.req.RegistryReq;
import cn.ct.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class RegistryServiceImpl implements RegistryService {

    @Autowired
    private RegistryMapper registryMapper;


    @Override
    public Integer updateRegister(Long id) {
        return null;
    }

    @Override
    public Result<Map<String, Object>> createFee(String sign) throws Exception {
        return null;
    }

    @Override
    public Result register(RegistryReq registry) throws Exception {
        return null;
    }

    @Override
    public Page<RegistryDto> getRegisterList(RegistryReq registry) throws Exception {
        return null;
    }

    @Override
    public RegistryDto getRegister(Long id) throws Exception {
        return null;
    }
}
