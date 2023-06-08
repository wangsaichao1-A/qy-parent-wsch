package cn.ct.service.impl;
import cn.ct.common.util.Constants;
import cn.ct.common.util.EmptyUtils;
import cn.ct.dao.MedicalAdviceMapper;
import cn.ct.model.dto.MedicalAdviceDto;
import cn.ct.model.dto.Page;
import cn.ct.model.pojo.MedicalAdvice;
import cn.ct.service.MedicalAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class MedicalAdviceServiceImpl implements MedicalAdviceService {

    @Autowired
    private MedicalAdviceMapper medicalAdviceMapper;


    @Override
    public MedicalAdviceDto getMedicalAdvice(Long registryId) {
        return null;
    }
}
