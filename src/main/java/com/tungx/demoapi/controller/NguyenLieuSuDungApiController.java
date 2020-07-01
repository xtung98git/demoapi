package com.tungx.demoapi.controller;

import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.NguyenLieuSuDung;
import com.tungx.demoapi.service.MonAnService;
import com.tungx.demoapi.service.NguyenLieuSuDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nguyenlieu")
@CrossOrigin(origins = "*", maxAge = -1)
public class NguyenLieuSuDungApiController {
    private NguyenLieuSuDungService nguyenLieuSuDungService;

    @Autowired
    public NguyenLieuSuDungApiController(NguyenLieuSuDungService nguyenLieuSuDungService) {
        this.nguyenLieuSuDungService = nguyenLieuSuDungService;
    }

    @GetMapping(value = "/nguyenlieus")
    @ResponseBody
    public ResponseEntity<List<NguyenLieuSuDung>> findAllMonAn() {
        List<NguyenLieuSuDung> products = nguyenLieuSuDungService.findAllNguyenLieuSuDung();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/nguyenlieusbymonan")
    @ResponseBody
    public ResponseEntity<List<NguyenLieuSuDung>> findAllMonAnByChuyenMuc(@RequestParam("idmonan") Integer monAnId) {
        List<NguyenLieuSuDung> products = nguyenLieuSuDungService.findAllNguyenLieuSuDungByMonAnId(monAnId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/nguyenlieusbymonan1")
    @ResponseBody
    public ResponseEntity<List<NguyenLieuSuDung>> findAllMonAnByChuyenMuc1(@RequestBody Integer monAnId) {
        List<NguyenLieuSuDung> products = nguyenLieuSuDungService.findAllNguyenLieuSuDungByMonAnId(monAnId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
