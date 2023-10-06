package com.example.kakao._core.utils;

import java.time.Instant;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.kakao.user.User;

public class JwtTokenUtils {

    public static String create(User user) {

                    /*암호화랑 상관 없음 - 전자서명과 관련!!(신뢰성) */
        String jwt = JWT.create()
                        .withSubject("metacoding-key")
                        .withClaim("id", user.getId())
                        .withClaim("email", user.getEmail())
                        .withExpiresAt(Instant.now()/*현재시간*/.plusMillis(1000*60*60*24*7L))/*만료시간 설정 */
                        .sign(Algorithm.HMAC512("meta"));/* 원래는 환경변수(OS)에 저장 해야 함 */
        return "Bearer " + jwt; /*토큰 검증을 필터에 안만들면, 검증이 필요한 모든곳에 다 만들어 줘야 함 */

    }

    public static DecodedJWT verify(String jwt)
            throws SignatureVerificationException, TokenExpiredException {
        jwt = jwt.replace("Bearer ", "");

        /* JWT를 검증한 후, 검증이 완료되면, header, payload를 base64로 복호화함 */
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("meta"))
                .build().verify(jwt);
        return decodedJWT;
    }

}
