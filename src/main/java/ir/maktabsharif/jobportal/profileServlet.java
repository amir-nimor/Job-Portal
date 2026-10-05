package ir.maktabsharif.jobportal;

import ir.maktabsharif.model.Company;
import ir.maktabsharif.model.User;
import ir.maktabsharif.service.company.CompanyServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "profile",value = "/profile")
public class profileServlet extends HttpServlet {

    private UserServiceImpl userService;
    private CompanyServiceImpl companyService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userService = (UserServiceImpl) getServletContext().getAttribute("userService");
        this.companyService = (CompanyServiceImpl) getServletContext().getAttribute("companyService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession(false);

        if (session==null){
            resp.sendError(404);
            return;
        }



        String rols = null;

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        for (Cookie c:cookies){
            if (c.getName().equals("token")){
                if (c.getValue().startsWith("TOKENC->")){
                    rols = "company";
                    Company company = companyService.getUsernameAndPassword(username,password);
                    req.setAttribute("company",company);
                } else if (c.getValue().startsWith("TOKENU->")) {
                    rols = "user";
                    User user = userService.getUsernameAndPassword(username,password);
                    req.setAttribute("user",user);
                }

            }
        }

        if (rols == null){
            resp.sendError(404);
            return;
        }

        req.setAttribute("rols",rols);
        req.getRequestDispatcher("./page/profile.jsp").forward(req,resp);
    }


}
