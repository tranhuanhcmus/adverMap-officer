package com.adsmanagement.spaces.dto;

import com.adsmanagement.spaces.models.*;
import com.adsmanagement.users.User;
import com.adsmanagement.wards.Ward;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateSpaceRequestDto {
    private String address;
    private Float longitude;
    private Float lat;
    private Integer spaceId;
    private Integer wardId;
    private String content;
    private SpaceType type;
    private SpaceFormat format;
    public SpaceRequest ToSpaceRequest(User user){
        return new SpaceRequest(0,address,new Date(),user,longitude,lat,new Space(spaceId), new Ward(wardId),content,type,format,null, RequestState.IN_PROGRESS,null,null,null);
    }
}
