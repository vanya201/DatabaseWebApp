package stu.cn.ua.dao;
import stu.cn.ua.domain.Product;

public class ProductDAO extends AllObjectsDAO<Product> {
    public ProductDAO() {
        super(Product.class);
    }
}
