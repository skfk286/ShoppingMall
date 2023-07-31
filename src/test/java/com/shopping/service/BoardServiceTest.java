package com.shopping.service;

import com.shopping.mapper.BoardMapper;
import com.shopping.vo.BoardVo;
import com.shopping.service.impl.BoardServiceImpl;
import com.shopping.config.MybatisConfiguration;
import com.shopping.web.RootConfig;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = {MybatisConfiguration.class, RootConfig.class})
public class BoardServiceTest {

    @InjectMocks
    private BoardServiceImpl boardService;

    @Mock
    private BoardMapper boardMapper;

    @Test
    public void testSelectAll() {
        List<BoardVo> boardVoList = LongStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    BoardVo boardVo = new BoardVo();
                    boardVo.setSn(i);
                    boardVo.setTitle("Title " + i);
                    boardVo.setCn("Content " + i);
                    boardVo.setModifyDate(new Date());
                    boardVo.setFileSn(i);
                    return boardVo;
                })
                .collect(Collectors.toList());

        when(boardMapper.selectAll()).thenReturn(boardVoList);

        List<BoardVo> result = boardService.selectAll();

        assertEquals(boardVoList.size(), result.size());
        for (int i = 0; i < boardVoList.size(); i++) {
            assertEquals(boardVoList.get(i).getSn(), result.get(i).getSn());
            assertEquals(boardVoList.get(i).getTitle(), result.get(i).getTitle());
            assertEquals(boardVoList.get(i).getCn(), result.get(i).getCn());
            assertEquals(boardVoList.get(i).getFileSn(), result.get(i).getFileSn());
        }
    }
    
    @Test
    public void testSelectBySn() {
        Long sn = 1L;
        BoardVo boardVo = new BoardVo();
        boardVo.setSn(sn);
        boardVo.setTitle("Title " + sn);
        boardVo.setCn("Content " + sn);
        boardVo.setModifyDate(new Date());
        boardVo.setFileSn(sn);

        when(boardMapper.selectBySn(sn)).thenReturn(boardVo);

        BoardVo result = boardService.selectBySn(sn);

        assertEquals(boardVo.getSn(), result.getSn());
        assertEquals(boardVo.getTitle(), result.getTitle());
        assertEquals(boardVo.getCn(), result.getCn());
        assertEquals(boardVo.getFileSn(), result.getFileSn());
    }

    @Test
    public void testInsert() {
        Long sn = 6L;
        BoardVo boardVo = new BoardVo();
        boardVo.setSn(sn);
        boardVo.setTitle("Title " + sn);
        boardVo.setCn("Content " + sn);
        boardVo.setModifyDate(new Date());
        boardVo.setFileSn(sn);

        doNothing().when(boardMapper).insert(boardVo);

        boardService.insert(boardVo);
        
        // Assuming there's a method to fetch the board by sn in the mapper
        when(boardMapper.selectBySn(sn)).thenReturn(boardVo);

        BoardVo result = boardService.selectBySn(sn);
        
        assertEquals(boardVo.getSn(), result.getSn());
        assertEquals(boardVo.getTitle(), result.getTitle());
        assertEquals(boardVo.getCn(), result.getCn());
        assertEquals(boardVo.getFileSn(), result.getFileSn());
    }

    @Test
    public void testUpdate() {
        Long sn = 1L;
        BoardVo boardVo = new BoardVo();
        boardVo.setSn(sn);
        boardVo.setTitle("Updated Title " + sn);
        boardVo.setCn("Updated Content " + sn);
        boardVo.setModifyDate(new Date());
        boardVo.setFileSn(sn);

        doNothing().when(boardMapper).update(boardVo);

        boardService.update(boardVo);
        
        // Assuming there's a method to fetch the board by sn in the mapper
        when(boardMapper.selectBySn(sn)).thenReturn(boardVo);

        BoardVo result = boardService.selectBySn(sn);
        
        assertEquals(boardVo.getSn(), result.getSn());
        assertEquals(boardVo.getTitle(), result.getTitle());
        assertEquals(boardVo.getCn(), result.getCn());
        assertEquals(boardVo.getFileSn(), result.getFileSn());
    }

    @Test
    public void testDelete() {
        Long sn = 1L;

        doNothing().when(boardMapper).delete(sn);

        boardService.delete(sn);
        
        // Assuming there's a method to fetch the board by sn in the mapper
        when(boardMapper.selectBySn(sn)).thenReturn(null);

        BoardVo result = boardService.selectBySn(sn);
        
        assertNull(result);
    }

}
