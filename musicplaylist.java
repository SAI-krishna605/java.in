import java.util.LinkedList;

public class musicplaylist {

    static class Song {
        String title, artist, genre;
        int duration;

        Song(String t, String a, String g, int d) {
            title = t; artist = a; genre = g; duration = d;
        }

        public String toString() {
            return title + " | " + artist + " | " + genre + " | " + duration + "s";
        }
    }

    static class Playlist {
        LinkedList<Song> list = new LinkedList<>();

        void add(Song s) { list.add(s); }
        void delete(int i) { if (i >= 0 && i < list.size()) list.remove(i); }
        Song next(int i) { return (i + 1 < list.size()) ? list.get(i + 1) : null; }
        Song prev(int i) { return (i > 0) ? list.get(i - 1) : null; }

        void show() {
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ". " + list.get(i));
        }
    }

    public static void main(String[] args) {

        Playlist p = new Playlist();

        p.add(new Song("Perfect", "Ed Sheeran", "Love", 263));
        p.add(new Song("Tum Hi Ho", "Arijit Singh", "Love", 281));
        p.add(new Song("Kesariya", "Arijit Singh", "Love", 270));

        System.out.println("Playlist:");
        p.show();

        System.out.println("\nNext: " + p.next(0));
        System.out.println("Previous: " + p.prev(2));

        p.delete(1);
        System.out.println("\nAfter Deletion:");
        p.show();
    }
}
