package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {

  private LocalizationService localizationService;
  @BeforeEach
  void setUp(){
    localizationService = new LocalizationServiceImpl();
  }
  @Test
  void localRussian() {
    String expected = "Добро пожаловать";
    String actual = localizationService.locale(Country.RUSSIA);
    Assertions.assertEquals(expected, actual);
  }
  @Test
  void localEnglish(){
    String expected = "Welcome";
    String actual = localizationService.locale(Country.USA);
    Assertions.assertEquals(expected, actual);
  }
}