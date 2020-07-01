package com.tungx.demoapi.controller;

import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.Product;
import com.tungx.demoapi.service.MonAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monan")
@CrossOrigin(origins = "*", maxAge = -1)
public class MonAnApiController {

    private MonAnService monAnService;

    @Autowired
    public MonAnApiController(MonAnService monAnService) {
        this.monAnService = monAnService;
    }

    @GetMapping(value = "/monans")
    @ResponseBody
    public ResponseEntity<List<MonAn>> findAllMonAn() {
        List<MonAn> products = monAnService.findAllMonAn();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/monansbychuyenmuc")
    @ResponseBody
    public ResponseEntity<List<MonAn>> findAllMonAnByChuyenMuc(@RequestParam("idcm") Integer chuyenMucId) {
        List<MonAn> products = monAnService.findAllMonAnByChuyenMucId(chuyenMucId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/monansbychuyenmuc1")
    @ResponseBody
    public ResponseEntity<List<MonAn>> findAllMonAnByChuyenMuc1(@RequestBody Integer chuyenMucId) {
        List<MonAn> products = monAnService.findAllMonAnByChuyenMucId(chuyenMucId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
