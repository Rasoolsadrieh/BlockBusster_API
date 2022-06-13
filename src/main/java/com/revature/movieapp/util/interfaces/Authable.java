package com.revature.movieapp.util.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface Authable {

    static boolean checkAuth(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("authAccount") == null){
            resp.getWriter().write("Unauthorized request - not log in as registered customer account");
            resp.setStatus(401);
            return false;
        }
        return true;
    }
}
