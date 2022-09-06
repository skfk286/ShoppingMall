package com.shopping.service;

import java.util.List;

import com.shopping.vo.BoardVo;

public interface BoardService {
    public List<BoardVo> selectAll();
    public BoardVo select();
    public Integer insert();
    public Integer update();
    public Integer delete();
}
