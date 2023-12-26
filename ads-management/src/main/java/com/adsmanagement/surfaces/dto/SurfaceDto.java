package com.adsmanagement.surfaces.dto;

import com.adsmanagement.spaces.dto.SpaceDto;
import com.adsmanagement.surfaces.models.SurfaceFormat;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SurfaceDto {
    private Integer id;
    private SurfaceFormat format;
    private Integer width;
    private Integer height;
    private String imgUrl;
    private String content;
    private SpaceDto space;
}
