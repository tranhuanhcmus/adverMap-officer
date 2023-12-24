package com.adsmanagement.spaces;

import com.adsmanagement.users.User;
import com.adsmanagement.wards.Ward;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpaceRequestDto {
    private Integer id;
    private String address;
    private Date reportDate;
    private User user;
    private Float longitude;
    private Float lat;
    private Space space;
    private Ward ward;
    private String content;
    private SpaceType type;
    private SpaceFormat format;
    private User approvedBy;
    private RequestState state;
    private String response;
}
