package cn.ct.service.impl;
import cn.ct.common.result.Result;
import cn.ct.dao.PatientMapper;
import cn.ct.model.dto.PatientDto;
import cn.ct.model.pojo.Patient;
import cn.ct.model.req.PatientReq;
import cn.ct.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Result createVisitCard(PatientReq patient) throws Exception {
        return null;
    }

    @Override
    public Result<PatientDto> getPatientByIdCard(String idCard) throws Exception {
        return null;
    }

    @Override
    public Result<PatientDto> getPatientByIdMedicare(String idMedicare) throws Exception {
        return null;
    }
}
