package com.example.library.security;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Roles {
	ADMIN("admin"),
	USER("user");

	private final String name;

	@Override
	public String toString() {
		return name;
	}
}
