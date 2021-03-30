package africa.semicolon.mp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static africa.semicolon.mp3.MusicState.*;
import static org.junit.jupiter.api.Assertions.*;

public class Mp3Test {
    Mp3Player myMp3Player;

    @BeforeEach
     void startWithThis() {
        myMp3Player = new Mp3Player();
    }
    @Test
    void mp3player_canBeCreated(){
//        Mp3Player myMp3Player = new Mp3Player();
        assertNotNull(myMp3Player);

    }


    @Test
    void mp3Player_turnsOn_whenFlipPowerButtonIsPressed_onOffState(){
//        Mp3Player myMp3Player = new Mp3Player();
        boolean isOff = !myMp3Player.isOn();
        assertTrue(isOff);

        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());
    }
    @Test
    void mp3Player_turnsOn_whenFlipPowerButtonIsPressed_onOnState(){
//        Mp3Player myMp3Player = new Mp3Player();
        myMp3Player.flipPowerButton();
        boolean isOn = myMp3Player.isOn();
        assertTrue(isOn);

        myMp3Player.flipPowerButton();
        assertFalse(myMp3Player.isOn());
    }

    @Test
    void mp3Player_canDownloadMusic(){
//        Mp3Player myMp3Player = new Mp3Player();
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music music = new Music();
        assertNotNull(music);

        myMp3Player.download(music);
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        Music secondMusic = new Music();
        myMp3Player.download(secondMusic);
        assertEquals(2, myMp3Player.getTotalNumberMusic());

    }

    @Test
    void mp3Player_cannotDownloadMusic_whenMp3PlayerIsOff() {
//        Mp3Player myMp3Player = new Mp3Player();
        assertFalse(myMp3Player.isOn());

        Music music = new Music();
        assertNotNull(music);

        myMp3Player.download(music);
        assertEquals(0, myMp3Player.getTotalNumberMusic());

        Music secondMusic = new Music();
        myMp3Player.download(secondMusic);
        assertEquals(0, myMp3Player.getTotalNumberMusic());

    }
        @Test
        void mp3Player_canDeleteDownloadedMusic(){
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music music = new Music();
        Music secondMusic = new Music();
        myMp3Player.download(music);
        myMp3Player.download(secondMusic);
        assertEquals(2, myMp3Player.getTotalNumberMusic());

        myMp3Player.delete(music);
        assertEquals(2, myMp3Player.getTotalNumberMusic());
        }

    @Test
    void mp3Player_cantDelete_whenMusicIsEmpty(){
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music music = new Music();
        Music secondMusic = new Music();
        myMp3Player.download(music);
        myMp3Player.download(secondMusic);
        assertEquals(2, myMp3Player.getTotalNumberMusic());


    }

    @Test
    void mp3Player_cannotDownloadTheSameSongTwice(){
        myMp3Player.flipPowerButton();
        Music music = new Music();
        myMp3Player.download(music);
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        myMp3Player.download(music);
        assertEquals(1, myMp3Player.getTotalNumberMusic());


    }

    @Test
    void mp3Player_canPlayMusic(){
        myMp3Player.flipPowerButton();
        Music ajibole = new Music();
        myMp3Player.download(ajibole);
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        myMp3Player.play(ajibole);

        assertEquals(PLAYING, myMp3Player.getMusicState());
        assertEquals(ajibole, myMp3Player.getCurrentlyPlayingMusic());
    }

    @Test
    void mp3Player_cannotPlayMusic_whenMp3PlayerIsOff(){
        assertFalse(myMp3Player.isOn());
        Music shoki = new Music();
        assertNotNull(shoki);


    }

    @Test
    void mp3Player_canPauseMusic(){
        myMp3Player.flipPowerButton();
        Music ajibole = new Music();
        myMp3Player.download(ajibole);
        assertEquals(1, myMp3Player.getTotalNumberMusic());
        myMp3Player.play(ajibole);
        myMp3Player.pauseMusic();

        assertEquals(PAUSED, myMp3Player.getMusicState());
        assertEquals(ajibole, myMp3Player.getCurrentlyPlayingMusic());
    }

    @Test
    void mp3Player_canStopMusic(){
        myMp3Player.flipPowerButton();
        Music ajibole = new Music();
        myMp3Player.download(ajibole);
        assertEquals(1, myMp3Player.getTotalNumberMusic());
        myMp3Player.play(ajibole);
        myMp3Player.stopMusic();

        assertEquals(STOPPED, myMp3Player.getMusicState());


    }

    @Test
    void mp3Player_canPlayAndPauseMusic_whenMp3PlayerIsOn(){
        myMp3Player.flipPowerButton();
        Music ajibole = new Music();
        myMp3Player.download(ajibole);
        assertEquals(1, myMp3Player.getTotalNumberMusic());
        myMp3Player.play(ajibole);
        assertEquals(PLAYING, myMp3Player.getMusicState());
        myMp3Player.flipPlayAndPauseButton();
        assertEquals(PAUSED, myMp3Player.getMusicState());
    }

    @Test
    void mp3Player_cannotPlayAndPauseMusic_WhenMp3PlayerIsOff(){
        assertFalse(myMp3Player.isOn());
        Music ajibole = new Music();
        myMp3Player.download(ajibole);
        assertEquals(0, myMp3Player.getTotalNumberMusic());
        myMp3Player.play(ajibole);
        assertEquals(STOPPED, myMp3Player.getMusicState());
        myMp3Player.flipPlayAndPauseButton();
        assertEquals(STOPPED, myMp3Player.getMusicState());
    }

    @Test
    void mp3Player_canIncreaseVolume(){
        myMp3Player.flipPowerButton();
        Music peaceOfMind = new Music();
        myMp3Player.download(peaceOfMind);
        myMp3Player.play(peaceOfMind);

        myMp3Player.increaseVolume();
        assertEquals(21, myMp3Player.getVolume());
    }

    @Test
    void mp3Player_canReduceVolume(){
        myMp3Player.flipPowerButton();
        Music peaceOfMind = new Music();
        myMp3Player.download(peaceOfMind);
        myMp3Player.play(peaceOfMind);

        myMp3Player.decreaseVolume();
        assertEquals(19, myMp3Player.getVolume());
    }

    @Test
    void mp3Player_cannotIncreaseVolume_whenMp3PlayerIsOff(){
        assertFalse(myMp3Player.isOn());
        Music peaceOfMind = new Music();
        myMp3Player.download(peaceOfMind);
        myMp3Player.play(peaceOfMind);

        myMp3Player.increaseVolume();
        assertEquals(0, myMp3Player.getVolume());
    }

    @Test
    void mp3Player_cannotDecreaseVolume_whenMp3PlayerIsOff(){
        assertFalse(myMp3Player.isOn());
        Music peaceOfMind = new Music();
        myMp3Player.download(peaceOfMind);
        myMp3Player.play(peaceOfMind);

        myMp3Player.decreaseVolume();
        assertEquals(0, myMp3Player.getVolume());
    }

    @Test
    void mp3Player_canHaveAMaximumVolume(){
        myMp3Player.flipPowerButton();
        Music peaceOfMind = new Music();
        myMp3Player.download(peaceOfMind);
        myMp3Player.play(peaceOfMind);

        myMp3Player.increaseVolume();
        assertEquals(21, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(22, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(23, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(24, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(25, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(26, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(27, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(28, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(29, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(30, myMp3Player.getVolume());
        myMp3Player.increaseVolume();
        assertEquals(30, myMp3Player.getVolume());
    }

    @Test
    void mp3Player_canHaveAMinimumVolume(){
        myMp3Player.flipPowerButton();
        Music peaceOfMind = new Music();
        myMp3Player.download(peaceOfMind);
        myMp3Player.play(peaceOfMind);

        myMp3Player.decreaseVolume();
        assertEquals(19, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(18, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(17, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(16, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(15, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(14, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(13, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(12, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(11, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(10, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(9, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(8, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(7, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(6, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(5, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(4, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(3, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(2, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(1, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(0, myMp3Player.getVolume());
        myMp3Player.decreaseVolume();
        assertEquals(0, myMp3Player.getVolume());
    }

    @Test
    void mp3Player_canPlayNextSong(){
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music peaceOfMind = new Music();
        assertNotNull(peaceOfMind);

        myMp3Player.download(peaceOfMind);
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        Music bounce = new Music();
        myMp3Player.download(bounce);
        assertEquals(2, myMp3Player.getTotalNumberMusic());

        myMp3Player.play(peaceOfMind);
        assertEquals(PLAYING, myMp3Player.getMusicState());
        assertEquals(peaceOfMind, myMp3Player.getCurrentlyPlayingMusic());
        myMp3Player.playNextSong();
        assertEquals(bounce, myMp3Player.getCurrentlyPlayingMusic());
    }

    @Test
    void mp3Player_canPlayPreviousSong(){
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music peaceOfMind = new Music();
        assertNotNull(peaceOfMind);

        myMp3Player.download(peaceOfMind);
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        Music bounce = new Music();
        myMp3Player.download(bounce);
        assertEquals(2, myMp3Player.getTotalNumberMusic());

        Music wayTooBig = new Music();
        myMp3Player.download(wayTooBig);
        assertEquals(3, myMp3Player.getTotalNumberMusic());

        Music fall = new Music();
        myMp3Player.download(fall);
        assertEquals(4, myMp3Player.getTotalNumberMusic());

        Music legend = new Music();
        myMp3Player.download(legend);
        assertEquals(5, myMp3Player.getTotalNumberMusic());

        myMp3Player.play(peaceOfMind);
        assertEquals(PLAYING, myMp3Player.getMusicState());
        assertEquals(peaceOfMind, myMp3Player.getCurrentlyPlayingMusic());
        myMp3Player.playPreviousSong();
        assertEquals(legend, myMp3Player.getCurrentlyPlayingMusic());
    }





}
