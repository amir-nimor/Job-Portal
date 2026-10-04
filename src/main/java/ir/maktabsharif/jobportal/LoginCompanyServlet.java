package ir.maktabsharif.jobportal;

import ir.maktabsharif.model.Address;
import ir.maktabsharif.model.Company;
import ir.maktabsharif.service.company.CompanyServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "CompanyLoginServlet",value = "/CompanyLoginServlet")
public class LoginCompanyServlet extends HttpServlet {

    private CompanyServiceImpl companyService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.companyService = (CompanyServiceImpl) getServletContext().getAttribute("companyService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./page/LoginCompany.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String zipcode = req.getParameter("zipcode");
        String site = req.getParameter("site");
        String phoneNumber = req.getParameter("phoneNumber");

        session.setAttribute("name",name);
        session.setAttribute("description",description);
        session.setAttribute("city",city);
        session.setAttribute("street",street);
        session.setAttribute("zipcode",zipcode);
        session.setAttribute("site",site);
        session.setAttribute("phoneNumber",phoneNumber);

        Company company = new Company(name,description,new Address(city,street,zipcode),site,phoneNumber);

        Integer id = companyService.save(company).getId();

        session.setAttribute("id",id);


    }
}
