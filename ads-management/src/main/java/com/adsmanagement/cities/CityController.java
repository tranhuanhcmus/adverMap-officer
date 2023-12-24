package com.adsmanagement.cities;


import com.adsmanagement.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/cities")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(path = "")
    public ResponseEntity<Response<Iterable<City>>> list(@RequestParam int page , @RequestParam int size) {
        var data = this.cityService.findAll();
        var res = new Response<>("",data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
