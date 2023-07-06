package ru.netology.diplom_project.test.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.APIHelper;
import ru.netology.diplom_project.data.DataGenerator;
import ru.netology.diplom_project.data.SQLHelper;
import ru.netology.diplom_project.data.helpers.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class TestAPICredit {
        @BeforeAll
        static void setUpAll() {
            SelenideLogger.addListener("allure", new AllureSelenide());
        }

        @BeforeEach
        public void cleanTable() {
            SQLHelper.cleanDatabase();
        }

        @AfterAll
        static void tearDownAll() {
            SelenideLogger.removeListener("allure");
            await().atMost(16, SECONDS).until(newOrderWasAdded());
        }

        //Отправка POST запроса на кредит с валидно* заполненным body и Карта APPROVED на http://localhost:9999/credit
        //Ожидаемый результат: статус 200, появление соответствующей записей в БД
        @Test
        @DisplayName("APICreditAC № 1 Credit for services with an APPROVED card")
        void creditForServicesWithApprovedCard() {
            int statusCode = APIHelper.getRequestStatusCodeCredit(DataGenerator.generateDataWithApprovedCard());
            assertEquals(200, statusCode);
        }

        //2. Отправка POST запроса на кредит с валидно заполненным body и Карта Declined на http://localhost:9999/credit
        //   Ожидаемый результат: статус 200, появление соответствующей записей в БД
        @Test
        @DisplayName("TestAPICredit№ 2 Credit For Services With DECLINED Card")
        void creditForServicesWithDeclinedCard() {
            int statusCode = APIHelper.getRequestStatusCodeCredit(DataGenerator.generateDataWithDeclineCard());
            assertEquals(200, statusCode);
        }

}
