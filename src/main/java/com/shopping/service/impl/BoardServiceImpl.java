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
        List<BoardVo> list = boardMapper.selectAll();
        
        return list;
    }

    @Override
    public BoardVo select() {
        BoardVo data = boardMapper.select();
        return data;
    }

    @Override
    public Integer insert() {
        
        return null;
    }

    @Override
    public Integer update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer delete() {
        // TODO Auto-generated method stub
        return null;
    }

}
