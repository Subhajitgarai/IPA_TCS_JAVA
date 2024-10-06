package IPA37;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

class Song{
    private int songId;
    private String title;
    private String artist;
    private double duration;

    public Song(int songId, String title, String artist, double duration) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration +
                '}';
    }
}
public class Ipa37 {
    public static Double findSongDurationForArtist(Song[] songs, String artist){
       Optional<Double> sum= Arrays.stream(songs).filter(song->song.getArtist().equalsIgnoreCase(artist))
                .map(Song::getDuration).reduce(Double::sum);
       if (sum.isPresent()){
           return sum.get();
       }
       return null;

    }
    public static Song[] getSongsInAscendingOrder(Song[] songs, String artist){
        Song[] sortedByDuration = Arrays.stream(songs).filter(song -> song.getArtist().equalsIgnoreCase(artist))
                .sorted(Comparator.comparing(Song::getDuration))
                .toArray(Song[]::new);
        if (sortedByDuration.length>0){
            return sortedByDuration;
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Song[] songs=new Song[5];
        for (int i=0;i<5;i++){
            int a=Integer.valueOf(sc.nextLine());
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=Double.valueOf(sc.nextLine());
            Song song=new Song(a,b,c,d);
            songs[i]=song;
        }
        String artist=sc.nextLine();
        String artist1=sc.nextLine();
        Arrays.stream(songs).forEach(System.out::println);
        Double songDurationForArtist = findSongDurationForArtist(songs, artist);
        if (songDurationForArtist!=null){
            System.out.println(songDurationForArtist);
        }
        else {
            System.out.println("There are no songs with given artist");
        }
        Song[] songsInAscendingOrder = getSongsInAscendingOrder(songs, artist1);
        if (songsInAscendingOrder!=null){
            Arrays.stream(songsInAscendingOrder).forEach(song -> {
                System.out.println(song.getSongId());
                System.out.println(song.getTitle());
            });
        }
        else {
            System.out.println("There are no songs with given artist");
        }
    }
}
