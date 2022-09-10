package com.springbootnotificationfirebase.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageDTO {
    private String target;
    private String title;
    private String body;
}
