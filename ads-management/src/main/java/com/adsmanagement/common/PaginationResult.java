package com.adsmanagement.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Setter
@Getter
@AllArgsConstructor
public class PaginationResult<T> {
    private Pageable pagination;
    private  T data;
}
