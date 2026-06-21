package com.qlrapphim.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "GHE", schema = "QL_RAP_PHIM",
        uniqueConstraints = @UniqueConstraint(name = "UK_GHE_PHONG", columnNames = {"MA_PHONG", "HANG_GHE", "SO_GHE"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ghe {

    @Id
    @Column(name = "MA_GHE", length = 10)
    private String maGhe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MA_PHONG", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PhongChieu phongChieu;

    @Column(name = "HANG_GHE", nullable = false, length = 5)
    private String hangGhe;

    @Column(name = "SO_GHE", nullable = false)
    private Integer soGhe;

    @Column(name = "LOAI_GHE", columnDefinition = "NVARCHAR2(30)")
    private String loaiGhe = "Thường";

    @Column(name = "TRANG_THAI", columnDefinition = "NVARCHAR2(30)")
    private String trangThai = "Hoạt động";

    @OneToMany(mappedBy = "ghe", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Ve> ves;
}
