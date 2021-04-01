package africa.semicolon.mp3;

import java.util.ArrayList;

import static africa.semicolon.mp3.MusicState.*;

public class Mp3Player {
    private boolean isOn;
    private ArrayList< Music > musiclist = new ArrayList<>();
    private Music currentlyPlayingMusic;
    private MusicState currentMusicState = STOPPED;
//    private Music [] musiclist = new Music[10];
    private int totalNumberOfMusic;
    private int volume;

    public boolean isOn() {
        return isOn;
    }



    public void flipPowerButton() {
        volume = 20;
        isOn = !isOn;
    }

    public void download(Music music) {
        if (isOn)
            if (!musiclist.contains(music))
        musiclist.add(music);

    }

    public int getTotalNumberMusic() {
        return musiclist.size();
    }

    public void delete(Music music) {
        if (isOn)
        if (totalNumberOfMusic >= 1)
        musiclist.remove(music);
    }

    public void play(Music ajibole) {
        if (isOn) {
            currentlyPlayingMusic = ajibole;
            currentMusicState = PLAYING;
        }


    }

    public MusicState getMusicState() {
        return currentMusicState;
    }

    public Music getCurrentlyPlayingMusic() {
        return currentlyPlayingMusic;
    }

    public void pauseMusic() {
        currentMusicState = PAUSED;
    }

    public void stopMusic() {
        currentMusicState = STOPPED;
    }

    public void flipPlayAndPauseButton() {
        if (isOn){
            if (currentMusicState == PAUSED)
                currentMusicState = PLAYING;

            else if (currentMusicState == PLAYING)
                currentMusicState = PAUSED;

        }
    }

    public void increaseVolume() {
        if (isOn) {
            if (volume < 30)
                volume++;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void decreaseVolume() {
        if (isOn)
            if (volume > 0)
                volume--;
    }

    public void playNextSong() {
        if (isOn)
            for (int i = 0; i < musiclist.size(); i++) {
                if (musiclist.get(i).equals(currentlyPlayingMusic)) {
                    currentlyPlayingMusic = musiclist.get(i + 1);
                    break;
                }
            }
    }

    public void playPreviousSong() {
        if (isOn)
            for (int i = 1; i < musiclist.size(); i++) {
                if (musiclist.get(i).equals(currentlyPlayingMusic)) {
                    currentlyPlayingMusic = musiclist.get(i - 1);
                    break;
                }
            }
                    if (currentlyPlayingMusic == musiclist.get(0) ) {
                        currentlyPlayingMusic = musiclist.get(musiclist.size() - 1);
                    }

    }
}
