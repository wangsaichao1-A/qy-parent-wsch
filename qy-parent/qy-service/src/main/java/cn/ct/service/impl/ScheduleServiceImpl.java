package cn.ct.service.impl;
import cn.ct.common.result.Result;
import cn.ct.dao.ScheduleMapper;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.ScheduleDto;
import cn.ct.model.pojo.Schedule;
import cn.ct.model.req.ScheduleReq;
import cn.ct.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;


    @Override
    public Result addSchedule(ScheduleReq schedule) throws Exception {
        return null;
    }

    @Override
    public Result deleteScheduleById(Long id) throws Exception {
        return null;
    }

    @Override
    public Page<ScheduleDto> getScheduleList(ScheduleReq schedule) throws Exception {
        return null;
    }

    @Override
    public Result<List<ScheduleDto>> getDoctorList(Long departmentId, Integer sign) throws Exception {
        return null;
    }
}
