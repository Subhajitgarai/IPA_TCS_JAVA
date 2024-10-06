package IPA25;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

class Movie{
    private int movieId;
    private String director;
    private int rating;
    private int budget;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Movie(int movieId, String director, int rating, int budget) {
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", director='" + director + '\'' +
                ", rating=" + rating +
                ", budget=" + budget +
                '}';
    }
}
public class Ipa25 {
    public static Integer findAvgBudgetByDirector(Movie[]movies, String director) {
        Movie[] array1 = Arrays.stream(movies).filter(movie -> movie.getDirector().equalsIgnoreCase(director)).toArray(Movie[]::new);
        Optional<Integer> array = Arrays.stream(movies).filter(movie -> movie.getDirector().equalsIgnoreCase(director)).map(movie -> movie.getBudget()).reduce(Integer::sum);
        if (array.isPresent()) {
            return array.get()/array1.length;
        }
        return 0;
    }
    public static Movie getMovieByRatingBudget(Movie[] movies, int rating, int budget){
        Movie[] array = Arrays.stream(movies).filter(movie -> movie.getRating() == rating && movie.getBudget() == budget && movie.getBudget()%movie.getRating()==0).toArray(Movie[]::new);
        if (array.length>0){
            Movie movie = array[0];
            return movie;
        }
        return null;

    }

    public static void main(String[] args) {
        Movie[] movies=new Movie[4];
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<4;i++){
            int a=sc.nextInt();
            String  b=sc.next();
            int c=sc.nextInt();
            int d=sc.nextInt();
            Movie movie=new Movie(a,b,c,d);
            movies[i]=movie;
        }
        String  director=sc.next();
        int rating=sc.nextInt();
        int budget=sc.nextInt();
        Arrays.stream(movies).forEach(System.out::println);
        Integer avgBudgetByDirector = findAvgBudgetByDirector(movies, director);
        if (avgBudgetByDirector!=0){
            System.out.println(avgBudgetByDirector);
        }
        else {
            System.out.println("Sorry - The given director has not yet directed any movie");
        }
        Movie movieByRatingBudget = getMovieByRatingBudget(movies, rating, budget);
        if (movieByRatingBudget!=null){
            System.out.println(movieByRatingBudget.getMovieId());
        }
        else {
            System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
        }

    }

}
