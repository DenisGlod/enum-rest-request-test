package org.example.enumrestrequesttest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MyEnum {
    A("a"),
    B("b"),
    C("c");

    private final String value;
}
