package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private final List<Channel> channels = new ArrayList<>();

    public void readDataFromFile(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            bufferedReader.readLine();

            while (bufferedReader.ready()) {
                channels.add(parseLine(bufferedReader.readLine()));
            }

        } catch (IOException ioException) {
            throw new IllegalArgumentException("Cannot open file for read!", ioException);
        }
    }

    public int calculateSumOfVideos() {
        int sum = 0;
        for (Channel channel : channels) {
            sum += channel.getNumberOfVideos();
        }
        return sum;
    }

    private Channel parseLine(String line) {
        String[] cells = line.split(";");
        String nameOfChannel = cells[0];
        int subscriptions = Integer.parseInt(cells[1]);
        int numberOfVideos = Integer.parseInt(cells[2]);
        return new Channel(nameOfChannel, subscriptions, numberOfVideos);
    }

    public List<Channel> getChannels() {
        return this.channels;
    }
}