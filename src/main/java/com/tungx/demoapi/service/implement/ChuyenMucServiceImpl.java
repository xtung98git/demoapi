package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.ChuyenMuc;
import com.tungx.demoapi.repository.ChuyenMucRepository;
import com.tungx.demoapi.service.ChuyenMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ChuyenMucServiceImpl implements ChuyenMucService {

    private ChuyenMucRepository chuyenMucRepository;

    @Autowired
    public ChuyenMucServiceImpl(ChuyenMucRepository chuyenMucRepository) {
        this.chuyenMucRepository = chuyenMucRepository;
    }

    @Override
    public List<ChuyenMuc> findAllChuyenMuc() {
        return chuyenMucRepository.getAll();
    }

    @Override
    public ChuyenMuc findById(Integer id) {
        return chuyenMucRepository.getById(id);
    }

    @Override
    public void save(ChuyenMuc chuyenMuc) {

    }

    @Override
    public void remove(ChuyenMuc chuyenMuc) {

    }
}
