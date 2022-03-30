package com.shopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shopping.vo.BoardVo;

@Mapper
public interface BoardMapper {
    public List<BoardVo> selectAll();
    public BoardVo select();
    public Integer insert();
    public Integer update();
    public Integer delete();
}
