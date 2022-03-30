package com.shopping.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.service.BoardService;
import com.shopping.vo.BoardVo;

@Controller
public class BoardController {
    
    private final static Logger logger = LogManager.getLogger(BoardController.class);
    
    public BoardController() {
        System.out.println("gen@@@@@@@@@@@@@@@@@@@@@");
    }
    @Autowired
    private BoardService boardService;
    
    @ResponseBody
    @RequestMapping(value = "/board/init.do", method = RequestMethod.GET)
    public List<BoardVo> selectAll() {
        
        System.out.println("/board/init.do");
        
        return boardService.selectAll();
    }
    
    
}
