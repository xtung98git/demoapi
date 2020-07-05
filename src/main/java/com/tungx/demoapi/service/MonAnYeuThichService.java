package com.tungx.demoapi.service;


import com.tungx.demoapi.entity.MonAnYeuThich;
import com.tungx.demoapi.entity.dto.MonAnYeuThichDTO;
import com.tungx.demoapi.entity.dto.MonAnYeuThichDTOIn;

import java.util.List;

public interface MonAnYeuThichService {
    List<MonAnYeuThichDTO> findAllMonAnYeuThich();
    List<MonAnYeuThichDTO> findAllMonAnYeuThichByKhachHangId(Integer khachHangId);
    MonAnYeuThichDTO findById(Integer id);
    void save(MonAnYeuThichDTOIn monAnYeuThichDTO);
    void remove(MonAnYeuThichDTO monAnYeuThichDTO);
    MonAnYeuThichDTO toDto(MonAnYeuThich entity);
    MonAnYeuThich toEntity(MonAnYeuThichDTOIn dto);
}
