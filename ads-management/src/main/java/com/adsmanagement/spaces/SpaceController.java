package com.adsmanagement.spaces;


import com.adsmanagement.common.Response;
import com.adsmanagement.config.UserInfoUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/spaces")
public class SpaceController {
    private final SpaceService spaceService;

    @Autowired
    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @GetMapping(path = "")
    public ResponseEntity<Response<Page<SpaceDto>>> list(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam(required = false) Integer cityId,
            @RequestParam(required = false) List<Integer> wardIds,
            @RequestParam(required = false) List<Integer> districtIds
            )   {
        var data = this.spaceService.findAll(page,size,cityId,wardIds, districtIds);

        var contents = new ArrayList<SpaceDto>();
        for (int i = 0; i < data.getContent().size(); i++){
            contents.add(data.getContent().get(i).ToDto());
        }

        Page<SpaceDto> dataRes = new PageImpl<>(contents,data.getPageable(),data.getTotalElements());
        var res = new Response<>("",dataRes);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<Response<SpaceDto>> create(
           @RequestBody CreateSpaceDto createSpaceDto
    )   {
        var data = this.spaceService.create(createSpaceDto);
        var res = new Response<>("",data.ToDto());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping(path = "/{id}/request")
    public ResponseEntity<Response<SpaceRequestDto>> createRequest(
            @PathVariable("id") int spaceId,
            @RequestBody CreateSpaceRequestDto createSpaceRequestDto,
            @AuthenticationPrincipal UserInfoUserDetails userDetails
    )   {
        createSpaceRequestDto.setSpaceId(spaceId);
        var user = userDetails.getUser();
        var data = this.spaceService.createRequest(createSpaceRequestDto, user);
        var res = new Response<>("",data.ToDto());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(path = "/request")
    public ResponseEntity<Response<Page<SpaceRequestDto>>> listRequest(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam(required = false) Integer cityId,
            @RequestParam(required = false) List<Integer> wardIds,
            @RequestParam(required = false) List<Integer> districtIds,
            @AuthenticationPrincipal UserInfoUserDetails userDetails
    )   {
        var user = userDetails.getUser();
        var data = this.spaceService.findAllRequest(page, size, cityId, wardIds, districtIds);

        var contents = new ArrayList<SpaceRequestDto>();
        for (int i = 0; i < data.getContent().size(); i++){
            contents.add(data.getContent().get(i).ToDto());
        }

        Page<SpaceRequestDto> dataRes = new PageImpl<>(contents,data.getPageable(),data.getTotalElements());
        var res = new Response<>("",dataRes);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
