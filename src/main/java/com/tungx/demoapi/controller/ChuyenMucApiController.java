package com.tungx.demoapi.controller;

import com.tungx.demoapi.entity.ChuyenMuc;
import com.tungx.demoapi.service.ChuyenMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cm")
@CrossOrigin(origins = "*", maxAge = -1)
public class ChuyenMucApiController {
    private ChuyenMucService chuyenMucService;

    @Autowired
    public ChuyenMucApiController(ChuyenMucService chuyenMucService) {
        this.chuyenMucService = chuyenMucService;
    }

    @GetMapping(value = "/cmget")
    @ResponseBody
    public ResponseEntity<List<ChuyenMuc>> findAllChuyenMuc() {
        List<ChuyenMuc> products = chuyenMucService.findAllChuyenMuc();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
