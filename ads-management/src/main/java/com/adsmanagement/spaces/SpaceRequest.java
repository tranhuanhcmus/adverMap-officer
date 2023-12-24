package com.adsmanagement.spaces;

import com.adsmanagement.users.User;
import com.adsmanagement.wards.Ward;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

enum RequestState {
    IN_PROGRESS,
    REJECTED,
    APPROVED,
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "space_requests")
public class SpaceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "report_date")
    private Date reportDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "long")
    private Float longitude;

    @Column(name = "lat")
    private Float lat;

    @ManyToOne
    @JoinColumn(name="space_id")
    private Space space;

    @ManyToOne
    @JoinColumn(name="ward_id")
    private Ward ward;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private SpaceType type;

    @Column(name = "format")
    private SpaceFormat format;

    @ManyToOne
    @JoinColumn(name="approved_id")
    private User approvedBy;

    @Column(name = "state")
    private RequestState state;

    @Column(name = "response")
    private String response;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    SpaceRequestDto ToDto(){
        return new SpaceRequestDto(id,address,reportDate,user,longitude,lat,space,ward,content,type,format,approvedBy,state,response);
    }
}
