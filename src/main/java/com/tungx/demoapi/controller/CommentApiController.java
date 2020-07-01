package com.tungx.demoapi.controller;

import com.tungx.demoapi.entity.Comment;
import com.tungx.demoapi.entity.GiaViSuDung;
import com.tungx.demoapi.entity.dto.CommentDTO;
import com.tungx.demoapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/cmt")
@CrossOrigin(origins = "*", maxAge = -1)
public class CommentApiController {
    private CommentService commentService;

    @Autowired
    public CommentApiController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/cmtpost")
    @ResponseBody
    public ResponseEntity<CommentDTO> createComment(
            @RequestBody CommentDTO comment,
            UriComponentsBuilder builder) {
        commentService.save(comment);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}")
                .buildAndExpand(comment.getId()).toUri());
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping(value = "/cmtget")
    @ResponseBody
    public ResponseEntity<List<CommentDTO>> findAllComment() {
        List<CommentDTO> products = commentService.findAllComment();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/cmtgetbymonanid")
    @ResponseBody
    public ResponseEntity<List<CommentDTO>> findAllCommentByMonAnId(@RequestParam("id") Integer monAnId) {
        List<CommentDTO> products = commentService.findAllCommentWithMonAnId(monAnId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/cmtgetbymonanid1")
    @ResponseBody
    public ResponseEntity<List<CommentDTO>> findAllCommentByMonAnId1(@RequestBody Integer monAnId) {
        List<CommentDTO> products = commentService.findAllCommentWithMonAnId(monAnId);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
