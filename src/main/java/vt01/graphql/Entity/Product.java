package vt01.graphql.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products") // Sử dụng chữ thường nhất quán cho tên bảng
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Đảm bảo không null
    private String title;

    @Column(nullable = false) // Đảm bảo không null
    private int quantity;

    @Column(name = "description", length = 1000) // Đổi tên trường "desc" do "desc" là từ khóa SQL
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Thêm FetchType và optional để kiểm soát tải và ràng buộc
    @JoinColumn(name = "user_id", nullable = false) // Đảm bảo không null
    private User user;
}
