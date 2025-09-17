package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

//    @Autowired //기본적으로는 Food 타입으로 찾지만, Bean이 2라서 제대로 연결이 안되었을 땐 Bean의 이름으로 찾는다.
//    Food pizza;
//
//    @Autowired
//    Food chicken;

    @Autowired
    @Qualifier("pizza")
    Food food;

    @Test
    @DisplayName("Primary와 Qualifier 우선순위 확인")
    /*
    Qualifier가 더 우선됨. 상황에 따라 다르게 사용할 것
    좁은 범위일 때 더 우선되기 때문에 Qualifier가 사용됨
     */
    void test1(){
        food.eat();
    }
}
