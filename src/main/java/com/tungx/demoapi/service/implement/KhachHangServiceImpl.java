package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.repository.KhachHangRepository;
import com.tungx.demoapi.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<KhachHang> findAllKhachHang() {
        return null;
    }

    @Override
    public KhachHang findById(Integer id) {
        return khachHangRepository.getById(id);
    }

    @Override
    public void save(KhachHang khachHang) {
        khachHangRepository.add(khachHang);
    }

    @Override
    public void remove(KhachHang khachHang) {
        khachHangRepository.delete(khachHang);
    }
}
