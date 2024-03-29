package com.javainuse.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8225334744231345997L;
    
    private String jwtToken;

}