package cn.ct.service;

import cn.ct.common.result.Result;
import cn.ct.model.dto.RoomDto;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface RoomService {
    /**
     * 根据就诊科室ID查询就诊房间列表
     * @param departmentId 就诊科室ID
     * @return
     * @throws Exception
     */
    Result<List<RoomDto>> getRoomList(Long departmentId) throws Exception;
}
