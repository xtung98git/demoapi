package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.repository.MonAnRepository;
import com.tungx.demoapi.service.MonAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<MonAn> findAllMonAn() {
        return monAnRepository.getAll();
    }

    @Override
    public List<MonAn> findAllMonAnByChuyenMucId(Integer chuyenMucId) {
        return monAnRepository.findAllMonAnByChuyenMucId(chuyenMucId);
    }

    @Override
    public List<MonAn> findAllMonAnByName(String name) {
        return monAnRepository.findAllMonAnByName(name);
    }

    @Override
    public MonAn findById(Integer id) {
        return monAnRepository.getById(id);
    }

    @Override
    public void save(MonAn monAn) {
        monAnRepository.add(monAn);
    }

    @Override
    public void remove(MonAn monAn) {
        monAnRepository.delete(monAn);
    }
}
