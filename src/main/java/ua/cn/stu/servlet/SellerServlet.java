package ua.cn.stu.servlet;
import stu.cn.ua.dao.SellerDAO;
import stu.cn.ua.domain.Seller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SellerServlet extends HttpServlet {
    private SellerDAO sellerDAO;
    private final String responseSellerJSP = "seller.jsp";
    @Override
    public void init() throws ServletException {
        sellerDAO = (SellerDAO)getServletContext().getAttribute("sellerDAO");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String actionType = req.getParameter("actiontype");
        if ("addseller".equalsIgnoreCase(actionType))
            addSeller(req, resp);
        else if ("deleteseller".equalsIgnoreCase(actionType))
            deleteSeller(req, resp);
        else if("updateseller".equalsIgnoreCase(actionType))
            updateSeller(req, resp);
    }

    private void addSeller(HttpServletRequest req, HttpServletResponse resp)
    {
        try {
            String sellername = req.getParameter("sellername");
            String selleremail = req.getParameter("selleremail");
            sellerDAO.createEntity(new Seller(sellername, selleremail));
            resp.sendRedirect(responseSellerJSP);
        } catch (IOException e) {
            resp.setStatus(202);
        }
    }

    private void updateSeller(HttpServletRequest req, HttpServletResponse resp)
    {
        String sellername = req.getParameter("sellername");
        String selleremail = req.getParameter("selleremail");
        String sellerIdString = req.getParameter("sellerid");
        try {
            Long sellerId = Long.parseLong(sellerIdString);
            Seller seller = sellerDAO.getEntityById(sellerId);
            seller.setEmail(selleremail);
            seller.setName(sellername);
            sellerDAO.updateEntity(seller);
            resp.sendRedirect(responseSellerJSP);
        } catch (IOException e) {
            resp.setStatus(202);
        }
    }

    private void deleteSeller(HttpServletRequest req, HttpServletResponse resp)
    {
        String sellerIdString = req.getParameter("sellerid");
        try {
            Long sellerId = Long.parseLong(sellerIdString);
            sellerDAO.deleteEntityById(sellerId);
            resp.sendRedirect(responseSellerJSP);
        } catch (Exception e) {
            resp.setStatus(202);
        }
    }
}
