public class Playlist {
    private static final int MAX_SONGS = 100; // Assumed maximum size
    private String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    public void addSong(String song) {
        if (song == null || songCount >= songs.length) {
            return; // Ignore if null or array is full
        }
        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {
        // Return a copy of the array with only the actual songs
        String[] copy = new String[songCount];
        System.arraycopy(songs, 0, copy, 0, songCount);
        return copy;
    }

    public int getSongCount() {
        return songCount;
    }
}
