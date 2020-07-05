package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.dto.KhachHangDTO;
import com.tungx.demoapi.repository.KhachHangRepository;
import com.tungx.demoapi.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository;

    @Autowired
    public KhachHangServiceImpl(KhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    @Override
    public List<KhachHangDTO> findAllKhachHang() {
        List<KhachHang> khachHangList = khachHangRepository.getAll();
        List<KhachHangDTO> khachHangDTOList = new ArrayList<>();
        for(int i=0; i<khachHangList.size(); i++){
            khachHangDTOList.add(toDto(khachHangList.get(i)));
        }
        return khachHangDTOList;
    }

    @Override
    public List<KhachHangDTO> findKhachHangByLinkedId(String idLinked) {
        List<KhachHang> khachHangList = khachHangRepository.findByLinkedId(idLinked);
        List<KhachHangDTO> khachHangDTOList = new ArrayList<>();
        for(int i=0; i<khachHangList.size(); i++){
            khachHangDTOList.add(toDto(khachHangList.get(i)));
        }
        return khachHangDTOList;
    }

    @Override
    public KhachHangDTO findById(Integer id) {
        KhachHang khachHang = khachHangRepository.getById(id);
        KhachHangDTO khachHangDTO = toDto(khachHang);
        return khachHangDTO;
    }

    @Override
    public void save(KhachHangDTO khachHangDTO) {
        if(findKhachHangByLinkedId(khachHangDTO.getIdLinked()).size()>0)
            return;
        khachHangRepository.add(toEntity(khachHangDTO));
    }

    @Override
    public void remove(KhachHangDTO khachHangDTO) {
        khachHangRepository.delete(toEntity(khachHangDTO));
    }

    @Override
    public KhachHangDTO toDto(KhachHang entity) {
        KhachHangDTO khachHangDTO= new KhachHangDTO();
        khachHangDTO.setId(entity.getId());
        khachHangDTO.setIdLinked(entity.getIdLinked());
        khachHangDTO.setTen(entity.getTen());
        return khachHangDTO;
    }

    @Override
    public KhachHang toEntity(KhachHangDTO dto) {
        KhachHang khachHang= new KhachHang();
        khachHang.setIdLinked(dto.getIdLinked());
        khachHang.setTen(dto.getTen());
        return khachHang;
    }

}
