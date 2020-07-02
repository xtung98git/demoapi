package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.dto.MonAnDTO;
import com.tungx.demoapi.repository.MonAnRepository;
import com.tungx.demoapi.service.MonAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class MonAnServiceImpl implements MonAnService {
    private MonAnRepository monAnRepository;

    @Autowired
    public MonAnServiceImpl(MonAnRepository monAnRepository) {
        this.monAnRepository = monAnRepository;
    }

    @Override
    public List<MonAnDTO> findAllMonAn() {
        List<MonAn> monAnList = monAnRepository.getAll();
        List<MonAnDTO> monAnDTOList = new ArrayList<>();
        for(int i=0; i<monAnList.size(); i++){
            monAnDTOList.add(toDto(monAnList.get(i)));
        }
        return monAnDTOList;
    }

    @Override
    public List<MonAnDTO> findAllMonAnByChuyenMucId(Integer chuyenMucId) {
        List<MonAn> monAnList = monAnRepository.findAllMonAnByChuyenMucId(chuyenMucId);
        List<MonAnDTO> monAnDTOList = new ArrayList<>();
        for(int i=0; i<monAnList.size(); i++){
            monAnDTOList.add(toDto(monAnList.get(i)));
        }
        return monAnDTOList;
    }

    @Override
    public List<MonAnDTO> findAllMonAnByName(String name) {
        List<MonAn> monAnList = monAnRepository.findAllMonAnByName(name);
        List<MonAnDTO> monAnDTOList = new ArrayList<>();
        for(int i=0; i<monAnList.size(); i++){
            monAnDTOList.add(toDto(monAnList.get(i)));
        }
        return monAnDTOList;
    }

    @Override
    public MonAnDTO findById(Integer id) {
        MonAn monAn = monAnRepository.getById(id);
        MonAnDTO monAnDTO = toDto(monAn);
        return monAnDTO;
    }

    @Override
    public void save(MonAnDTO monAn) {
        monAnRepository.add(toEntity(monAn));
    }

    @Override
    public void remove(MonAnDTO monAn) {
        monAnRepository.delete(toEntity(monAn));
    }

    @Override
    public MonAn toEntity(MonAnDTO dto) {
        MonAn monAn = new MonAn();
        monAn.setCongThuc(dto.getCongThuc());
        monAn.setChuyenMuc(dto.getChuyenMuc());
        monAn.setMoTa(dto.getMoTa());
        monAn.setSoNguoi(dto.getSoNguoi());
        monAn.setTen(dto.getTen());
        monAn.setTenFileAnh(dto.getUrlAnh());
        return monAn;
    }

    @Override
    public MonAnDTO toDto(MonAn entity) {
        MonAnDTO monAnDTO = new MonAnDTO();
        monAnDTO.setId(entity.getId());
        monAnDTO.setCongThuc(entity.getCongThuc());
        monAnDTO.setChuyenMuc(entity.getChuyenMuc());
        monAnDTO.setMoTa(entity.getMoTa());
        monAnDTO.setSoNguoi(entity.getSoNguoi());
        monAnDTO.setTen(entity.getTen());
        String url = entity.getTenFileAnh();
        monAnDTO.setUrlAnh(url);
        return monAnDTO;
    }
}
