package com.shopping.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.shopping.config.MybatisConfiguration;
import com.shopping.vo.BoardVo;
import com.shopping.wasboot.WebInitializer;
import com.shopping.web.RootConfig;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WebInitializer.class)
@ContextConfiguration(classes = {RootConfig.class, MybatisConfiguration.class}) // Add your configuration class here
// @TestPropertySource(locations = "classpath:application.properties")
// @Transactional
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @BeforeEach
    public void setUp() {
        // Initialize test data if needed
        // For example, you can insert some sample data to the test database here
    }

    @Test
    public void test01() {
        assertEquals(1,1);
    }
    
    @Test
    public void testSelectAll() {
        List<BoardVo> boards = boardMapper.selectAll();
        
        for(BoardVo item : boards) {
            System.out.println(item.toString());
        }
        // Add assertions to check the result
        // assertEquals(2, boards.size()); // Assuming there are 2 records in the sample data
    }

    @Test
    public void testSelectBySn() {
        Long sn = 9999L;
        BoardVo board = boardMapper.selectBySn(sn);
        System.out.println(board.toString());
        // Add assertions to check the result
        // assertEquals("Title 1", board.getTitle()); // Assuming the title of the first record is "Title 1"
    }

    @Test
    public void testInsert() {
        // Create a BoardVo object with test data
        BoardVo board = new BoardVo();
        board.setSn(9999L);
        board.setTitle("New Title");
        board.setCn("New Content");
        board.setFileSn(9999L);

        boardMapper.insert(board); // Insert the test data

        // Now you can check the result, maybe by calling selectAll() and checking the size, etc.
        // Or you can perform another specific test for the insert operation
    }

    @Test
    public void testUpdate() {
        // Create a BoardVo object with test data
        BoardVo board = new BoardVo();
        board.setSn(1L); // Assuming you are updating the first record
        board.setTitle("Updated Title");
        board.setCn("Updated Content");

        boardMapper.update(board); // Update the test data

        // Now you can check the result, maybe by calling selectBySn() and checking the updated fields, etc.
        // Or you can perform another specific test for the update operation
    }

    @Test
    public void testDelete() {
        Long sn = 1L; // Assuming you are deleting the first record

        boardMapper.delete(sn); // Delete the record

        // Now you can check the result, maybe by calling selectAll() and checking the size, etc.
        // Or you can perform another specific test for the delete operation
    }
}
