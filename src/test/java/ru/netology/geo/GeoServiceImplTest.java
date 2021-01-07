package ru.netology.geo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    GeoServiceImpl geoService;

    @BeforeAll
    public static void globalSetUp() {
        System.out.println("Тестирование класса GeoServiceImpl...");
    }

    @BeforeEach
    void setup() {
        geoService = spy(GeoServiceImpl.class);
    }

    @Test
    void test_geoservice_byIp_rus() {
        assertEquals(Country.RUSSIA, geoService.byIp(GeoServiceImpl.MOSCOW_IP).getCountry());
    }

    @Test
    void test_geoservice_byIp_eng() {
        assertEquals(Country.USA, geoService.byIp(GeoServiceImpl.NEW_YORK_IP).getCountry());
    }
    @Test
    void test_geoservice_byIp_empty() {
        assertNull(geoService.byIp(GeoServiceImpl.LOCALHOST).getCountry());
    }
}