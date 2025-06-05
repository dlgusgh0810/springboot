package com.Lect.week09;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Question {
    private final String title;
    private List<String> options;
    public boolean isChoice(){
        return options != null && !options.isEmpty();
    }
}
