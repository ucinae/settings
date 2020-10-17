package com.ucinae.settings.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("person")
public class Person implements Serializable {
    @Id
    private String id;
    private String name;
    private Date birthday;
    private Integer age;
    private String email;
    private Address address;
    private List<String> nicknames;
    private Map<String, String> attributes;
    private List<Address> addresses;
    private Map<String, Address> addressMap;
}
