package doit.axiostest.domain.api.controller;

public record ProductCreateRequest (
        String title,
        String content,
        int price
){
}
