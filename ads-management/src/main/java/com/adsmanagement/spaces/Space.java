package com.adsmanagement.spaces;

import com.adsmanagement.wards.Ward;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

enum SpaceType {
    PUBLIC_LAND,
    PARK,
    TRAFFIC_CORRIDOR,
    PRIVATE_LAND,
    SHOPPING_CENTER,
    MARKET,
    GAS_STATION,
    BUS_SHELTER
}

enum SpaceFormat {
    POLITICAL_MOBILIZATION,
    COMMERCIAL_ADS,
    SOCIALIZATION
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "spaces")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "long")
    private Float longitude;

    @Column(name = "lat")
    private Float lat;

    @Column(name = "type", columnDefinition = "varchar(20)")
    private SpaceType type;

    @Column(name = "format", columnDefinition = "varchar(20)")
    private SpaceFormat format;

    private String imgUrl;

    @Column(name = "is_planned")
    private boolean isPlanned;

    @ManyToOne
    @JoinColumn(name="ward_id")
    private Ward ward;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public Space(Integer spaceId) {
        this.id = spaceId;
    }

    public SpaceDto ToDto(){
        List<String> imgUrls = new ArrayList<>();
        if (this.imgUrl != null) {
            String[] split = this.imgUrl.split(", ");
            imgUrls = Arrays.stream(split).toList();
        }
        return new SpaceDto(id,address,longitude,lat,type,format,imgUrls,isPlanned,ward);
    }
}
