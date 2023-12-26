package com.adsmanagement.surfaces.dto;

import com.adsmanagement.spaces.models.Space;
import com.adsmanagement.surfaces.models.Surface;
import com.adsmanagement.surfaces.models.SurfaceFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSurfaceDto {
    private SurfaceFormat format;
    private Integer width;
    private Integer height;
    private String imgUrl;
    private String content;
    private Integer spaceId;
    public Surface toSurface(){

        Space space = null;
        if (spaceId != null) {
            space = new Space(spaceId);
        }

        return new Surface(0,format,width, height,imgUrl,content,space,null,null);
    }
}
