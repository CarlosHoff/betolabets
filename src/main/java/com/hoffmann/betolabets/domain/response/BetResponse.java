package com.hoffmann.betolabets.domain.response;

import com.hoffmann.betolabets.domain.dto.UserDto;

public record BetResponse(Long apostaID, Long dezenaUm, Long dezenaDois, Long dezenaTres, Long dezenaQuatro,
                          Long dezenaCinco, Long dezenaSeis, Long dezenaSete, Long dezenaOito, Long dezenaNove,
                          Long dezenaDez, UserDto userDto) {
}
