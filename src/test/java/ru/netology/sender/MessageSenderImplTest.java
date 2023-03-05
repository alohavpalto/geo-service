package ru.netology.sender;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

class MessageSenderImplTest {

  private GeoService geoService;
  private LocalizationService localizationService;
  private MessageSender messageSender;

  @BeforeEach
  void setUp() {
    geoService = Mockito.mock(GeoServiceImpl.class);
    localizationService = Mockito.mock(LocalizationServiceImpl.class);
    messageSender = new MessageSenderImpl(geoService, localizationService);
  }

  @Test
  public void m_RussianText() {
    Mockito.when(geoService.byIp("172.0.32.11"))
        .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
    Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
    Map<String, String> headers = new HashMap<String, String>();
    headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
    String expected = "Добро пожаловать";
    String result = messageSender.send(headers);
    Assertions.assertEquals(expected, result);
  }

  @Test

  public void m_EnglishText() {
    System.out.println();
    Mockito.when(geoService.byIp("96.44.183.149"))
        .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
    Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
    Map<String, String> headers = new HashMap<String, String>();
    headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
    String expected = "Welcome";
    String result = messageSender.send(headers);
    Assertions.assertEquals(expected, result);
  }
}
