package ir.maktabsharif.jobportal.lisener;

import ir.maktabsharif.model.Address;
import ir.maktabsharif.model.Company;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.company.CompanyRepositoryImpl;
import ir.maktabsharif.repository.jobPosition.JobPositionRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.service.company.CompanyServiceImpl;
import ir.maktabsharif.service.jobPosition.JobPositionServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.management.relation.Role;

@WebListener
public class Start implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        CompanyRepositoryImpl companyRepository = new CompanyRepositoryImpl();
        JobPositionRepositoryImpl jobPositionRepository = new JobPositionRepositoryImpl();

        UserServiceImpl userService = new UserServiceImpl(userRepository);
        CompanyServiceImpl companyService = new CompanyServiceImpl(companyRepository);
        JobPositionServiceImpl jobPositionService = new JobPositionServiceImpl(jobPositionRepository);


        sce.getServletContext().setAttribute("userService",userService);
        sce.getServletContext().setAttribute("companyService",companyService);
        sce.getServletContext().setAttribute("jobPositionService",jobPositionService);


        // نمونه ۱
        userService.save(new User(
                "امیر محمدی", "09121112233",
                new Address("تهران", "ولیعصر پلاک ۱۰", "1967812345"),
                "برنامه‌نویس ارشد جاوا", 24, "files/resumes/amir_m.pdf"
        ));

        // نمونه ۲
        userService.save(new User(
                "سارا رضایی", "09133334455",
                new Address("اصفهان", "چهارباغ واحد ۴۵", "8145698765"),
                "طراح رابط کاربری", 12, "files/resumes/sara_r.pdf"
        ));

        // نمونه ۳
        userService.save(new User(
                "علی حسینی", "09155556677",
                new Address("مشهد", "سجاد پلاک ۲۲", "9187654321"),
                "متخصص سئو", 8, "files/resumes/ali_h.pdf"
        ));

        // نمونه ۴
        userService.save(new User(
                "مریم علوی", "09177778899",
                new Address("شیراز", "زند ساختمان پارس", "7134567890"),
                "مدیر پروژه", 36, "files/resumes/maryam_a.pdf"
        ));

        // نمونه ۵
        userService.save(new User(
                "رضا تبریزی", "09144445566",
                new Address("تبریز", "امام پلاک ۵", "5136789012"),
                "توسعه‌دهنده فرانت‌اند", 18, "files/resumes/reza_t.pdf"
        ));



        companyService.save(new Company("داده‌پردازان پارس", "تولید نرم‌افزارهای سازمانی",
                new Address("تهران", "خیابان جردن، برج ملت", "19678"), "www.pars-data.ir", "02188881111"));

        companyService.save(new Company("تکنولوژی نوین اصفهان", "هوش مصنوعی و یادگیری ماشین",
                new Address("اصفهان", "شهرک علمی تحقیقاتی", "81456"), "www.novin-tech.ir", "03133332222"));

        companyService.save(new Company("شبکه گستر شرق", "ارائه دهنده خدمات ابری",
                new Address("مشهد", "بلوار وکیل آباد، ساختمان اداری", "91876"), "www.shabakeh-sharq.ir", "05137773333"));

        companyService.save(new Company("فناوران برتر شیراز", "امنیت شبکه و اطلاعات",
                new Address("شیراز", "خیابان ملاصدرا، مجتمع دیجیتال", "71345"), "www.fannavaran.ir", "07136664444"));

        companyService.save(new Company("تجارت الکترونیک تبریز", "سامانه‌های فروشگاهی",
                new Address("تبریز", "ولیعصر، مجتمع اداری", "51367"), "www.tabriz-ecommerce.ir", "04135555555"));

    }
}

