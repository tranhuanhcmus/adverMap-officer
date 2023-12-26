//package com.adsmanagement.reports;
//
//import com.adsmanagement.spaces.*;
//import com.adsmanagement.users.User;
//import com.adsmanagement.users.dto.UserDTO;
//import com.adsmanagement.wards.Ward;
//import com.adsmanagement.wards.WardDTO;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.Date;
//
//enum ReportState {
//    IN_PROGRESS,
//    REJECTED,
//    APPROVED,
//}
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Table(name = "reports")
//public class Report {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name="surface_id")
//    private Surface user;
//
//    @Column(name = "long")
//    private Float longitude;
//
//    @Column(name = "lat")
//    private Float lat;
//
//    @ManyToOne
//    @JoinColumn(name="space_id")
//    private Space space;
//
//    @ManyToOne
//    @JoinColumn(name="ward_id")
//    private Ward ward;
//
//    @Column(name = "content")
//    private String content;
//
//    @Column(name = "type")
//    private SpaceType type;
//
//    @Column(name = "format")
//    private SpaceFormat format;
//
//    @ManyToOne
//    @JoinColumn(name="approved_id")
//    private User approvedBy;
//
//    @Column(name = "state")
//    private RequestState state;
//
//    @Column(name = "response")
//    private String response;
//
//    @Column(name = "created_at")
//    private Date createdAt;
//
//    @Column(name = "updated_at")
//    private Date updatedAt;
//
//    SpaceRequestDto ToDto(){
//        UserDTO userDto = null;
//        if (user != null) {
//            userDto = user.toDTO();
//        }
//
//        UserDTO approvedByDto = null;
//        if (approvedBy != null) {
//            approvedByDto = approvedBy.toDTO();
//        }
//
//        SpaceDto spaceDto = null;
//        if (space != null){
//            spaceDto = space.ToDto();
//        }
//
//        WardDTO wardDto = null;
//        if (ward != null){
//            wardDto = ward.toDto();
//        }
//
//        return new SpaceRequestDto(id,address,reportDate,userDto,longitude,lat,spaceDto,wardDto,content,type,format,approvedByDto,state,response);
//    }
//}
