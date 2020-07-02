package com.tungx.demoapi.controller;

import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.dto.CommentDTO;
import com.tungx.demoapi.entity.dto.KhachHangDTO;
import com.tungx.demoapi.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangApiController {
    private KhachHangService khachHangService;

    @Autowired
    public KhachHangApiController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }
    @PostMapping(value = "/khachhangpost")
    @ResponseBody
    public ResponseEntity<KhachHangDTO> createKhachHang(
            @RequestBody KhachHangDTO khachHang,
            UriComponentsBuilder builder) {
        khachHangService.save(khachHang);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/khachhangs/{id}")
                .buildAndExpand(khachHang.getId()).toUri());
        return new ResponseEntity<>(khachHang, HttpStatus.CREATED);
    }

    @GetMapping(value = "/khachhangget")
    @ResponseBody
    public ResponseEntity<List<KhachHangDTO>> findAllKhachHang() {
        List<KhachHangDTO> products = khachHangService.findAllKhachHang();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/khachhanggetByLinkedId")
    @ResponseBody
    public ResponseEntity<List<KhachHangDTO>> findAllKhachHangWithLinkedId(@RequestParam("linkedId") String linkedId) {
        List<KhachHangDTO> products = khachHangService.findKhachHangByLinkedId(linkedId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
