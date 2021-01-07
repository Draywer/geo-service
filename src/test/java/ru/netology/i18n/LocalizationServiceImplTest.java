package ru.netology.i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationServiceImpl localizationService;

    @BeforeAll
    public static void globalSetUp() {
        System.out.println("Тестирование класса LocalizationServiceImpl...");
    }


    @BeforeEach
    void setUp() {
        localizationService = spy(LocalizationServiceImpl.class);
    }


    @Test
    void locale_rus() {
        assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
    }

    @Test
    void locale_eng() {
        assertEquals("Welcome", localizationService.locale(Country.USA));
    }
}