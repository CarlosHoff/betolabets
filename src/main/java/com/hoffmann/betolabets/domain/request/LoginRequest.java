package com.hoffmann.betolabets.domain.request;

import java.io.Serializable;

public record LoginRequest(String username, String password) implements Serializable {
}
