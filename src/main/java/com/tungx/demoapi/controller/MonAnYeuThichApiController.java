package com.tungx.demoapi.controller;

import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.MonAnYeuThich;
import com.tungx.demoapi.entity.dto.CommentDTO;
import com.tungx.demoapi.entity.dto.MonAnDTO;
import com.tungx.demoapi.entity.dto.MonAnYeuThichDTO;
import com.tungx.demoapi.entity.dto.MonAnYeuThichDTOIn;
import com.tungx.demoapi.service.MonAnYeuThichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/monanyeuthich")
public class MonAnYeuThichApiController {
    private MonAnYeuThichService monAnYeuThichService;

    @Autowired
    public MonAnYeuThichApiController(MonAnYeuThichService monAnYeuThichService) {
        this.monAnYeuThichService = monAnYeuThichService;
    }

    @PostMapping(value = "/monanyeuthichspost")
    @ResponseBody
    public ResponseEntity<MonAnYeuThichDTOIn> createComment(
            @RequestBody MonAnYeuThichDTOIn comment,
            UriComponentsBuilder builder) {
        monAnYeuThichService.save(comment);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    @GetMapping(value = "/monanyeuthichsget")
    @ResponseBody
    public ResponseEntity<List<MonAnYeuThichDTO>> findAllMonAn() {
        List<MonAnYeuThichDTO> products = monAnYeuThichService.findAllMonAnYeuThich();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/monanyeuthichsgetbykhachhangid")
    @ResponseBody
    public ResponseEntity<List<MonAnDTO>> findAllMonAnByChuyenMuc(@RequestParam("idkh") Integer khachHangId) {
        List<MonAnDTO> products = monAnYeuThichService.findAllMonAnYeuThichByKhachHangId(khachHangId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/monanyeuthichsgetbykhachhangid1")
    @ResponseBody
    public ResponseEntity<List<MonAnDTO>> findAllMonAnByChuyenMuc1(@RequestBody Integer khachHangId) {
        List<MonAnDTO> products = monAnYeuThichService.findAllMonAnYeuThichByKhachHangId(khachHangId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping(value = "/checkexisted")
    @ResponseBody
    public ResponseEntity<Boolean> isExisted(@RequestParam("idkh") Integer khachHangId, @RequestParam("idma") Integer monAnId){
        Boolean check = monAnYeuThichService.isExisted(khachHangId, monAnId);
        if(check == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(check, HttpStatus.OK);
    }
}
