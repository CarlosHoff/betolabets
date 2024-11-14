package com.hoffmann.betolabets.infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hoffmann.betolabets.domain.annotation.ExtractID;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


@Component
public class JwtClaimResolver implements HandlerMethodArgumentResolver {

    @Value("${api.security.token.secret}")
    private String secret;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ExtractID.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String jwtToken = extractTokenFromHeader(request);

        ExtractID jwtClaim = parameter.getParameterAnnotation(ExtractID.class);
        if (jwtClaim != null) {
            String claimName = jwtClaim.userID();
            return extractClaimFromToken(jwtToken, claimName);
        }

        return null;
    }

    private String extractTokenFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public Long extractClaimFromToken(String token, String claimName) {
        try {
            token = token.replace("Bearer ", "");
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token);

            return decodedJWT.getClaim(claimName).asLong();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Erro desconhecido ao extrair claim do token.", e);
        }
    }

}
