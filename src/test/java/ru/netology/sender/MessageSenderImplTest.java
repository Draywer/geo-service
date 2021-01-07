package ru.netology.sender;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.w3c.dom.ls.LSOutput;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {
    @BeforeAll
    public static void globalSetUp() {
        System.out.println("Тестирование класса MessageSenderImpl...");
    }
    @Test
    void test_send_russian_message() {
        GeoService geoService = spy(GeoServiceImpl.class);
        LocalizationServiceImpl localizationService = spy(LocalizationServiceImpl.class);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");

        assertEquals("Добро пожаловать", messageSender.send(headers));
        System.out.println();

        verify(geoService, times(1)).byIp("172.");

    }

    @Test
    void test_send_english_message() {
        GeoService geoService = spy(GeoServiceImpl.class);
        LocalizationServiceImpl localizationService = spy(LocalizationServiceImpl.class);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");

        assertEquals("Welcome", messageSender.send(headers));
        System.out.println();

        verify(geoService, times(1)).byIp("96.");

    }
}