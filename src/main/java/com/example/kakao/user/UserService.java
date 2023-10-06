package com.example.kakao.user;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.kakao._core.errors.exception.Exception400;
import com.example.kakao._core.errors.exception.Exception500;
import com.example.kakao._core.utils.JwtTokenUtils;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userJPARepository;

    @Transactional
    public void join(UserRequest.JoinDTO requestDTO) {
        try {
            userJPARepository.save(requestDTO.toEntity());
        } catch (Exception e) {
            throw new Exception500("unknown server error");
        }
    }

    public String login(UserRequest.LoginDTO requestDTO) {
        User userPS = userJPARepository.findByEmail(requestDTO.getEmail())
            .orElseThrow(()-> new Exception400("email을 찾을 수 없습니다 : "+requestDTO.getEmail()));
        return JwtTokenUtils.create(userPS);


        //     /*암호화랑 상관 없음 - 전자서명과 관련!!(신뢰성) */
        // String jwt = JWT.create()
        //                 .withSubject("metacoding-key")
        //                 .withClaim("id", userPS.getId())
        //                 .withClaim("email", userPS.getEmail())
        //                 .withExpiresAt(Instant.now()/*현재시간*/.plusMillis(1000*60*60*24*7L))/*만료시간 설정 */
        //                 .sign(Algorithm.HMAC512("meta"));/*환경변수(OS)에 저장 해야 함 원래는 */
        // return jwt; /*토큰 검증을 필터에 안만들면, 검증이 필요한 모든곳에 다 만들어 줘야 함 */

    
    }
}
