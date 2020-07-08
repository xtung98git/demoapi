package com.tungx.demoapi.service.implement;

import com.tungx.demoapi.entity.Comment;
import com.tungx.demoapi.entity.KhachHang;
import com.tungx.demoapi.entity.MonAn;
import com.tungx.demoapi.entity.dto.CommentDTO;
import com.tungx.demoapi.repository.CommentRepository;
import com.tungx.demoapi.repository.KhachHangRepository;
import com.tungx.demoapi.repository.MonAnRepository;
import com.tungx.demoapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private KhachHangRepository khachHangRepository;
    private MonAnRepository monAnRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, KhachHangRepository khachHangRepository, MonAnRepository monAnRepository) {
        this.commentRepository = commentRepository;
        this.khachHangRepository = khachHangRepository;
        this.monAnRepository = monAnRepository;
    }

    @Override
    public List<CommentDTO> findAllComment() {
        List<Comment> commentList =  commentRepository.getAll();
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for(int i=0; i<commentList.size(); i++){
            commentDTOList.add(toDto(commentList.get(i)));
        }
        return commentDTOList;
    }

    @Override
    public List<CommentDTO> findAllCommentWithMonAnId(Integer monAnId) {
        List<Comment> commentList =  commentRepository.findAllByMonAnId(monAnId);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for(int i=0; i<commentList.size(); i++){
            commentDTOList.add(toDto(commentList.get(i)));
        }
        return commentDTOList;
    }

    @Override
    public CommentDTO findById(Integer id) {
        Comment comment = commentRepository.getById(id);
        CommentDTO commentDTO = toDto(comment);
        return commentDTO;
    }

    @Override
    public void save(CommentDTO commentDto) {
        Comment comment = toEntity(commentDto);
        commentRepository.add(comment);
        commentDto.setId(comment.getId());
    }

    @Override
    public void remove(CommentDTO commentDto) {
        Comment comment = toEntity(commentDto);
        commentRepository.delete(comment);
    }

    @Override
    public Comment toEntity(CommentDTO dto) {
        Comment cmt = new Comment();
//        cmt.setId(dto.getId());
        cmt.setNgayDang(dto.getNgayDang());
        KhachHang khachHang = khachHangRepository.getById(dto.getIdKhachHang());
        cmt.setKhachHang(khachHang);
        MonAn monAn = monAnRepository.getById(dto.getIdMonAn());
        cmt.setMonAn(monAn);
        cmt.setNoiDung(dto.getNoiDung());
        return cmt;
    }

    @Override
    public CommentDTO toDto(Comment entity) {
        CommentDTO cmt = new CommentDTO();
        cmt.setId(entity.getId());
        cmt.setIdKhachHang(entity.getKhachHang().getId());
        cmt.setTenKhachHang(entity.getKhachHang().getTen());
        cmt.setNoiDung(entity.getNoiDung());
        cmt.setIdMonAn(entity.getMonAn().getId());
        cmt.setNgayDang(entity.getNgayDang());
        cmt.setUrlImage(entity.getKhachHang().getUrlImage());
        return cmt;
    }
}
