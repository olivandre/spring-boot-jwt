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
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable {
	
    /**
	 *
	 */
	private static final long serialVersionUID = 4595059259716025093L;

	private String username;
	private String password;

}