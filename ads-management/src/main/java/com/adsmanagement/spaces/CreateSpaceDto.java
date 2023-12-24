package com.adsmanagement.spaces;

import com.adsmanagement.wards.Ward;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateSpaceDto {
    private String address;
    private Float longitude;
    private Float lat;
    private SpaceType type;
    private SpaceFormat format;
    private List<String> imgUrl;
    private boolean isPlanned;
    private Integer wardId;

    public Space ToSpace(){
        String imgUrls = String.join(", ", imgUrl);
        return new Space(0,address,longitude,lat,type,format,imgUrls,isPlanned,new Ward(wardId),null,null);
    }
}
