package com.qlrapphim.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "THANH_TOAN", schema = "QL_RAP_PHIM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThanhToan {

    @Id
    @Column(name = "MA_TT", length = 10)
    private String maTt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MA_DAT", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private DatVe datVe;

    @Column(name = "SO_TIEN", nullable = false, precision = 12, scale = 2)
    private BigDecimal soTien;

    @Column(name = "NGAY_TT")
    private LocalDateTime ngayTt;

    // Phuong thuc: 'Ví điện tử', 'Tiền mặt', 'Thẻ ngân hàng', 'Chuyển khoản'
    @Column(name = "PHUONG_THUC", columnDefinition = "NVARCHAR2(50)")
    private String phuongThuc;

    @Column(name = "TRANG_THAI", columnDefinition = "NVARCHAR2(30)")
    private String trangThai = "Thành công";

    @PrePersist
    protected void onCreate() {
        if (ngayTt == null) {
            ngayTt = LocalDateTime.now();
        }
    }
}
