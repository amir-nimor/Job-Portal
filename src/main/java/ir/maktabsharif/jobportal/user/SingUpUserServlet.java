package ir.maktabsharif.jobportal.user;

import ir.maktabsharif.model.User;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "singUp",value = "/singUp")
public class SingUpUserServlet extends HttpServlet {

    private UserServiceImpl userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null){
            resp.sendError(404);
            return;
        }

        Cookie[] cookies = req.getCookies();

        String token = null;

        for (Cookie cookie : cookies){
            if (cookie.getName().equals("token")){
                token = cookie.getValue();
            }
        }

        if (token == null){
            resp.sendError(404);
            return;
        }

        String username = null;
        String password = null;

        try {
            if (token.startsWith("TOKENU->")) {
                String data = token.substring(8); // حذف "TOKEN->"
                String[] parts = data.split("="); // جدا کردن با علامت مساوی

                if (parts.length == 2) {
                    username = parts[0];
                    password = parts[1];
                }
            }
        } catch (RuntimeException e) {
            resp.sendError(404);
            return;
        }

        User user = userService.getUsernameAndPassword(username,password);

        session.setAttribute("rols",user.getRols());
        session.setAttribute("username",user.getUsername());
        session.setAttribute("password",user.getPassword());
        session.setAttribute("phonenumber",user.getPhoneNumber());
        session.setAttribute("city",user.getAddress().getCity());
        session.setAttribute("street",user.getAddress().getStreet());
        session.setAttribute("zipcode",user.getAddress().getZipCode());
        session.setAttribute("resume",user.getResume());
        session.setAttribute("description",user.getDescription());
        session.setAttribute("workMonth",user.getMonthWork());
        session.setAttribute("id",user.getId());




    }
}
