package com.example.useradmin.api;

import java.util.Base64;

public class Aux {

	public static void main(String[] args) {
		String json = "{\n" + "\"id\":10004,\n" + "\"name\":\"ahsoka\",\n" + "\"password\":\"ahsoka\",\n"
				+ "\"email\":\"ahsoka@jedi.com\",\n" + "\"role\":{\n" + "\"id\":5,\n" + "\"name\":\"padawan\"\n" + "}\n"
				+ "}";
		System.out.println(Base64.getEncoder().encodeToString(json.getBytes()));
	}

}
