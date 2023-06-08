package cn.ct.service.impl;
import cn.ct.common.result.Result;
import cn.ct.dao.RoomMapper;
import cn.ct.model.dto.RoomDto;
import cn.ct.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;


    @Override
    public Result<List<RoomDto>> getRoomList(Long departmentId) throws Exception {
        return null;
    }
}
