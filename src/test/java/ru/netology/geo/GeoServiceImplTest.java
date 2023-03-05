package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class GeoServiceImplTest {
  private GeoService geoService;
  @BeforeEach
  void setUp(){
    geoService = new GeoServiceImpl();
  }
  @Test
  void m_RussianLocal() {
    Assertions.assertEquals(Country.RUSSIA, geoService.byIp("172.").getCountry());
  }
  @Test
  void m_EnglishLocal() {
    Assertions.assertEquals(Country.USA, geoService.byIp("96.").getCountry());
  }
}