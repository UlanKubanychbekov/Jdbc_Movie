package peaksoft;

import peaksoft.models.Movie;
import peaksoft.models.ShowTime;
import peaksoft.service.MovieService;
import peaksoft.service.ShowTimeServices;
import peaksoft.service.impl.MovieServiceImpl;
import peaksoft.service.impl.ShowTimeServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        MovieService movieService = new MovieServiceImpl();
        ShowTimeServices showTimeServices = new ShowTimeServiceImpl();
//
        Scanner string = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        while (true){
            switch (new Scanner(System.in).nextLine()){
              case "1","save" ->  {
                  System.out.println("напишите title");
                  String title = string.nextLine();
                  System.out.println("напишите genre");
                  String genre = string.nextLine();
                  System.out.println("напишите duration");
                  int duration = number.nextInt();
                  System.out.println(movieService.saveMovie(new Movie(title, genre, duration)));
              }
              case "2" ->{
                  System.out.println(movieService.findById(1L));
              }
              case "3" -> showTimeServices.saveShow(new ShowTime(1L,2L, LocalDateTime.of
                      (2023,8,8,20,10,0),LocalDateTime.of
                      (2023,8,8,22,10,0)));

            case "4" -> System.out.println(showTimeServices.assign(4L, 1L, 1L));
            }
    }
}}
