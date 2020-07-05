package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.Comment;
import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.MonAnYeuThich;
import com.tungx.demoapi.entity.dto.CommentDTO;
import com.tungx.demoapi.entity.dto.MonAnDTO;
import com.tungx.demoapi.entity.dto.MonAnYeuThichDTO;
import com.tungx.demoapi.entity.dto.MonAnYeuThichDTOIn;
import com.tungx.demoapi.repository.KhachHangRepository;
import com.tungx.demoapi.repository.MonAnRepository;
import com.tungx.demoapi.repository.MonAnYeuThichRepository;
import com.tungx.demoapi.service.MonAnService;
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
    private MonAnRepository monAnRepository;
    private KhachHangRepository khachHangRepository;
    private MonAnService monAnService;

    @Autowired
    public MonAnYeuThichServiceImpl(MonAnYeuThichRepository monAnYeuThichRepository, MonAnRepository monAnRepository, KhachHangRepository khachHangRepository, MonAnService monAnService) {
        this.monAnYeuThichRepository = monAnYeuThichRepository;
        this.monAnRepository = monAnRepository;
        this.khachHangRepository = khachHangRepository;
        this.monAnService = monAnService;
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
    public List<MonAnDTO> findAllMonAnYeuThichByKhachHangId(Integer khachHangId) {
        List<MonAnYeuThich> monAnYeuThichList =  monAnYeuThichRepository.findAllByKhachHangId(khachHangId);
        List<MonAnDTO> monAnYeuThichDTOList = new ArrayList<>();
        for(int i=0; i<monAnYeuThichList.size(); i++){
            monAnYeuThichDTOList.add(monAnService.toDto(monAnYeuThichList.get(i).getMonAn()));
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
    public void save(MonAnYeuThichDTOIn monAnYeuThichDTO) {
        MonAnYeuThich monAnYeuThich =  toEntity(monAnYeuThichDTO);
        monAnYeuThichRepository.add(monAnYeuThich);
    }

    @Override
    public void remove(MonAnYeuThichDTO monAnYeuThichDTO) {

    }


    @Override
    public MonAnYeuThichDTO toDto(MonAnYeuThich entity) {
        MonAnYeuThichDTO monAnYeuThichDTO = new MonAnYeuThichDTO();
        monAnYeuThichDTO.setMonAn(entity.getMonAn());
        return monAnYeuThichDTO;
    }

    @Override
    public MonAnYeuThich toEntity(MonAnYeuThichDTOIn dto) {
        MonAnYeuThich monAnYeuThich = new MonAnYeuThich();
        monAnYeuThich.setDay(dto.getDay());
        MonAn monAn = monAnRepository.getById(dto.getIdMonAn());
        monAnYeuThich.setMonAn(monAn);
        KhachHang khachHang = khachHangRepository.getById(dto.getIdKhachHang());
        monAnYeuThich.setKhachHang(khachHang);
        return monAnYeuThich;
    }
}
