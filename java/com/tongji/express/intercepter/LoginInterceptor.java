package com.tongji.express.intercepter;

import com.google.gson.Gson;
import com.tongji.express.intercepter.utils.JsonData;
import com.tongji.express.intercepter.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${interceptors.auth-ignore-uris}")
    private String authIgnoreUris;

    private String employeeFunc="/worker/getOrder,/worker/packInWare,/worker/packInBox";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器啦！");
        String uri = request.getRequestURI();
        System.out.println(uri);
        System.out.println("无需拦截的接口路径：" + authIgnoreUris);
        String[] authIgnoreUriArr = authIgnoreUris.split(",");
        String[] employeeF=employeeFunc.split(",");
        // 登录和注册接口不需要进行token拦截和校验
        for (String authIgnoreUri : authIgnoreUriArr) {
            if (authIgnoreUri.equals(uri)) {
                return true;
            }
        }
        String token = request.getHeader("Token");
        if (token == null) {
            token = request.getParameter("token");
        }
        if (token != null) {
            // 请求中是携带参数的
            Claims claims = JwtUtils.checkJWT(token);
            if (claims == null) {
                // 返回null说明用户篡改了token，导致校验失败
                sendJsonMessage(response, JsonData.buildError("token无效，请重新登录"));
                return false;
            }
            if(JwtUtils.isTokenExpired(JwtUtils.getExpirationDateFromToken(token)))
            {
                sendJsonMessage(response, JsonData.buildError("token过期,请先登录！"));
                return false;
            }
            // 用户的的主键id
            String id = (String) claims.get("userID");
            // 用户名
            String username = (String) claims.get("name");
            String role=(String) claims.get("role");
            // 把这两个参数放到请求中，从而可以在controller中获取到，不需要在controller中在用Jwt解密了,request.getAttribute("属性名")即可获取
            request.setAttribute("userID", id);
            request.setAttribute("name", username);
            request.setAttribute("role",role);
            return true;
        }
        for (String Uri : employeeF) {
            if (Uri.equals(uri)) {
                return true;
            }
        }
        sendJsonMessage(response, JsonData.buildError("token为null,请先登录！"));
        return false;
    }

    public static void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception {
        Gson g = new Gson();
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(g.toJson(obj));
        writer.close();
        response.flushBuffer();
    }
}
