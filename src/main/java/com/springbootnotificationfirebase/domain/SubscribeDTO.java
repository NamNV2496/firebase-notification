package com.springbootnotificationfirebase.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SubscribeDTO {
    String topicName;
    List<String> tokens;
}
