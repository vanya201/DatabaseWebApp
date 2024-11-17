package stu.cn.ua.domain;
import javax.persistence.*;


@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_description", length = 255)
    private String description;

    @Column(name = "product_name", length = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id")
    private Seller seller;

    public Product() {}

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product(String description, String name, Seller seller) {
        this.description = description;
        this.name = name;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}

