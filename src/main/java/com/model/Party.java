package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Party {
    private final UUID Id;
    private final String name;
    private final String signImageUrl;
}
