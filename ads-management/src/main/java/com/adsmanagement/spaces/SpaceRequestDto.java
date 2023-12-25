package com.adsmanagement.spaces;

import com.adsmanagement.users.User;
import com.adsmanagement.users.UserDTO;
import com.adsmanagement.wards.Ward;
import com.adsmanagement.wards.WardDTO;
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
    private UserDTO user;
    private Float longitude;
    private Float lat;
    private SpaceDto space;
    private WardDTO ward;
    private String content;
    private SpaceType type;
    private SpaceFormat format;
    private UserDTO approvedBy;
    private RequestState state;
    private String response;
}
