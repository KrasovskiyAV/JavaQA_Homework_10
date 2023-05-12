package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldIncreaseVolumeIfCurrent0() {
        radio.increaseVolume();

        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeIfMiddle() {
        radio.setCurrentVolume(50);

        radio.increaseVolume();

        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeIfCurrent99() {
        radio.setCurrentVolume(99);

        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeIfAboveMax() {
        radio.setCurrentVolume(radio.getMaxVolume());

        radio.increaseVolume();

        assertEquals(radio.getMaxVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeIfBelowMin() {
        radio.decreaseVolume();

        assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolumeIfCurrent1() {
        radio.setCurrentVolume(1);

        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolumeIfMiddle() {
        radio.setCurrentVolume(50);

        radio.decreaseVolume();

        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolumeIfCurrentMax() {
        radio.setCurrentVolume(radio.getMaxVolume());

        radio.decreaseVolume();

        assertEquals(radio.getMaxVolume() - 1, radio.getCurrentVolume());
    }

    @Test
    public void shouldSwitchNextStationIfCurrent0() {
        radio.nextStation();

        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchNextStationIfMiddle() {
        radio.setCurrentStation(radio.getQuantity() / 2);

        radio.nextStation();

        assertEquals(radio.getQuantity() / 2 + 1, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchStationToMinIfAboveMax() {
        radio.setCurrentStation(radio.getMaxStation());

        radio.nextStation();

        assertEquals(radio.getMinStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchNextStationIfCurrentPreviousFromMax() {
        radio.setCurrentStation(radio.getMaxStation() - 1);

        radio.nextStation();

        assertEquals(radio.getMaxStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchStationToMaxIfBelowMin() {
        radio.setCurrentStation(radio.getMinStation());

        radio.prevStation();

        assertEquals(radio.getMaxStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchPrevStationIfMiddle() {
        radio.setCurrentStation(radio.getQuantity() / 2);

        radio.prevStation();

        assertEquals(radio.getQuantity() / 2 - 1, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchPrevStationIfCurrentMax() {
        radio.setCurrentStation(radio.getMaxStation());

        radio.prevStation();

        assertEquals(radio.getMaxStation() - 1, radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationBetweenEnds() {
        radio.setCurrentStation(radio.getQuantity() / 2);

        assertEquals(radio.getQuantity() / 2, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationIfAboveMax() {
        radio.setCurrentStation(radio.getMaxStation() + 1);

        assertEquals(radio.getMinStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationIfBelowZero() {
        radio.setCurrentStation(-1);

        assertEquals(radio.getMinStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetVolumeAboveMax() {
        radio.setCurrentVolume(radio.getMaxVolume() + 1);

        assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowZero() {
        radio.setCurrentVolume(-1);

        assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetStationIfAboveMaxWithRangeSelection() {
        Radio radio = new Radio(15);

        radio.setCurrentStation(radio.getMaxStation() + 1);

        assertEquals(radio.getMinStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationBetweenEndsWithRangeSelection() {
        Radio radio = new Radio(11);

        radio.setCurrentStation(radio.getQuantity() / 2);

        assertEquals(radio.getQuantity() / 2, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchPrevStationIfCurrentMaxWithRangeSelection() {
        Radio radio = new Radio(20);

        radio.setCurrentStation(radio.getMaxStation());

        radio.prevStation();

        assertEquals(radio.getMaxStation() - 1, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchStationToMaxIfBelowMinWithRangeSelection() {
        Radio radio = new Radio(37);

        radio.setCurrentStation(radio.getMinStation());

        radio.prevStation();

        assertEquals(radio.getMaxStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchStationToMinIfAboveMaxWithRangeSelection() {
        Radio radio = new Radio(7);

        radio.setCurrentStation(radio.getMaxStation());

        radio.nextStation();

        assertEquals(radio.getMinStation(), radio.getCurrentStation());
    }
}