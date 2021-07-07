package com.online.taxi.security;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * 使用RSA SHA256公钥解密的JWT令牌
 * 可验证收到的请求是否通过在Security工程中的私钥加密的。
 * Spring Security也提供了jks-uri的形式进行自动验证，为了便于对比，就没有节省这几行代码
 *
 **/
public class RSA256PublicJWTAccessToken extends JwtAccessTokenConverter {

    public RSA256PublicJWTAccessToken() throws IOException {
        Resource resource = new ClassPathResource("public.cert");
        String publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        setVerifier(new RsaVerifier(publicKey));
    }

}
