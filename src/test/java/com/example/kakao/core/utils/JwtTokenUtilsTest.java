package com.example.kakao.core.utils;

import org.junit.jupiter.api.Test;

import com.example.kakao._core.utils.JwtTokenUtils;
import com.example.kakao.user.User;

public class JwtTokenUtilsTest {
    

    @Test
    public void jwt_create_and_verify(){
        User user = User.builder().id(1).email("ssar@nate.com").build();
        String jwt = JwtTokenUtils.create(user);
        System.out.println(jwt);
    }

}
