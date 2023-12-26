package com.adsmanagement.surfaces.models;

import com.adsmanagement.spaces.models.Space;
import com.adsmanagement.spaces.dto.SpaceDto;
import com.adsmanagement.surfaces.dto.SurfaceDto;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "surfaces")
public class Surface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "format", columnDefinition = "varchar(20)")
    private SurfaceFormat format;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name="space_id")
    private Space space;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public Surface(Integer id ){
        this.id = id;
    }
    public SurfaceDto toDto(){
        SpaceDto spaceDto = null;
        if (space != null){
            spaceDto = space.ToDto();
        }
        return new SurfaceDto(id,format,width,height,imgUrl,content,spaceDto);
    }

}
