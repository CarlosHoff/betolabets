package com.hoffmann.betolabets.domain.request;

import java.io.Serializable;
import java.util.List;

public record BetRequest(List<List<Long>> numeros) implements Serializable {
}
