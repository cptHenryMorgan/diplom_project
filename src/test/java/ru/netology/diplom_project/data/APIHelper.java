package ru.netology.diplom_project.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class APIHelper {
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")//установить базовый Uri
            .setPort(9999)//установить порт
            .setAccept(ContentType.JSON)//установить Принять
            .setContentType(ContentType.JSON)//установить тип контента
            .log(LogDetail.ALL)//журнал(Детали журнала.ВСЕ)
            .build();//собрать
}
