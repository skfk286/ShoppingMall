package com.shopping.service;

import java.util.List;

import com.shopping.vo.BoardVo;

public interface BoardService {
    List<BoardVo> selectAll();
    BoardVo selectBySn(Long sn);
    BoardVo insert(BoardVo boardVo);
    BoardVo update(BoardVo boardVo);
    void delete(Long sn);
}
