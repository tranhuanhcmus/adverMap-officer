package com.adsmanagement.reports.dto;

import com.adsmanagement.reports.models.Report;
import com.adsmanagement.reports.models.ReportState;
import com.adsmanagement.surfaces.dto.SurfaceDto;
import com.adsmanagement.surfaces.models.Surface;
import com.adsmanagement.users.dto.UserDTO;
import com.adsmanagement.wards.Ward;
import com.adsmanagement.wards.WardDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateReportDto {
    private Integer surface_id;
    private String address;
    private String userIp;
    private Integer ward_id;
    private Float longitude;
    private Float lat;
    private String content;
    private String email;
    private String phone;
    private String imgUrl;

    public Report toReport(){
        return new Report(0, new Surface(surface_id),address,userIp,new Ward(ward_id),longitude,lat,new Date(),content,email,phone,ReportState.IN_PROGRESS,imgUrl,null,null, new Date(), new Date());
    }
}
