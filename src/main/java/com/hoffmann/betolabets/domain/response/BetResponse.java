package com.hoffmann.betolabets.domain.response;

import com.hoffmann.betolabets.domain.dto.BetsDto;
import com.hoffmann.betolabets.domain.dto.UserDto;

import java.util.List;

public record BetResponse(Long userDto, List<BetsDto> betsDtoList) {
}
