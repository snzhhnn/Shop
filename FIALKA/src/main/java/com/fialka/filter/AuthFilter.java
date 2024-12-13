package com.fialka.filter;

import com.fialka.dto.UserDTO;
import com.fialka.exception.InvalidPasswordException;
import com.fialka.repository.Impl.UserRepositoryImpl;
import com.fialka.service.Impl.UserServiceImpl;
import com.fialka.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", value = "/login")
public class AuthFilter implements Filter {

    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    public void init(FilterConfig filterConfig) {
        ServletContext servletContext = filterConfig.getServletContext();
        servletContext.log("filter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin")) {
            try {
                isAdmin(username, password);
                resp.sendRedirect("/FIALKA_war/admin.jsp");
                return;
            } catch (InvalidPasswordException e) {
                forward(req, resp, "You entered the wrong password.");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void isAdmin(String username, String password) throws InvalidPasswordException {
        UserDTO userDTO = userService.isAdmin(username);
        if (!userDTO.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, String message)  {
        req.setAttribute("errorMessage", message);
        try {
            req.getRequestDispatcher("/auth.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
