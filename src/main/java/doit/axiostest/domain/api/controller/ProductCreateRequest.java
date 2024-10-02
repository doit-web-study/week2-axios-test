package doit.axiostest.domain.api.controller;

public record ProductCreateRequest (
        String name,
        String content,
        int price
){
}
