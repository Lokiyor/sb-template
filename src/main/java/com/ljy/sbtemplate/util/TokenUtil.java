package com.ljy.sbtemplate.util;


import io.jsonwebtoken.*;

import java.util.Date;

/**
 * jwt token 帮助类
 */
public class TokenUtil {
    /** www.taiwu.com md5后结果 **/
    private final static String TOKEN_SECRET = "dcf6f2e4aa57beb155ba348b8f52a13e";

    /**
     * 根据userid生成token
     * @param userId
     * @return
     */
    public static String issue(String userId) throws Exception{
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setId(userId)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, TOKEN_SECRET);

        return builder.compact();
    }

    /**
     * 分析token，得到userid
     * @param token
     * @return
     */
    public static String parse(String token) throws Exception {
        String userId = "";
        try {
            Claims claim = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            userId = claim.getId();
        }catch (MalformedJwtException e){
            throw new Exception("非法或者无效的token");
        }
        return userId;
    }

    public static void main(String[] args) {
        try {
            String userId = "1052856";
            String token = TokenUtil.issue(userId);
            System.out.println("token = [" + token + "]");
            System.out.println("parse userId=[" + TokenUtil.parse(token) + "]");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

