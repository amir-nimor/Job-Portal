package ir.maktabsharif.jobportal.user;

import ir.maktabsharif.model.Address;
import ir.maktabsharif.model.Enums.Rols;
import ir.maktabsharif.model.User;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LoginUser",value = "/LoginUser")
public class LoginUsersServlet extends HttpServlet {

    private UserServiceImpl userService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./page/LoginUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String username =  req.getParameter("username");
        String password =  req.getParameter("password");
        String fullname =  req.getParameter("fullname");
        String phonenumber =  req.getParameter("phonenumber");
        String city =  req.getParameter("city");
        String street =  req.getParameter("street");
        String zipcode =  req.getParameter("zipcode");
        String resume =  req.getParameter("resume");
        String description =  req.getParameter("description");
        Integer workMonth =Integer.parseInt(req.getParameter("workMonth"));


        Rols rols = Rols.USER;
        if ("admin".equals(username)&&"admin".equals(password)){
            rols = Rols.ADMIN;
        }

        session.setAttribute("rols",rols);
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("phonenumber",phonenumber);
        session.setAttribute("city",city);
        session.setAttribute("street",street);
        session.setAttribute("zipcode",zipcode);
        session.setAttribute("resume",resume);
        session.setAttribute("description",description);
        session.setAttribute("workMonth",workMonth);


        User user = new User(fullname,phonenumber,new Address(city,street,zipcode),description,workMonth,resume);
        user.setRols(rols);
        user.setUsername(username);
        user.setPassword(password);

        String token = generateToken(username,password);

        Cookie cookie = new Cookie("token",token);
        resp.addCookie(cookie);
        session.setAttribute("token",token);


        Integer id = userService.save(user).getId();

        session.setAttribute("id",id);




    }


    private String generateToken(String username,String password){
        return "TOKENU->"+username+"="+password;
    }
}
