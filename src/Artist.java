public abstract class Artist {
        private String name;

        private String song;

        private int year;

        public Artist(String name, String song, int year) {
            this.name = name;
            this.song = song;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSong() {
            return song;
        }

        public void setSong(String song) {
            this.song = song;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", song='" + song + '\'' +
                ", year=" + year +
                '}';
    }
}


