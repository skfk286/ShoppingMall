package com.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mapper.BoardMapper;
import com.shopping.service.BoardService;
import com.shopping.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper; 
    
    @Override
    public List<BoardVo> selectAll() {
        return boardMapper.selectAll();
    }

    @Override
    public BoardVo selectBySn(Long sn) {
        return boardMapper.selectBySn(sn);
    }

    @Override
    public void insert(BoardVo boardVo) {
        boardMapper.insert(boardVo);
    }

    @Override
    public void update(BoardVo boardVo) {
        boardMapper.update(boardVo);
    }

    @Override
    public void delete(Long sn) {
        boardMapper.delete(sn);
    }
}
