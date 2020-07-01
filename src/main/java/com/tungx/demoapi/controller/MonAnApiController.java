package com.tungx.demoapi.controller;

import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.Product;
import com.tungx.demoapi.service.MonAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
    @GetMapping(value = "/monansbyten")
    @ResponseBody
    public ResponseEntity<List<MonAn>> findAllMonAnByTen(@RequestParam("ten") String ten) {
        System.out.println(ten);
        List<MonAn> products = monAnService.findAllMonAnByName(ten);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/monansbyten1")
    @ResponseBody
    public ResponseEntity<List<MonAn>> findAllMonAnByTen1(@RequestBody String ten) {
        List<MonAn> products = monAnService.findAllMonAnByName(ten);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//    @RequestMapping(value = "file/{file:.+}")
//    public void download(@PathVariable(value = "file") String fileName, HttpServletResponse response) {
//        try {
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + fileName + "\""));
//
//            File file = new File(fileName);
//            Files.copy(file.toPath(), response.getOutputStream());
//        } catch (IOException e) {
//        }
//    }

    @RequestMapping(value = "/image/{file:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] download(@PathVariable(value = "file") String fileName) {
        String filePath = FileStore.UPLOAD_FOLDER + File.separator + fileName;
        File file = new File(filePath);
        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
        }
        return new byte[0];
    }
}
