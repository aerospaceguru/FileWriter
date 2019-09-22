package info.martinoconnell;

import java.io.*;

public class WriteFile {

	public static void main(String[] args) {
	
		Movie[] movies = getMovies();
		
		PrintWriter out = openWriter("movies2.csv");
		
		for (Movie m : movies)
			writeMovie(m, out);
		
		out.close();
	}
	
	private static Movie[] getMovies() {
		
		Movie[] movies = new Movie[3];
		
		movies[0] = new Movie("Its a Wonderful Life", 1946, 14.95);
		movies[1] = new Movie("Young Frankenstein", 1974, 16.95);
		movies[2] = new Movie("Star Wars", 1977, 17.95);
		
		return movies;
	}
	
	private static PrintWriter openWriter(String name) {
		
		try {
			
			File file = new File(name);
			PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter (file) ), true );
			
			return out;
		}
		
		catch (IOException e)
		{
			System.out.println("I/O Error");
			System.exit(0);
		}
		
		return null;
	}
	
	private static void writeMovie(Movie m, PrintWriter out) {
		
		String line = m.title;
		line += "," + Integer.toString(m.year);
		line += "," + Double.toString(m.price);
		out.println(line);
	}

	private static class Movie {
		
		public String title;
		public int year;
		public double price;
		
		public Movie(String title, int year, double price) {
			
			this.title = title;
			this.year = year;
			this.price = price;
		}
		
	}
}
