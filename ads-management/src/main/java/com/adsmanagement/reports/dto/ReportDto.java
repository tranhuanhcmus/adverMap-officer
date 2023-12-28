package com.adsmanagement.reports.dto;

import com.adsmanagement.reports.models.ReportState;
import com.adsmanagement.surfaces.dto.SurfaceDto;
import com.adsmanagement.surfaces.models.Surface;
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
public class ReportDto {
    private Integer id;
    private SurfaceDto surface;
    private String address;
    private String userIp;
    private WardDTO ward;
    private Float longitude;
    private Float lat;
    private Date reportDate;
    private String content;
    private String email;
    private String phone;
    private ReportState state;
    private String imgUrl;
    private UserDTO approvedBy;
    private String response;
}
