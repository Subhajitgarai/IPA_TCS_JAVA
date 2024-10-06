package IPA31;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

class Music{
   private int playListNo;
   private String type;
   private int count;
   private double duration;

    public Music(int playListNo, String type, int count, double duration) {
        this.playListNo = playListNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }

    public int getPlayListNo() {
        return playListNo;
    }

    public void setPlayListNo(int playListNo) {
        this.playListNo = playListNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Music{" +
                "playListNo=" + playListNo +
                ", type='" + type + '\'' +
                ", count=" + count +
                ", duration=" + duration +
                '}';
    }
}

public class Ipa31 {
    public static int findAvgOfCount(Music[] musics, int count){
        Music[] musicArr=Arrays.stream(musics).filter(music -> music.getCount() > count).toArray(Music[]::new);
        int musicCount=musicArr.length;
        Optional<Integer> sumOfCount = Arrays.stream(musics).filter(music -> music.getCount() > count)
                .map(Music::getCount).reduce(Integer::sum);
        if (sumOfCount.isPresent()){
            int avg=sumOfCount.get()/musicCount;
            return avg;
        }
        else {
            return 0;
        }
    }
    public  static Music[] sortTypeByDuration(Music[] musics, double duration){
        Music[] sortedArrMusic=Arrays.stream(musics).filter(music->music.getDuration()>duration)
                .sorted(Comparator.comparing(Music::getDuration)).toArray(Music[]::new);
        if (musics.length>0){
            return sortedArrMusic;
        }
        else {
            return null;
        }
    }


    public static void main(String[] args) {
        Music[] musicsArr=new Music[4];
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<4;i++){
            int a=Integer.valueOf(sc.nextLine());
            String b=sc.nextLine();
            int c=Integer.valueOf(sc.nextLine());
            double d=Double.valueOf(sc.nextLine());
            Music music=new Music(a,b,c,d);
            musicsArr[i]=music;
        }
        int count=sc.nextInt();
        double duration=sc.nextDouble();
        Arrays.stream(musicsArr).forEach(System.out::println);
        int avgOfCount = findAvgOfCount(musicsArr, count);
        if (avgOfCount>0){
            System.out.println(avgOfCount);
        }
        else {
            System.out.println("No playlist found");
        }
        Music[] music = sortTypeByDuration(musicsArr, duration);
        if (music.length>0) {
            Arrays.stream(music).forEach(music1 -> {
                System.out.println(music1.getType());

            });
        }
        else {
            System.out.println("No playlist found with mentioned attribute");
        }


    }
}
