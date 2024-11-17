package ua.cn.stu.servlet;
import stu.cn.ua.dao.ProductDAO;
import stu.cn.ua.dao.SellerDAO;
import stu.cn.ua.domain.Product;
import stu.cn.ua.domain.Seller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;
    private SellerDAO sellerDAO;
    private final String responseProductJSP = "product.jsp";
    @Override
    public void init() throws ServletException {
        productDAO = (ProductDAO)getServletContext().getAttribute("productDAO");
        sellerDAO = (SellerDAO)getServletContext().getAttribute("sellerDAO");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String actionType = req.getParameter("actiontype");
        if ("addproduct".equalsIgnoreCase(actionType))
            addProduct(req, resp);
        else if ("deleteproduct".equalsIgnoreCase(actionType))
            deleteProduct(req, resp);
        else if("updateproduct".equalsIgnoreCase(actionType))
            updateProduct(req, resp);
    }
protected void addProduct(HttpServletRequest req, HttpServletResponse resp) {
    String productDescription = req.getParameter("productdescription");
    String productName = req.getParameter("productname");
    String sellerIdString = req.getParameter("sellerId");
    try {
        Product product = createProduct(productName, productDescription, sellerIdString);
        productDAO.createEntity(product);
        resp.sendRedirect(responseProductJSP);
    } catch (NumberFormatException e) {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    } catch (Exception e) {
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}

private Product createProduct(String productName, String productDescription, String sellerIdString) throws NumberFormatException {
    Seller seller = null;
    if (sellerIdString != null) {
        Long sellerId = Long.parseLong(sellerIdString);
        seller = sellerDAO.getEntityById(sellerId);
    }
    return new Product(productName, productDescription, seller);
}

    protected void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
        String productDescription = req.getParameter("productdescription");
        String productName = req.getParameter("productname");
        String productIdString = req.getParameter("productid");
        String sellerIdString = req.getParameter("sellerId");

        try {
            Long productId = Long.parseLong(productIdString);
            Long sellerId = sellerIdString.isEmpty() ? null : Long.parseLong(sellerIdString);
            Seller seller = sellerDAO.getEntityById(sellerId);
            Product product = productDAO.getEntityById(productId);
            product.setName(productName);
            product.setDescription(productDescription);
            product.setSeller(seller);
            productDAO.updateEntity(product);
            resp.sendRedirect(responseProductJSP);
        } catch (Exception e) {
            resp.setStatus(202);
        }
    }

    protected void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        String productIdString = req.getParameter("productid");
        try {
            Long productId = Long.parseLong(productIdString);
            productDAO.deleteEntityById(productId);
            resp.sendRedirect(responseProductJSP);
        } catch (Exception e) {
            resp.setStatus(202);
        }
    }
}