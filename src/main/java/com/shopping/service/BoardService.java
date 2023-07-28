package com.shopping.service;

import java.util.List;

import com.shopping.vo.BoardVo;

public interface BoardService {
    List<BoardVo> selectAll();
    BoardVo selectBySn(Long sn);
    void insert(BoardVo boardVo);
    void update(BoardVo boardVo);
    void delete(Long sn);
}
