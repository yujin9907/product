package site.metacoding.firstapp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class MyParseTest {
    // 테스트 어노테이션 메서드에 붙는 거임. 어디에 붙는지 위치 확인 잘
    @Test
    public void changeStringToInt_test(){
        // 리턴, 매개변수 절대 못 받음

        //given
        String value = "1";

        //when
        int result = Integer.parseInt(value);

        //then
        assertEquals(1, result);
    }
}
