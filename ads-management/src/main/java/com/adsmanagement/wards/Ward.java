package com.adsmanagement.wards;

import com.adsmanagement.districts.District;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wards")
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="district_id")
    private District district;

   public Ward(Integer id){
       this.id = id;
   }

   public WardDTO toDto(){
       return new WardDTO(id,name);
   }
}
