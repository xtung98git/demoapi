package com.tungx.demoapi.controller;

import com.tungx.demoapi.entity.GiaViSuDung;
import com.tungx.demoapi.entity.NguyenLieuSuDung;
import com.tungx.demoapi.service.GiaViSuDungService;
import com.tungx.demoapi.service.NguyenLieuSuDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/giavi")
@CrossOrigin(origins = "*", maxAge = -1)
public class GiaViSuDungApiController {
    private GiaViSuDungService giaViSuDungService;

    @Autowired
    public GiaViSuDungApiController(GiaViSuDungService giaViSuDungService) {
        this.giaViSuDungService = giaViSuDungService;
    }


    @GetMapping(value = "/giavis")
    @ResponseBody
    public ResponseEntity<List<GiaViSuDung>> findAllGiaViSuDung() {
        List<GiaViSuDung> products = giaViSuDungService.findAllGiaViSuDung();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/giavisbymonanid")
    @ResponseBody
    public ResponseEntity<List<GiaViSuDung>> findAllGiaViSuDungByMonAnId(@RequestParam("idmonan") Integer monAnId) {
        List<GiaViSuDung> products = giaViSuDungService.findAllGiaViSuDungByMonAnId(monAnId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/giavisbymonanid1")
    @ResponseBody
    public ResponseEntity<List<GiaViSuDung>> findAllGiaViSuDungByMonAnId1(@RequestBody Integer monAnId) {
        List<GiaViSuDung> products = giaViSuDungService.findAllGiaViSuDungByMonAnId(monAnId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
