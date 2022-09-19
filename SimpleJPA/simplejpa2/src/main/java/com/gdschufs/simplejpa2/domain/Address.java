package com.gdschufs.simplejpa2.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // for embedded
@Getter
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦   ex) Address("a","b","c")
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address()
    {

    }


}
