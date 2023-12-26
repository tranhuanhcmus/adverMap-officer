package com.adsmanagement.surfaces.dto;

import com.adsmanagement.spaces.dto.SpaceDto;
import com.adsmanagement.spaces.dto.SpaceRequestDto;
import com.adsmanagement.spaces.models.RequestState;
import com.adsmanagement.spaces.models.Space;
import com.adsmanagement.spaces.models.SpaceFormat;
import com.adsmanagement.spaces.models.SpaceType;
import com.adsmanagement.users.User;
import com.adsmanagement.users.dto.UserDTO;
import com.adsmanagement.wards.Ward;
import com.adsmanagement.wards.WardDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SurfaceRequestDto {
    private Integer id;
    private Date reportDate;
    private UserDTO user;
    private SurfaceDto surface;
    private SpaceDto space;
    private String content;
    private UserDTO approvedBy;
    private RequestState state;
    private String response;
}
