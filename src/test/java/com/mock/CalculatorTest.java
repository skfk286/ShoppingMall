package com.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAddition() {
        // Mock 객체 생성
        Calculator calculator = mock(Calculator.class);

        // Mock 객체의 add 메서드가 호출될 때 10을 리턴하도록 지정
        when(calculator.add(anyInt(), anyInt())).thenReturn(11);
        
        // 테스트 대상 메서드 호출
        int result = calculator.add(3, 5);
        
        System.out.println("testAddition result : " + result);
        // 결과 검증
        // add 메서드에 어떤 정수를 전달해도 10을 리턴하도록 했으므로, 결과는 10이 나와야 합니다.
        assertEquals(11, result);
    }
    
    @Test
    public void testDivition() {
        Calculator calculator = mock(Calculator.class);
        
        when(calculator.divide(10, 0)).thenThrow(ArithmeticException.class);
        
        int result = calculator.divide(10 , 1);
    }
    
    @Test
    public void testCalculator() {
        Calculator calculator = mock(Calculator.class);

        // then 메서드를 사용하여 add 메서드와 subtract 메서드에 대한 스터빙을 연속으로 지정합니다.
        when(calculator.add(2, 3)).thenReturn(5)
                                 .thenReturn(10)
                                 .thenReturn(15);

        when(calculator.subtract(8, 4)).thenReturn(4)
                                      .thenReturn(2);

        // 테스트 대상 메서드 호출
        int result1 = calculator.add(2, 3); // 5
        int result2 = calculator.add(2, 3); // 10
        int result3 = calculator.add(2, 3); // 15
        int result4 = calculator.subtract(8, 4); // 4
        int result5 = calculator.subtract(8, 4); // 2

        // 결과 검증
        assertEquals(5, result1);
        assertEquals(10, result2);
        assertEquals(15, result3);
        assertEquals(4, result4);
        assertEquals(2, result5);
    }
}
