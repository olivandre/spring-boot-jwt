package com.javainuse.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 8225334744231345997L;
    
    private final String jwttoken;
    
    public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
    
    public String getToken() {
		return this.jwttoken;
	}

}