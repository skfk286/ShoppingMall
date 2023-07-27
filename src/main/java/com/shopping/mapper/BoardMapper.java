package com.shopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shopping.vo.BoardVo;

@Mapper
public interface BoardMapper {
    List<BoardVo> selectAll();
    BoardVo selectBySn(@Param("sn") Long sn);
    void insert(BoardVo boardVo);
    void update(BoardVo boardVo);
    void delete(@Param("sn") Long sn);
}
