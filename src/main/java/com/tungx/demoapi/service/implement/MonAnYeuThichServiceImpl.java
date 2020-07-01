package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.Comment;
import com.tungx.demoapi.entity.MonAnYeuThich;
import com.tungx.demoapi.entity.dto.CommentDTO;
import com.tungx.demoapi.entity.dto.MonAnYeuThichDTO;
import com.tungx.demoapi.repository.MonAnYeuThichRepository;
import com.tungx.demoapi.service.MonAnYeuThichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class MonAnYeuThichServiceImpl implements MonAnYeuThichService {
    private MonAnYeuThichRepository monAnYeuThichRepository;

    @Autowired
    public MonAnYeuThichServiceImpl(MonAnYeuThichRepository monAnYeuThichRepository) {
        this.monAnYeuThichRepository = monAnYeuThichRepository;
    }

    @Override
    public List<MonAnYeuThichDTO> findAllMonAnYeuThich() {
        List<MonAnYeuThich> monAnYeuThichList =  monAnYeuThichRepository.getAll();
        List<MonAnYeuThichDTO> monAnYeuThichDTOList = new ArrayList<>();
        for(int i=0; i<monAnYeuThichList.size(); i++){
            monAnYeuThichDTOList.add(toDto(monAnYeuThichList.get(i)));
        }
        return monAnYeuThichDTOList;
    }

    @Override
    public List<MonAnYeuThichDTO> findAllMonAnYeuThichByKhachHangId(Integer khachHangId) {
        List<MonAnYeuThich> monAnYeuThichList =  monAnYeuThichRepository.findAllByKhachHangId(khachHangId);
        List<MonAnYeuThichDTO> monAnYeuThichDTOList = new ArrayList<>();
        for(int i=0; i<monAnYeuThichList.size(); i++){
            monAnYeuThichDTOList.add(toDto(monAnYeuThichList.get(i)));
        }
        return monAnYeuThichDTOList;
    }

    @Override
    public MonAnYeuThichDTO findById(Integer id) {
        MonAnYeuThich monAnYeuThich =  monAnYeuThichRepository.getById(id);
        MonAnYeuThichDTO monAnYeuThichDTO = toDto(monAnYeuThich);
        return monAnYeuThichDTO;
    }

    @Override
    public void save(MonAnYeuThichDTO monAnYeuThichDTO) {
        MonAnYeuThich monAnYeuThich =  toEntity(monAnYeuThichDTO);
        monAnYeuThichRepository.add(monAnYeuThich);
    }

    @Override
    public void remove(MonAnYeuThichDTO monAnYeuThichDTO) {
        MonAnYeuThich monAnYeuThich =  toEntity(monAnYeuThichDTO);
        monAnYeuThichRepository.delete(monAnYeuThich);
    }

    @Override
    public MonAnYeuThichDTO toDto(MonAnYeuThich entity) {
        MonAnYeuThichDTO monAnYeuThichDTO = new MonAnYeuThichDTO();
        monAnYeuThichDTO.setDay(entity.getDay());
        monAnYeuThichDTO.setMonAn(entity.getMonAn());
        monAnYeuThichDTO.setKhachHang(entity.getKhachHang());
        return monAnYeuThichDTO;
    }

    @Override
    public MonAnYeuThich toEntity(MonAnYeuThichDTO dto) {
        MonAnYeuThich monAnYeuThich = new MonAnYeuThich();
        monAnYeuThich.setDay(dto.getDay());
        monAnYeuThich.setMonAn(dto.getMonAn());
        monAnYeuThich.setKhachHang(dto.getKhachHang());
        return monAnYeuThich;
    }
}
